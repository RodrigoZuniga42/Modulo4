package objetos;

import interfaces.Equipable;
import personajes.Personaje;

public abstract class Objeto implements Equipable {
    protected String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public abstract void equipar(Personaje personaje);

    @Override
    public abstract void usar(Personaje personaje);
}