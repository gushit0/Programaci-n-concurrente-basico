// Ejercicio 3: Refactorización a Expresiones Lambda (Runnable)
// Objetivo: Convertir código de la interfaz Runnable a una sintaxis más moderna e implícita usando cordura funcional en Java 8+.


public class Principal3 {
    public static void main(String[] args) {
        // En lugar de crear una clase que implemente Runnable,
        // pasamos la lambda directamente
        Thread hiloLambda = new Thread(() -> {
            System.out.println("Ejecutando tarea desde una expresión Lambda.");
            System.out.println("Hilo actual: " + Thread.currentThread().getName());
        });

        hiloLambda.start();
    }
}