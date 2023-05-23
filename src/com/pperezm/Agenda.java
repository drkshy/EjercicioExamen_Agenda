package com.pperezm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Agenda {
    Contacto[] listaContactos = new Contacto[99];
    private int contadorContactos = 0;
    public void Consultar(String nombre, long telefono, String direccion, String correo, String categoria) {
        for (int i = 0; i < this.contadorContactos; i++) {

            if (nombre.equals(this.listaContactos[i].getNombre())) {
                System.out.println("Ya existe un contacto con ese nombre");
            }
        }

    }

    public void Anadir(String nombre, long telefono, String direccion, String correo, String categoria) {
        if (contadorContactos < 99) {
            this.listaContactos[contadorContactos] = new Contacto();
            this.listaContactos[contadorContactos].setNombre(nombre);
            this.listaContactos[contadorContactos].setTelefono(telefono);
            this.listaContactos[contadorContactos].setDireccion(direccion);
            this.listaContactos[contadorContactos].setCorreo(correo);
            this.listaContactos[contadorContactos].setCategoria(categoria);
            this.contadorContactos++;
            Ordenar();
        } else {
            System.out.println("La agenda está llena");
        }

    }

    public void Buscar(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < contadorContactos; i++) {
            if (nombre.equals(this.listaContactos[i].getNombre())) {
                System.out.println("Nombre: " + this.listaContactos[i].getNombre() + "-" +
                        " Telefono: " + Long.toString(this.listaContactos[i].getTelefono())+
                        " Direccion: " + this.listaContactos[i].getDireccion() +
                        " Correo: " + this.listaContactos[i].getCorreo() +
                        " Categoria: " + this.listaContactos[i].getCategoria()
                );
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto inexistente");
        }
    }

    public void Ordenar() {

        int N = this.contadorContactos;
        String nombre1;
        String nombre2;
        if (contadorContactos >= 2) {
            for (int i = 1; i <= N - 1; i++) {
                for (int j = 1; j <= N - i; j++) {
                    nombre1 = this.listaContactos[j - 1].getNombre();
                    nombre2 = this.listaContactos[j].getNombre();
                    if (nombre1.charAt(0) > nombre2.charAt(0)) {
                        Contacto tmp = this.listaContactos[j - 1];
                        this.listaContactos[j - 1] = this.listaContactos[j];
                        this.listaContactos[j] = tmp;
                    }
                }
            }
        }
    }

    public void Mostrar() {
        if (this.contadorContactos == 0) {
            System.out.println("No hay contactos");
        } else {
            for (int t = 0; t < this.contadorContactos; t++) {
                System.out.println("Nombre: " + this.listaContactos[t].getNombre() + " - " +
                        " Telefono: " + Long.toString(this.listaContactos[t].getTelefono())+
                        " Direccion: " + this.listaContactos[t].getDireccion() +
                        " Correo: " + this.listaContactos[t].getCorreo() +
                        " Categoria: " + this.listaContactos[t].getCategoria()
                );
            }
        }
    }

    public void Vaciar() {
        try {
            System.out.println("Se eliminarán todos los contactos");
            System.out.println("¿Estas seguro (S/N)?");
            String respuesta;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            respuesta = teclado.readLine();
            respuesta = respuesta.toUpperCase();
            if (respuesta.equals("S")) {

                for (int i = 0; i < this.contadorContactos; i++) {
                    this.listaContactos[i].setNombre("");
                    this.listaContactos[i].setTelefono(0);
                    this.listaContactos[i].setDireccion("");
                    this.listaContactos[i].setCorreo("");
                    this.listaContactos[i].setCategoria("");
                }
                contadorContactos = 0;
                System.out.println("Agenda vaciada correctamente");
            } else {
                System.out.println("Acción cancelada");
            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Eliminar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre de contacto a eliminar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (contadorContactos == 0) {
                System.out.println("No hay contactos");
            } else {
                for (int i = 0; i < contadorContactos; i++) {

                    if (eliminar.equals(this.listaContactos[i].getNombre())) {
                        System.out.println("Nombre: " + this.listaContactos[i].getNombre() + "-" +
                                " Telefono: " + Long.toString(this.listaContactos[i].getTelefono())+
                                " Direccion: " + this.listaContactos[i].getDireccion() +
                                " Correo: " + this.listaContactos[i].getCorreo()+
                                " Categoria: " + this.listaContactos[i].getCategoria()
                        );
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué contacto quieres eliminar, introduce el número asociado?");
                    int eliminarNumero = Integer.parseInt(teclado.readLine());
                    eliminarNumero--;
                    System.out.println("¿Estas seguro (S/N)?");
                    String respuesta;
                    respuesta = teclado.readLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.equals("S")) {
                        Contacto[] temporal = new Contacto[99];
                        int ii = 0;
                        boolean encontrado2=false;
                        for (int i = 0; i < this.contadorContactos; i++) {

                            if (i != eliminarNumero) {
                                if (!encontrado2)
                                {
                                    temporal[ii] = this.listaContactos[ii];
                                    ii++;
                                }
                                else
                                {
                                    if (ii<this.contadorContactos)
                                    { temporal[ii] = this.listaContactos[ii+1];
                                        ii++;
                                    }
                                }

                            } else {
                                temporal[ii] = this.listaContactos[ii + 1];
                                ii++;
                                encontrado2=true;

                            }
                        }
                        this.contadorContactos--;
                        System.out.println("Contacto eliminado correctamente");
                        for (int j = 0; j < this.contadorContactos; j++) {
                            this.listaContactos[j] = temporal[j];

                        }

                    }

                } else {
                    System.out.println("Lo siento, No se ha encontrado el nombre");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Modificar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre de contacto a modificar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (contadorContactos == 0) {
                System.out.println("No hay contactos");
            } else {
                for (int i = 0; i < this.contadorContactos; i++) {

                    if (eliminar.equals(this.listaContactos[i].getNombre())) {
                        System.out.println("Nombre: " + this.listaContactos[i].getNombre() + "-" +
                                " Telefono: " + Long.toString(this.listaContactos[i].getTelefono())+
                                " Direccion: " + this.listaContactos[i].getDireccion() +
                                " Correo: " + this.listaContactos[i].getCorreo() +
                                " Categoria: " + this.listaContactos[i].getCategoria()
                        );
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué contacto quieres modificar?, introduce el número:");
                    int modificarNumero = Integer.parseInt(teclado.readLine());

                    System.out.println("Introduce nombre: ");
                    String nuevoNombre = teclado.readLine();
                    System.out.println("Introduce teléfono, formato numerico: ");
                    int nuevoTelefono = Integer.parseInt(teclado.readLine());
                    System.out.println("Introduce nueva dirección:");
                    String nuevaDireccion = teclado.readLine();
                    System.out.println("Introduce nuevo correo: ");
                    String nuevoMail = teclado.readLine();




                    this.listaContactos[modificarNumero - 1].setNombre(nuevoNombre);
                    this.listaContactos[modificarNumero - 1].setTelefono(nuevoTelefono);
                    this.listaContactos[modificarNumero - 1].setDireccion(nuevaDireccion);
                    this.listaContactos[modificarNumero - 1].setCorreo(nuevoMail);

                    Ordenar();
                } else {
                    System.out.println("No hay contactos con ese nombre");
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
