package objetos;

import personajes.Personaje;

public class Arma extends Objeto {
    private int dano;

    public Arma(String nombre, int dano) {
        super(nombre);
        this.dano = dano;
    }

    @Override
    public void equipar(Personaje personaje) {
        personaje.aumentarFuerza(dano);
    }

    @Override
    public void usar(Personaje personaje) {
        // pendiente
    }

    public int getDano() {
        return dano;
    }
}