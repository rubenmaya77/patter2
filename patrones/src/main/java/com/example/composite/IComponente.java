package com.example.composite;

/**
 * 1. DEFINICIÓN DEL COMPONENTE
 * La interfaz genérica que define los comportamientos comunes tanto para los
 * objetos simples (hojas) como para los objetos complejos (compuestos).
 */
public interface IComponente {

    String getNombre();

    void adicionar(IComponente componente);

    void borrar(IComponente componente);

    IComponente buscar(String nombre);

    String mostrar(int profundidad);
}
