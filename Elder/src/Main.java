import personajes.Personaje;
import interfaces.Combatiente;
import monstruos.Monstruo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Combatiente> combatientes = ArchivoUtil.leerArchivo("combatientes.txt");
        if (combatientes.size() < 2) {
            System.err.println("No hay suficientes combatientes en el archivo.");
            return;
        }

        Combatiente personaje = combatientes.get(0);
        Combatiente monstruo = combatientes.get(1);

        Combate.iniciarCombate(personaje, monstruo);

        ArchivoUtil.escribirArchivo("combatientes.txt", combatientes);
    }
}