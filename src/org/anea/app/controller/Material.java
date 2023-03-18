package org.anea.app.controller;

public class Material {
    private static int siguienteID = 1;
    private int idMaterial;
    private String nombre;
    private boolean asignado;

    public Material(String nombre) {
        this.nombre = nombre;
        this.idMaterial = siguienteID;
        siguienteID++;
    }

    public Material(int idMaterial, String nombre) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
}
