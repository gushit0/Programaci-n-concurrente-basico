// Ejercicio 1: Modificación de código básico (Runnable con parámetros)
// Objetivo: Practicar cómo pasar información a la tarea que ejecuta el hilo.


class SaludoTarea implements Runnable {
    private String usuario;
    private int repeticiones;

    public SaludoTarea(String usuario, int repeticiones) {
        this.usuario = usuario;
        this.repeticiones = repeticiones;
    }

    @Override
    public void run() {
        for (int i = 1; i <= repeticiones; i++) {
            System.out.println("Hola " + usuario + " - mensaje #" + i + " (Hilo: " + Thread.currentThread().getName() + ")");
        }
    }
}

public class Principal1 {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new SaludoTarea("Carlos", 3));
        Thread hilo2 = new Thread(new SaludoTarea("Ana", 3));

        hilo1.start();
        hilo2.start();
    }
}