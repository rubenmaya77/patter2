package com.example.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. IMPLEMENTACIÓN DE LA CLASE COMPUESTO
 * Representa los nodos que pueden contener otros componentes o incluso otros compuestos.
 * Utiliza la recursividad para operar sobre su lista de hijos.
 */
public class Compuesto implements IComponente {

    private String nombre;
    // Un compuesto tiene una lista de hijos, que pueden ser hojas u otros compuestos.
    private List<IComponente> hijos;

    public Compuesto(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void adicionar(IComponente componente) {
        this.hijos.add(componente);
    }

    @Override
    public void borrar(IComponente componente) {
        this.hijos.remove(componente);
    }

    @Override
    public IComponente buscar(String nombre) {
        // Primero, comprueba si el compuesto actual es el buscado.
        if (this.nombre.equalsIgnoreCase(nombre)) {
            return this;
        }

        IComponente encontrado = null;
        // Si no, recorre la lista de hijos y busca en cada uno de forma recursiva.
        for (IComponente hijo : this.hijos) {
            encontrado = hijo.buscar(nombre);
            // Si uno de los hijos lo encuentra, se detiene y devuelve el resultado.
            if (encontrado != null) {
                break;
            }
        }
        return encontrado;
    }

    @Override
    public String mostrar(int profundidad) {
        // Se utiliza un StringBuilder para construir la representación del árbol de forma eficiente.
        StringBuilder sb = new StringBuilder("-".repeat(profundidad) + " " + this.getNombre() + " (Compuesto)\n");
        // Llama recursivamente a `mostrar` en cada hijo, aumentando la profundidad.
        for (IComponente hijo : this.hijos) {
            sb.append(hijo.mostrar(profundidad + 1));
        }
        return sb.toString();
    }
}
