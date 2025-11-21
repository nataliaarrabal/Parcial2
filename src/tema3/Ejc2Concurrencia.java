package tema3;

public class Ejc2Concurrencia {
	

	static class TareaRunnable implements Runnable {
		private String nombre;
	
	public TareaRunnable(String nombre) {
		this.nombre =nombre;
	}
	public void run() {
		for (int i=0;i<4;i++) {
			try {
                // Imprime la variable 'nombre' que almacena el nombre asignado
                System.out.println("Hilo ejecutándose (" + nombre + "): " + i);
                Thread.sleep(100);
			 } catch (InterruptedException e) {
                 // Es buena práctica manejar la interrupción en sleep
                 Thread.currentThread().interrupt();
                 return;
             }
			}
		
	}
	}public static void main(String[] args) {
		// 1. Crear instancias de TareaRunnable (las tareas)
        Runnable tareaA = new TareaRunnable("Tarea A");
        Runnable tareaB = new TareaRunnable("Tarea B");
        
        // 2. Crear objetos Thread, pasándoles las tareas Runnable
        Thread hiloA = new Thread(tareaA);
        Thread hiloB = new Thread(tareaB);
        
        // 3. Arrancar la ejecución concurrente
        hiloA.start();
        hiloB.start();
        
        System.out.println("El main terminó de arrancar los hilos.");
	}
	
}