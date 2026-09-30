// Ejercicio 5: Coordinación entre hilos (join)
// Objetivo: Hacer que un hilo espere a que otro termine antes de continuar la ejecución.


class CargaBaseDatos implements Runnable {
    @Override
    public void run() {
        System.out.println("Cargando datos en memoria...");
        try {
            Thread.sleep(2000); // Simula 2 segundos de lectura
        } catch (InterruptedException e) {
            System.out.println("Carga interrumpida.");
        }
        System.out.println("✓ Datos cargados correctamente.");
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        Thread hiloDB = new Thread(new CargaBaseDatos());
        hiloDB.start();

        try {
            // El hilo main se detiene aquí hasta que hiloDB complete su método run()
            hiloDB.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sistema listo para usarse.");
    }
}