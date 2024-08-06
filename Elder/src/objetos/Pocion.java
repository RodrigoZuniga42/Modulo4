package objetos;

import personajes.Personaje;

public class Pocion extends Objeto {
    private int cura;

    public Pocion(String nombre, int cura) {
        super(nombre);
        this.cura = cura;
    }

    @Override
    public void equipar(Personaje personaje) {
        // Las pociones no se equipan, se usan directamente
    }

    @Override
    public void usar(Personaje personaje) {
        personaje.recuperarSalud(cura);
    }

    public int getCura() {
        return cura;
    }
}
