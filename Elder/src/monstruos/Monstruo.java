package monstruos;

import interfaces.Atacable;
import interfaces.Combatiente;

public abstract class Monstruo implements Combatiente, Atacable {
    private String nombre;
    private String tipo;
    private int salud;
    private int ataque;

    public Monstruo(String tipo, int salud, int ataque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
    }

    @Override
    public void recibirAtaque(int dano) {
        salud -= dano;
    }

    @Override
    public boolean estaVivo() {
        return salud > 0;
    }

    @Override
    public void ataqueBasico(Combatiente enemigo) {
        if (enemigo instanceof Atacable) {
            ((Atacable) enemigo).recibirAtaque(ataque);
        }
    }

    @Override
    public abstract void ataqueEspecial(Combatiente enemigo);

    public String getTipo() {
        return tipo;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }



}