// Ejercicio 2: Concurrencia con herencia (Thread)
// Objetivo: Observar la ejecución simultánea e intercalada de múltiples hilos extendiendo Thread.


class ContadorHilo extends Thread {
    public ContadorHilo(String nombre) {
        super(nombre); // Asigna nombre al hilo
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> " + i);
            try {
                Thread.sleep(500); // Pausa de medio segundo
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
    }
}

public class Principal2 {
    public static void main(String[] args) {
        ContadorHilo contador1 = new ContadorHilo("Contador A");
        ContadorHilo contador2 = new ContadorHilo("Contador B");

        contador1.start();
        contador2.start();
    }
}