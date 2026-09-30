// Ejercicio 6: Hilos demonio / Tareas en segundo plano (setDaemon)
// Objetivo: Entender la diferencia entre un hilo de usuario y un hilo "Daemon" que no impide que la aplicación finalice.


public class Ejercicio6 {
    public static void main(String[] args) {
        Thread autoguardado = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("[Segundo plano] Borrador guardado...");
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        // Debe marcarse como demonio ANTES de invocar .start()
        autoguardado.setDaemon(true);
        autoguardado.start();

        // Simula trabajo en el programa principal
        System.out.println("Usuario escribiendo un documento...");
        try {
            Thread.sleep(3500); // Permite ver ~3 guardados
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa principal cerrado. El hilo demonio muere aquí.");
    }
}