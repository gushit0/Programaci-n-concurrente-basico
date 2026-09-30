// Ejercicio 7: Interrupción de hilos (interrupt e isInterrupted)
// Objetivo: Cancelar la ejecución de una tarea larga de forma limpia sin usar métodos obsoletos como stop().


class ProcesadorTareas implements Runnable {
    @Override
    public void run() {
        int contador = 1;
        
        // Verifica en cada ciclo si recibió una señal de interrupción
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Procesando lote #" + contador++);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                // Thread.sleep limpia la bandera de interrupción al lanzar la excepción,
                // por lo que se interrumpe explícitamente la ejecución para salir del bucle.
                System.out.println("Se interrumpió durante la pausa. Saliendo...");
                break; 
            }
        }
        System.out.println("Hilo finalizado limpiamente.");
    }
}

public class Ejercicio7 {
    public static void main(String[] args) {
        Thread hiloLargo = new Thread(new ProcesadorTareas());
        hiloLargo.start();

        try {
            Thread.sleep(2000); // Deja que trabaje 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Solicitando cancelación del hilo...");
        hiloLargo.interrupt(); // Envía la señal de parada
    }
}