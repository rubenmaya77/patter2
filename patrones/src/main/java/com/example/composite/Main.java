package com.example.composite;

import java.util.Scanner;

/**
 * 4. LÓGICA DEL CLIENTE (CLASE MAIN)
 * Se crea un programa de consola con un menú interactivo para gestionar la jerarquía.
 * Permite añadir, buscar y visualizar la estructura en árbol.
 */
public class Main {

    public static void main(String[] args) {
        // Se instancia un compuesto inicial que sirve como raíz del árbol.
        IComponente arbol = new Compuesto("Raíz");

        // La variable 'trabajo' nos permite saber en qué parte del árbol estamos situados.
        IComponente trabajo = arbol;

        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("7")) {
            System.out.println("\nEstás en: [" + trabajo.getNombre() + "]");
            System.out.println("1. Ver árbol desde la raíz");
            System.out.println("2. Añadir componente (hoja)");
            System.out.println("3. Añadir compuesto");
            System.out.println("4. Buscar");
            System.out.println("5. Navegar (cambiar de 'trabajo')");
            System.out.println("6. Volver a la raíz");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\n--- MOSTRANDO ÁRBOL ---");
                    System.out.println(arbol.mostrar(0));
                    break;
                case "2":
                    System.out.print("Nombre del nuevo componente: ");
                    String nombreComponente = scanner.nextLine();
                    trabajo.adicionar(new Componente(nombreComponente));
                    break;
                case "3":
                    System.out.print("Nombre del nuevo compuesto: ");
                    String nombreCompuesto = scanner.nextLine();
                    trabajo.adicionar(new Compuesto(nombreCompuesto));
                    break;
                case "4":
                    System.out.print("Nombre del elemento a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    // La búsqueda siempre empieza desde la raíz para encontrar cualquier nodo.
                    IComponente encontrado = arbol.buscar(nombreBusqueda);
                    if (encontrado != null) {
                        System.out.println("Elemento encontrado: " + encontrado.getNombre());
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case "5":
                    System.out.print("Nombre del compuesto al que quieres navegar: ");
                    String nombreNavegacion = scanner.nextLine();
                    IComponente destino = arbol.buscar(nombreNavegacion);
                    if (destino instanceof Compuesto) {
                        trabajo = destino;
                        System.out.println("Navegación exitosa.");
                    } else {
                        System.out.println("No se puede navegar a este elemento (no es un compuesto o no existe).");
                    }
                    break;
                case "6":
                    trabajo = arbol;
                    System.out.println("Has vuelto a la raíz.");
                    break;
                case "7":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}
