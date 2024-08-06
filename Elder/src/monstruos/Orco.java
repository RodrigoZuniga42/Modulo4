package monstruos;

import interfaces.Atacable;
import interfaces.Combatiente;

public class Orco extends Monstruo {

    public Orco(String tipo, int salud, int ataque) {
        super(tipo, salud, ataque);
    }

    @Override
    public void ataqueEspecial(Combatiente enemigo) {
        if (enemigo instanceof Atacable) {
            ((Atacable) enemigo).recibirAtaque(getAtaque() + 15);
        }
    }
}