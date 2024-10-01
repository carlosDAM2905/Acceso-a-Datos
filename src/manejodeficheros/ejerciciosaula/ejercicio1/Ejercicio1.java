package manejodeficheros.ejerciciosaula.ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*
            Escribir un programa en Java que para cualquier ruta indicada por el usuario,
muestre:
 Si el fichero existe o no
 Si se trata de un directorio o de un fichero
 En caso de ser un fichero, debe mostrar los siguientes datos:
o Nombre
o Tamaño
o Permisos de lectura y escritura
         */

        System.out.println("Escribe el nombre del fichero");
        Scanner teclado = new Scanner(System.in);

        String ruta = "src/manejodeficheros/ejerciciosaula/ejercicio1/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero existe");

            if (fichero.isDirectory()) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("Es un fichero");
                System.out.println("Nombre del fichero: " + fichero.getName());
                System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
                System.out.println("Read " + fichero.canRead());
                System.out.println("Write " + fichero.canWrite());
            }

        } else {
            System.out.println("El fichero no existe");
        }
    }
}
