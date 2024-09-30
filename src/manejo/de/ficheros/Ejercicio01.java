package manejo.de.ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        /*
        Crea un fichero en Java que cree un fichero de texto
        llamado miFichero.txt en la ruta que especifiques
         */

        String ruta = "C:\\Users\\wicar\\Desktop\\DAM\\SEGUNDO\\ACCESO A DATOS\\Ejercicio crear fichero\\miFichero.txt";

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero ya existe");
        } else {
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito");
                }

            } catch (IOException e) {
                System.out.println("No se ha podido crear el fichero " + e.getMessage());
            }
        }


    }
}
