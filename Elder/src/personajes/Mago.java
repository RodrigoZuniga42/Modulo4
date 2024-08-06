package personajes;

import interfaces.Atacable;
import interfaces.Combatiente;

public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int salud, int fuerza, int defensa, int mana) {
        super(nombre, salud, fuerza, defensa);
        this.mana = mana;
    }

    @Override
    public void ataqueEspecial(Combatiente enemigo) {
        if (mana >= 10) {
            if (enemigo instanceof Atacable) {
                ((Atacable) enemigo).recibirAtaque(getFuerza() * 3);
            }
            mana -= 10;
        } else {
            System.out.println("No hay suficiente mana.");
        }
    }

    public int getMana() {
        return mana;
    }
}