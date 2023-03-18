package org.anea.app;

import java.util.ArrayList;

import org.anea.app.Utilitis.Utilitis;
import org.anea.app.controller.Empleados;
import org.anea.app.controller.Material;
import org.anea.app.view.MostrarPantalla;
import org.anea.app.controller.Coste;

public class Main {
    public static void main(String[] args) {
        String datosEmpleados[] = Utilitis.buscarDatoFicheroLinea("empleados.txt");
        String datosMateriales[] = Utilitis.buscarDatoFicheroLinea("materials.txt");

        ArrayList<Material> materiales = new ArrayList<>();
        ArrayList<Empleados> empleados = new ArrayList<>();
        empleados = Utilitis.crearEmpleado(datosEmpleados);
        materiales = Utilitis.crearMateriales(datosMateriales);


        MostrarPantalla.mostrarTrabajadores(empleados);

        Coste costeEmpleados = new Coste(materiales, empleados);

        costeEmpleados.pAsignaPorcentaje();
        costeEmpleados.pAgregarDineroHijos();
        costeEmpleados.pAgregarDineroTiempo();
        costeEmpleados.pAgregarIrpf();
        costeEmpleados.pAsignarMateriales();

        MostrarPantalla.mostrarMaterialesEmpleado(costeEmpleados.getEmpleados());
        MostrarPantalla.mostrarDineroTotalGatadoEmpresa(costeEmpleados.getEmpleados());
        MostrarPantalla.mostrarSueldoNetoMedio(costeEmpleados.getEmpleados());
        MostrarPantalla.mostrarMediaHijos(costeEmpleados.getEmpleados());
        MostrarPantalla.mostrarNumeorEmpleadosCategorio(costeEmpleados.getEmpleados());
        MostrarPantalla.mostrarEmpleadoMayorSueldo(costeEmpleados.getEmpleados());

    }
}