package com.pperezm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
@author Pablo Arturo Pérez Mata
@email pablo.arturo.perez@gmail.com
@description Examen 1er Parcial programacion
*/

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String texto="";
            char opcion='1';
            Agenda miAgenda= new Agenda();
            Scanner scanner = new Scanner(System.in);
            while ((opcion=='1') || (opcion=='2') || (opcion=='3') || (opcion=='4')|| (opcion=='5') || (opcion=='6') )
            {
                System.out.println("......................");
                System.out.println("AGENDA");
                System.out.println("......................");
                System.out.println("1-Nuevo contacto");
                System.out.println("2-Buscar contacto");
                System.out.println("3-Modificar contacto");
                System.out.println("4-Eliminar contacto");
                System.out.println("5-Listado de contactos");
                System.out.println("6-Vaciar agenda");
                System.out.println("0-Salir");
                System.out.println("......................");

                System.out.println("Opción: ");
                System.out.println("......................");
                texto=teclado.readLine();
                opcion= texto.charAt(0);

                switch(opcion){
                    case '1':
                        String nombre;
                        String telefono;
                        String direccion;
                        String correo;
                        String categoria;
                        boolean validar;
                        System.out.println("Por favor introduzca el nombre:");
                        nombre=teclado.readLine();
                        System.out.println("Por favor introduzca el teléfono(numero):");
                        telefono=teclado.readLine();
                        validar=esNumerica(telefono);
                        System.out.println("Por favor introduzca la dirección:");
                        direccion =teclado.readLine();
                        System.out.println("Por favor introduzca el correo electronico:");
                        correo =teclado.readLine();
                        System.out.println("Por favor seleccione la categoría:");
                        System.out.println("1: Familia");
                        System.out.println("2: Trabajo");
                        System.out.println("3: Amigos");
                        Character seleccionCategoria = scanner.next().charAt(0);
                            switch(seleccionCategoria) {
                                case '1':
                                    categoria = "Familia";
                                    break;
                                case '2':
                                    categoria = "Trabajo";
                                    break;
                                case '3':
                                    categoria = "Amigos";
                                break;

                                default:
                                    System.out.println("Opción inválida. Se agregara a otros. ");
                                    categoria = "Otros";
                                    break;

                            }
                        if (validar){
                            long telefonoEntero= Long.parseLong(telefono);
                            miAgenda.Consultar(nombre, telefonoEntero, direccion, correo, categoria);
                            miAgenda.Anadir(nombre, telefonoEntero, direccion, correo, categoria);
                        }
                        else{
                            System.out.println("No es un número, formato de telefono incorrecto.");}

                        break;


                    case '2':
                        System.out.println("Nombre a buscar:");
                        nombre=teclado.readLine().toUpperCase();
                        miAgenda.Buscar(nombre);
                        break;
                    case '3':
                        miAgenda.Modificar();
                        break;
                    case '4':
                        miAgenda.Eliminar();
                        break;
                    case '5':
                        miAgenda.Mostrar();
                        break;
                    case '6':
                        miAgenda.Vaciar();
                        break;
                    case '0':
                        System.out.println("Gracias por usar la agenda!");
                        break;

                    default:
                        System.out.println("Opción incorrecta!");
                        opcion='1';

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static boolean esNumerica(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}

