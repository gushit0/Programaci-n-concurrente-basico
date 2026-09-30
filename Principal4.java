// Ejercicio 4: Caso de uso real (Simulación de descargas paralelas)
// Objetivo: Aplicar hilos a un caso práctico como la descarga o procesamiento simultáneo de archivos.


class DescargaArchivo implements Runnable {
    private String nombreArchivo;
    private int tiempoDescargaMs;

    public DescargaArchivo(String nombreArchivo, int tiempoDescargaMs) {
        this.nombreArchivo = nombreArchivo;
        this.tiempoDescargaMs = tiempoDescargaMs;
    }

    @Override
    public void run() {
        System.out.println("Iniciando descarga: " + nombreArchivo);
        try {
            Thread.sleep(tiempoDescargaMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✓ Descarga completada: " + nombreArchivo);
    }
}

public class Principal4 {
    public static void main(String[] args) {
        Thread d1 = new Thread(new DescargaArchivo("documento.pdf", 2000));
        Thread d2 = new Thread(new DescargaArchivo("imagen.png", 1000));
        Thread d3 = new Thread(new DescargaArchivo("video.mp4", 3000));

        // Las descargas ocurren de manera simultánea
        d1.start();
        d2.start();
        d3.start();
    }
}