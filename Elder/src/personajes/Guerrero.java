package personajes;

import interfaces.Atacable;
import interfaces.Combatiente;

public class Guerrero extends Personaje {

    public Guerrero(String nombre, int salud, int fuerza, int defensa) {
        super(nombre, salud, fuerza, defensa);
    }

    @Override
    public void ataqueEspecial(Combatiente enemigo) {
        if (enemigo instanceof Atacable) {
            ((Atacable) enemigo).recibirAtaque(getFuerza() + 10);
        }
    }
}