import personajes.Mago;
import personajes.Personaje;
import interfaces.Combatiente;
import monstruos.Monstruo;

import java.util.List;
import java.util.Scanner;

public class Combate {

    public static void iniciarCombate(Combatiente personaje, Combatiente monstruo) {
        Scanner scanner = new Scanner(System.in);
        while (personaje.estaVivo() && monstruo.estaVivo()) {
            System.out.println("Turno del personaje. Elige una acción: 1. Ataque Básico 2. Ataque Especial 3. Usar Objeto");
            String accionInput = scanner.nextLine();
            if (!accionInput.matches("[1-3]")) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }
            int accion = Integer.parseInt(accionInput);
            if (accion == 1) {
                personaje.ataqueBasico(monstruo);
            } else if (accion == 2) {
                personaje.ataqueEspecial(monstruo);
            } else if (accion == 3) {
                System.out.println("Elige un objeto para usar:");
                // Pendiente
            }

            if (monstruo.estaVivo()) {
                monstruo.ataqueEspecial(personaje);
            }
            System.out.println("Fuerza de "+  ((Personaje) personaje).getNombre() +": " + ((Personaje) personaje).getFuerza());
            System.out.println("Defensa de "+  ((Personaje) personaje).getNombre() +": " + ((Personaje) personaje).getDefensa());

            System.out.println("Salud de "+  ((Personaje) personaje).getNombre() +": " + ((Personaje) personaje).getSalud());
            if (personaje instanceof Mago) {
                System.out.println("Mana del Mago: " + ((Mago) personaje).getMana());
            }
            System.out.println("Salud de "+  ((Monstruo) monstruo).getTipo() +": " + ((Monstruo) monstruo).getSalud());
        }

        if (personaje.estaVivo()) {
            System.out.println( ((Personaje) personaje).getNombre() + " ha ganado!");
        } else {
            System.out.println(((Monstruo) monstruo).getTipo() + " ha ganado!");
        }
        scanner.close();
    }
}