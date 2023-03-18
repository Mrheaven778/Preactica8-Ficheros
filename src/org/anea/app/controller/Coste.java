package org.anea.app.controller;

import java.util.ArrayList;


public class Coste {
    private ArrayList<Material> materials = new ArrayList<>();
    private ArrayList<Empleados> empleados = new ArrayList<>();

    public Coste(ArrayList<Material> materials, ArrayList<Empleados> empleados) {
        this.materials = materials;
        this.empleados = empleados;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleados> empleados) {
        this.empleados = empleados;
    }

    /**
     * Con este metodo asignaremos los porcentajes que tiene cada cargo
     */
    public void pAsignaPorcentaje() {
        // asignamos el porcentaje a cada empleado
        for (Empleados empleado : empleados) {

            // asignamos el porcentaje a junior 5%
            if (empleado.getCargo().equals("junior")) {
                empleado.setSueldo(empleado.getSueldo() + ((empleado.getSueldo() * 5) / 100));
            }

            // asignamos el porcentaje a senior 10%
            if (empleado.getCargo().equals("senior")) {
                empleado.setSueldo(empleado.getSueldo() + ((empleado.getSueldo() * 10) / 100));
            }

            // asignamos el porcentaje a manager 12%
            if (empleado.getCargo().equals("manager")) {
                empleado.setSueldo(empleado.getSueldo() + ((empleado.getSueldo() * 12) / 100));
            }

            // asignamos el porcentaje a arquitecto 25%
            if (empleado.getCargo().equals("arquitecto")) {
                empleado.setSueldo(empleado.getSueldo() + ((empleado.getSueldo() * 25) / 100));
            }
        }
    }

    /**
     * con este procedimiento agregamos el sueldo trabajado por ano al trabajador
     */
    public void pAgregarDineroTiempo() {
        for (Empleados empleado : empleados) {
            // sumamos el sueldo trabajado por ano al sueldo del empleado y lo guardamos en sueldo neto
            empleado.setSueldo(empleado.getSueldo() + empleado.mCalcularTiempotrabajado());
        }
    }

    /**
     * Con este procedimiento agregamos el sueldo por hijo
     */
    public void pAgregarDineroHijos() {
        for (Empleados empleado : empleados) {
            // sumamos el sueldo por hijo al sueldo del empleado y lo guardamos en sueldo neto
            empleado.setSueldo(empleado.getSueldo() + empleado.mCalcularDineroHijos());
        }
    }

    /**
     * con este procedimineto agregamos el Irpf a cada emleado
     */
    public void pAgregarIrpf() {
        for (Empleados empleado : empleados) {
            // calculamos el irpf y lo guardamos en sueldo neto
            empleado.setSueldoNeto(empleado.mCalcularIrpf());
        }
    }

    /**
     * Con este metodo asignaremos materiales al empleado y sumaremos el coste del
     * mismo
     */
    public void pAsignarMateriales() {

        for (Empleados empleado : empleados) {

            // si es junior se le asignara un portatil de tipo 1 y se le sumara el coste del mismo
            if (empleado.getCargo().equals("junior")) {
                ArrayList<Material> materialesEmpleado = new ArrayList<>();
                // recoreremos cada uno de los materiales que tengamos para buscar el maretiarl que queremos
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getNombre().equals("Portatil tipo 1") && !materials.get(i).isAsignado()) {
                        // le sumamos el coste del material asignado y no ponemos en uso para no darselo a nadie mas
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(500 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Portatil tipo 1"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }
            }

            if (empleado.getCargo().equals("senior")) {

                ArrayList<Material> materialesEmpleado = new ArrayList<>();
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getNombre().equals("Portatil tipo 2") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(800 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Portatil tipo 2"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }
            }

            if (empleado.getCargo().equals("arquitecto")) {
                ArrayList<Material> materialesEmpleado = new ArrayList<>();
                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Portatil tipo 3") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(1000 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Portatil tipo 3"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }

                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Telefono tipo 1") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(300 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Telefono tipo 1"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }

                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Coche") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        // hacemos 500 por 48 ya que que cada semana se paga 500 euros entoces al ano
                        // son 52 menos 4 semanas de vacaciones entices que queda en 38
                        empleado.setDineroMateriales((500 * (52-empleado.getVacaciones()))+ empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Coche"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }
            }
            if (empleado.getCargo().equals("manager")) {
                ArrayList<Material> materialesEmpleado = new ArrayList<>();
                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Telefono tipo 2") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(1000 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Telefono tipo 2"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }

                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Portatil tipo 4") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        empleado.setDineroMateriales(2000 + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Portatil tipo 4"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }

                for (int i = 0; i < materials.size(); i++) {

                    if (materials.get(i).getNombre().equals("Coche") && !materials.get(i).isAsignado()) {
                        materials.get(i).setAsignado(true);
                        // hacemos 1000 por 48 ya que que cada semana se paga 1000 euros entoces al ano
                        // son 52 semanas
                        empleado.setDineroMateriales((1000 * 52) + empleado.getDineroMateriales());
                        materialesEmpleado.add(new Material(materials.get(i).getIdMaterial(), "Coche"));
                        empleado.setMaterials(materialesEmpleado);
                        i = materials.size();
                    }

                }
            }
        }
    }
}
