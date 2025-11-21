package tema3;

public class Ejc3Concurrencia {
	
	    
	    // Clase que contiene el dato compartido (el Monitor)
	    static class ContadorCompartido {
	        private int contador = 0;

	        public synchronized void incrementar() {
	            // [Tu código aquí: Haz este método sincronizado]
	            contador++;
	        }

	        public int getContador() {
	            return contador;
	        }
	    }

	    // Tarea que utiliza el contador
	    static class Incrementador implements Runnable { //interfaz runnable que utiliza thread para crear objeto
	        private ContadorCompartido contador; // crea variable de tipo contador compartido - pde usar metodos de estas clases
	        public Incrementador(ContadorCompartido c) {
	            this.contador = c;
	        }

	        @Override
	        public void run() {
	            for (int i = 0; i < 1000; i++) { // en threads tenemos que redefinir run()
	                contador.incrementar();
	            }
	        }
	    }

	    public static void main(String[] args) throws InterruptedException {
	        ContadorCompartido contador = new ContadorCompartido();
	        Thread[] hebras = new Thread[10]; // creamos array de hebras

	        // Crea y arranca 10 hebras
	        for (int i = 0; i < 10; i++) {
	            hebras[i] = new Thread(new Incrementador(contador)); //inicializa las 10 hebras
	            hebras[i].start(); // arranca las 10 hebras
	        }

	        // Espera a que todas las hebras terminen (usando join())
	        for (Thread t : hebras) {
	            t.join(); // espremoas a que todas las hebras terminen de ejecutarse
	        }

	        System.out.println("Resultado final esperado: 10000");
	        System.out.println("Resultado obtenido: " + contador.getContador());
	    }
	
}
