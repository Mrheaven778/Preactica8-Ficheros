package org.anea.app.Utilitis;

import org.anea.app.controller.Empleados;
import org.anea.app.controller.Material;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utilitis {

    /**
     * Busca un dato en un fichero y lo devuelve
     * @param nombreFichero nombre del fichero
     * @return dato encontrado
     */
    public static String[] buscarDatoFicheroLinea(String nombreFichero) {
        File fichero = new File(nombreFichero);
        try (FileReader reader = new FileReader(fichero);
             BufferedReader bufferedReader = new BufferedReader(reader);) {
            String linea = "";

            int i = 1;
            String f = "";

            while (linea != null) {
                linea = bufferedReader.readLine();
                String[] datos = linea.split(",");
                return datos;
            }
            return null;
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
//            throw new RuntimeException(e);
            return null;
        }
    }

    /**
     * Crea un array de materiales
     * @param datosMateriales array de datos de materiales
     * @return array de materiales
     */
    public static ArrayList<Material> crearMateriales(String[] datosMateriales) {
        ArrayList<Material> materiales = new ArrayList<>();
        for (int i = 0; i < datosMateriales.length; i++) {
            String nombreMaterial = datosMateriales[i];
            int cantidadMaterial = 0;
            if (i % 2 == 0 || i == 0) {
                 cantidadMaterial = Integer.parseInt(datosMateriales[i + 1]);
            }
            while (cantidadMaterial != 0) {
                materiales.add(new Material(nombreMaterial));
                cantidadMaterial--;
            }
        }
        return materiales;
    }

    /**
     * Crea un array de empleados
     * @param datosEmpleados array de datos de empleados
     * @return array de empleados
     */
    public static ArrayList<Empleados> crearEmpleado(String[] datosEmpleados) {
        ArrayList<Empleados> empleados = new ArrayList<>();
        for (int i = 0; i < datosEmpleados.length; i++) {
            String nombreEmpleado = datosEmpleados[i];
            if (i % 4 == 0 || i == 0) {
                String apellidoEmpleado = datosEmpleados[i + 1];
                int edadEmpleado = Integer.parseInt(datosEmpleados[i + 2]);
                float sueldoEmpleado = Float.parseFloat(datosEmpleados[i + 3]);
                empleados.add(new Empleados(nombreEmpleado, apellidoEmpleado, sueldoEmpleado, edadEmpleado));
            }
        }
        return empleados;
    }

    /**
     * Pide un dato por teclado
     * @return dato introducido
     */
    public static String pedirDato() {
        String dato = "";
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            dato = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el dato");
        }
        return dato;
    }

    /**
     * Pide un numero por teclado
     * @param mensaje mensaje a mostrar
     * @return numero introducido
     */
    public static int pedirNumero(int mensaje) {
        int numero = 0;
        boolean error = false;
        do {
            try {
                numero = Integer.parseInt(Utilitis.pedirDato());
                error = false;
            } catch (NumberFormatException e) {
                System.err.println("Error, no has introducido un numero");
                error = true;
            }
        } while (error);
        return numero;
    }


}
