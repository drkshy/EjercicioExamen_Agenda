package com.pperezm;

public class Contacto {
    private String nombre,direccion,correo,categoria;
    private long telefono;


    public Contacto()
    {
        this.nombre=null;
        this.telefono=0;
        this.direccion=null;
        this.correo = null;
        this.categoria =null;

    }
    public Contacto(String nombre, long telefono, String direccion, String correo, String cat) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.categoria = cat;
    }
    public void setNombre(String nomb){
        this.nombre=nomb.toUpperCase();
    }
    public void setTelefono(long telf){
        this.telefono=telf;
    }

    public String getNombre() {
        return this.nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setDireccion(String direccionDom){
        this.direccion = direccionDom.toUpperCase();
    }
    public void setCategoria(String category){
        this.categoria = category.toUpperCase();
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String email){
        this.correo =email;
    }

    public String getDireccion() {
        return this.direccion;
    }

}
