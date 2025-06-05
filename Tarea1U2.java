
package com.mycompany.tarea1u2;

/**
 *
 * @author Personal
 */

import java.util.Arrays;
import java.util.Random;

public class Tarea1U2 {

    public static void main(String[] args) {
        int numPersonas = 1000; // Define la cantidad de objetos Persona
        Persona[] personasOriginal = new Persona[numPersonas]; // Arreglo estático de Persona
        Random random = new Random();

        // Generar X objetos Persona aleatorios
        for (int i = 0; i < numPersonas; i++) {
            String nombre = "Persona" + i;
            int edad = random.nextInt(100) + 1; // Edades entre 1 y 100
            personasOriginal[i] = new Persona(nombre, edad);
        }

        System.out.println("--- Arreglo Original (primeras 10) ---");
        for (int i = 0; i < Math.min(10, personasOriginal.length); i++) {
            System.out.println(personasOriginal[i]);
        }
        System.out.println("...\n");

        // Probar los métodos de ordenación
        String[] metodosOrdenacion = {"Burbuja", "Seleccion", "Insercion", "Shell", "MergeSort", "QuickSort"};

        for (String metodo : metodosOrdenacion) {
            // Crea una copia del arreglo original para cada prueba de ordenación
            Persona[] personasParaOrdenar = Arrays.copyOf(personasOriginal, personasOriginal.length);
            
            long startTime = System.nanoTime(); // Inicia el temporizador

            switch (metodo) {
                case "Burbuja":
                    MetodosArreglos.bubbleSort(personasParaOrdenar); // Llamada a través de la clase MetodosArreglos
                    break;
                case "Selección":
                    MetodosArreglos.selectionSort(personasParaOrdenar); // Llamada a través de la clase MetodosArreglos
                    break;
                case "Inserción":
                    MetodosArreglos.insertionSort(personasParaOrdenar); // Llamada a través de la clase MetodosArreglos
                    break;
                case "Shell":
                    MetodosArreglos.shellSort(personasParaOrdenar); // Llamada a través de la clase MetodosArreglos
                    break;
                case "MergeSort":
                    MetodosArreglos.mergeSort(personasParaOrdenar); // Llamada a través de la clase MetodosArreglos
                    break;
                case "QuickSort":
                    MetodosArreglos.quickSort(personasParaOrdenar, 0, personasParaOrdenar.length - 1); // Llamada a través de la clase MetodosArreglos
                    break;
            }

            long endTime = System.nanoTime(); // Finaliza el temporizador
            long duration = (endTime - startTime) / 1_000_000; // Duración en milisegundos

            System.out.println("--- Ordenacion por " + metodo + " ---");
            System.out.println("Tiempo transcurrido: " + duration + " ms");
            // Mostrar los primeros 10 elementos ordenados para verificar
            System.out.println("Primeros 10 elementos ordenados:");
            for (int i = 0; i < Math.min(10, personasParaOrdenar.length); i++) {
                System.out.println(personasParaOrdenar[i]);
            }
            System.out.println("...\n");
        }

        //métodos de búsqueda

        // Para la búsqueda binaria, necesitamos un arreglo que esté ordenado.
        Persona[] personasOrdenadasParaBusqueda = Arrays.copyOf(personasOriginal, personasOriginal.length);
        MetodosArreglos.quickSort(personasOrdenadasParaBusqueda, 0, personasOrdenadasParaBusqueda.length - 1); // Ordenamos usando MetodosArreglos

        System.out.println("--- Pruebas de Busqueda ---");

        // Búsqueda Lineal
        int edadBuscadaLineal = 30; // Edad a buscar
        System.out.println("\nBusqueda Lineal: Buscando personas con edad = " + edadBuscadaLineal);
        long startTimeLineal = System.nanoTime();
        Persona[] resultadosLineal = MetodosArreglos.busquedaLinealPorEdad(personasOriginal, edadBuscadaLineal); // Llamada a través de la clase MetodosArreglos
        long endTimeLineal = System.nanoTime();
        long durationLineal = (endTimeLineal - startTimeLineal) / 1_000_000;

        if (resultadosLineal.length == 0) {
            System.out.println("No se encontraron personas con edad " + edadBuscadaLineal);
        } else {
            System.out.println("Personas encontradas (Busqueda Lineal):");
            for (Persona p : resultadosLineal) {
                System.out.println(p);
            }
        }
        System.out.println("Tiempo de busqueda lineal: " + durationLineal + " ms");


        // Búsqueda Binaria
        int edadBuscadaBinaria = 50; // Edad a buscar
        System.out.println("\nBusqueda Binaria: Buscando la primera persona con edad = " + edadBuscadaBinaria + " (en arreglo ordenado)");
        long startTimeBinaria = System.nanoTime();
        Persona resultadoBinaria = MetodosArreglos.busquedaBinariaPorEdad(personasOrdenadasParaBusqueda, edadBuscadaBinaria); // Llamada a través de la clase MetodosArreglos
        long endTimeBinaria = System.nanoTime();
        long durationBinaria = (endTimeBinaria - startTimeBinaria) / 1_000_000;

        if (resultadoBinaria != null) {
            System.out.println("Primera persona encontrada (Busqueda Binaria): " + resultadoBinaria);
        } else {
            System.out.println("No se encontro ninguna persona con edad " + edadBuscadaBinaria);
        }
        System.out.println("Tiempo de busqueda binaria: " + durationBinaria + " ms");

        // Probar una edad que no existe en la búsqueda binaria
        int edadNoExistente = 99;
        System.out.println("\nBusqueda Binaria: Buscando la primera persona con edad = " + edadNoExistente + " (en arreglo ordenado)");
        startTimeBinaria = System.nanoTime();
        resultadoBinaria = MetodosArreglos.busquedaBinariaPorEdad(personasOrdenadasParaBusqueda, edadNoExistente); // Llamada a través de la clase MetodosArreglos
        endTimeBinaria = System.nanoTime();
        durationBinaria = (endTimeBinaria - startTimeBinaria) / 1_000_000;
        if (resultadoBinaria != null) {
            System.out.println("Primera persona encontrada (Busqueda Binaria): " + resultadoBinaria);
        } else {
            System.out.println("No se encontro ninguna persona con edad " + edadNoExistente);
        }
        System.out.println("Tiempo de busqueda binaria: " + durationBinaria + " ms");
    }
}
    
