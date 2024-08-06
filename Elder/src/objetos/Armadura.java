package objetos;

import personajes.Personaje;

public class Armadura extends Objeto {
    private int defensa;

    public Armadura(String nombre, int defensa) {
        super(nombre);
        this.defensa = defensa;
    }

    @Override
    public void equipar(Personaje personaje) {
        personaje.aumentarDefensa(defensa);
    }

    @Override
    public void usar(Personaje personaje) {
        // Pendiente
    }

    public int getDefensa() {
        return defensa;
    }
}