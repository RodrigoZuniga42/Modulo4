import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import monstruos.Dragon;
import monstruos.Monstruo;
import interfaces.Combatiente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArchivoUtil {

    private static final Pattern PATRON_PERSONAJE = Pattern.compile("Personaje,\\w+,\\d+,\\d+,\\d+(,\\d+)?");
    private static final Pattern PATRON_MONSTRUO = Pattern.compile("Monstruo,\\w+,\\d+,\\d+");



    public static List<Combatiente> leerArchivo(String nombreArchivo) {



        List<Combatiente> combatientes = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (PATRON_PERSONAJE.matcher(linea).matches()) {
                    String[] partes = linea.split(",");
                    String tipo = partes[0];
                    String nombre = partes[1];
                    int salud = Integer.parseInt(partes[2]);
                    int fuerza = Integer.parseInt(partes[3]);
                    int defensa = Integer.parseInt(partes[4]);
                    if (partes.length == 6) {
                        int mana = Integer.parseInt(partes[5]);
                        combatientes.add(new Mago(nombre, salud, fuerza, defensa, mana));
                    } else {
                        combatientes.add(new Guerrero(nombre, salud, fuerza, defensa));
                    }
                } else if (PATRON_MONSTRUO.matcher(linea).matches()) {
                    String[] partes = linea.split(",");
                    String tipo = partes[0];
                    String nombre = partes[1];
                    int salud = Integer.parseInt(partes[2]);
                    int ataque = Integer.parseInt(partes[3]);
                    combatientes.add(new Dragon(nombre, salud, ataque));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return combatientes;
    }

    public static void escribirArchivo(String nombreArchivo, List<Combatiente> combatientes) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            for (Combatiente combatiente : combatientes) {
                if (combatiente instanceof Personaje) {
                    Personaje p = (Personaje) combatiente;
                    if (p instanceof Mago) {
                        escritor.write(String.format("Personaje,%s,%d,%d,%d,%d%n",
                                p.getNombre(), p.getSalud(), p.getFuerza(), p.getDefensa(), ((Mago) p).getMana()));
                    } else {
                        escritor.write(String.format("Personaje,%s,%d,%d,%d%n",
                                p.getNombre(), p.getSalud(), p.getFuerza(), p.getDefensa()));
                    }
                } else if (combatiente instanceof Monstruo) {
                    Monstruo m = (Monstruo) combatiente;
                    escritor.write(String.format("Monstruo,%s,%d,%d%n",
                            m.getTipo(), m.getSalud(), m.getAtaque()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}