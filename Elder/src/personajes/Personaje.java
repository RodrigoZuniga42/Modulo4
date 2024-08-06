package personajes;

import interfaces.Atacable;
import interfaces.Combatiente;
import objetos.Objeto;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements Combatiente, Atacable {
    private String nombre;
    private int salud;
    private int fuerza;
    private int defensa;
    private List<Objeto> inventario;
    private Objeto armaEquipada;
    private Objeto armaduraEquipada;

    public Personaje(String nombre, int salud, int fuerza, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void recibirAtaque(int dano) {
        int danoReal = dano - defensa;
        salud -= (danoReal > 0) ? danoReal : 0;
    }

    @Override
    public boolean estaVivo() {
        return salud > 0;
    }

    public void agregarObjeto(Objeto objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
        inventario.add(objeto);
    }

    public void equiparObjeto(Objeto objeto) {
        objeto.equipar(this);
        if (objeto instanceof objetos.Arma) {
            armaEquipada = objeto;
        } else if (objeto instanceof objetos.Armadura) {
            armaduraEquipada = objeto;
        }
    }

    public void usarObjeto(Objeto objeto) {
        objeto.usar(this);
        // Pendiente
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (Objeto objeto : inventario) {
            System.out.println("- " + objeto.getNombre());
        }
    }

    public void aumentarFuerza(int cantidad) {
        fuerza += cantidad;
    }

    public void aumentarDefensa(int cantidad) {
        defensa += cantidad;
    }

    public void recuperarSalud(int cantidad) {
        salud += cantidad;
        if (salud > 100) salud = 100; // Salud máxima
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void ataqueBasico(Combatiente enemigo) {
        if (enemigo instanceof Atacable) {
            ((Atacable) enemigo).recibirAtaque(fuerza);
        }
    }

    @Override
    public abstract void ataqueEspecial(Combatiente enemigo);
}