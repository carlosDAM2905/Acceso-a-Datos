package manejodeficheros.ejerciciospowerpoint.ejercicio7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio7 {
    public static void main(String[] args) {

        String[] apellidos = {"Gomez", "Sanchez", "Garcia", "Cordoba"}; //array con los apellidos

        int[] departamento = {20, 30, 40, 50}; //array con los departamentos

        double[] salario = {1300, 1400.50, 1500, 1600.80}; //array con los salarios

        try (RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "rw")) {

            for (int i = 0; i < apellidos.length; i++) {

                fichero.writeInt(i + 1); //escribimos el identificador

                String apellido = String.format("%-10s", apellidos[i]).substring(0, 10); //formateamos los apellidos para que tengan 10 caracteres siempre

                fichero.writeChars(apellido); // y escribimos los apellidos

                fichero.writeInt(departamento[i]); //esribimos los departamentos de cada empleado

                fichero.writeDouble(salario[i]); // escribimos los salarios
            }

            System.out.println("Fichero creado con éxito");
            
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }


        // leer el archivo:

        try (RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "r")) {

            while (fichero.getFilePointer() < fichero.length()) {
                //leer el identificador:
                int id = fichero.readInt();

                //leer el apellido:
                String apellido = "";

                for (int i = 0; i < 10; i++) {
                    apellido += fichero.readChar();
                }

                //leer el departamento:
                int departamentoLeido = fichero.readInt();

                //leer el salario
                double salarioLeido = fichero.readDouble();

                // mostrar los datos leidos:

                System.out.println("ID: " + id);
                System.out.println("Apellido: " + apellido.trim()); // Trim para eliminar espacios en blanco adicionales
                System.out.println("Departamento: " + departamentoLeido); // Usamos la nueva variable para mostrar el departamento
                System.out.println("Salario: " + salarioLeido);
                System.out.println("---------------------------");
            }


        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }




    }
}
