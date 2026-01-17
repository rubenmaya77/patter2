package com.example.composite;

/**
 * 2. IMPLEMENTACIÓN DE LA CLASE COMPONENTE (HOJA)
 * Representa los objetos "hoja" del árbol, es decir, aquellos que no pueden tener hijos.
 */
public class Componente implements IComponente {

    private String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void adicionar(IComponente componente) {
        // En una hoja, este método no hace nada o arroja una excepción.
        // Para seguir el ejemplo del video, mostramos un mensaje.
        System.out.println("No se puede añadir a un componente simple.");
    }

    @Override
    public void borrar(IComponente componente) {
        // En una hoja, este método no hace nada o arroja una excepción.
        System.out.println("No se puede borrar de un componente simple.");
    }

    @Override
    public IComponente buscar(String nombre) {
        // Una hoja se busca a sí misma.
        if (this.nombre.equalsIgnoreCase(nombre)) {
            return this;
        }
        return null;
    }

    @Override
    public String mostrar(int profundidad) {
        // Se usa `repeat` para crear la indentación y representar la jerarquía.
        return "-".repeat(profundidad) + " " + this.getNombre() + "\n";
    }
}

