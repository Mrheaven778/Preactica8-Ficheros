package org.anea.app.controller;

import java.util.ArrayList;
import java.util.Scanner;


public class Empleados {
    private static int siguienteID = 1; // id del empleado
    private int idUsuari;
    private final String nombre;
    private int edad;
    private final String apellido;
    private float sueldo;
    private int irpf = 10; // irpf por defecto 10%
    private float sueldoNeto;
    private int antiquity = 0; // antiguedad del empleado por defecto 0 años
    private String cargo = "junior"; // cargo del empleado por defecto junior
    private float dineroMateriales = 0; // dinero que gana el empleado por los materiales que usa por defecto 0
    private int hijos = 0; // numero de hijos por defecto 0 hijos
    private int vacaciones = 4; // 4 semanas de vacaciones
    private ArrayList<Material> materials = new ArrayList<>();

    public Empleados(String nombre, String apellido, float sueldo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.edad = edad;
        idUsuari = siguienteID;
        siguienteID++;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public float getDineroMateriales() {
        return dineroMateriales;
    }

    public void setDineroMateriales(float dineroMateriales) {
        this.dineroMateriales = dineroMateriales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(float sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }


    /**
     * Este metodo calculara el dinero total que debemos por cada ano trabajado
     *
     * @return int de la cantidad total
     */
    public int mCalcularTiempotrabajado() {
        int cantidadAPagar = 0;
        if (this.antiquity > 0) {
            cantidadAPagar = 20 * this.antiquity * 12;
        }
        return cantidadAPagar;
    }

    /**
     * Este metodo calculara el dinero total que debemos pagar por cada hijo del
     * trabajador al ano
     *
     * @return int el dinero total al ano
     */
    public int mCalcularDineroHijos() {
        int cantidadPagar = 0;
        if (this.hijos > 0) {
            cantidadPagar = 10 * this.hijos * 12;
        }
        return cantidadPagar;
    }

    /**
     * Este metodo calcuara el Irpf dependiedo del sueldo si supera los 15000 euros
     * se le aplicara un 12 irpf y por cada 5000 2 porcietno mas
     *
     * @return float el sueldo neto
     */
    public float mCalcularIrpf() {
        int superaIrpf = 5000;
        // Esta variable es para saber el numeor de veces que hay que sumer 2
        float vuletasIrpf = 0;
        this.sueldoNeto = this.sueldo;
        // con esto si supera los 20000 aplicaremos el numero do irpf que se supere
        if (this.sueldoNeto >= 15000 + superaIrpf) {
            vuletasIrpf = (sueldoNeto - 15000) / superaIrpf;
            for (int i = 1; i < vuletasIrpf; i++) {
                this.irpf += 2;
            }
        }
        return this.sueldoNeto - ((this.sueldoNeto * this.irpf) / 100);
    }

    public void pAsignarCargo() {
        String cargoAsignar = " ";
        byte repetirPregunta = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Que cargo desa asignar: ");
            cargoAsignar = sc.nextLine();
            if (Empleados.comprbarCategoria(cargoAsignar)) {
                this.cargo = cargoAsignar;
                repetirPregunta = 1;
            } else {
                System.err.println("El cargo asignado no exite porfa introduca uno de estos\n" +
                        "junior, senior, manager o arquitecto");
                repetirPregunta = 0;
            }
        } while (repetirPregunta == 0);
    }

    /**
     * Miramos si el cargo que ponga el usuario exite
     *
     * @param cargoComparar
     * @return boolean true si exite el cargo falso si no exite
     */
    public static boolean comprbarCategoria(String cargoComparar) {
        switch (cargoComparar) {
            case "junior":
                return true;
            case "senior":
                return true;
            case "manager":
                return true;
            case "arquitecto":
                return true;
            default:
                return false;
        }
    }
}