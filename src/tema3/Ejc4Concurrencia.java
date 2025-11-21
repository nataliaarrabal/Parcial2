package tema3;

public class Ejc4Concurrencia {
	
	    
	    // Clase Recurso Compartido con métodos sincronizados
	    static class Almacen {
	        private int stock = 100;

	        // [Tu código aquí: Define 'agregar' como synchronized]
	        public synchronized void agregar(int cantidad) {
	            stock += cantidad;
	            System.out.println(Thread.currentThread().getName() + " agregó. Stock actual: " + stock); //obtiene nombre del hilo actual que ejecuta la tarea
	        }// nombre hebra = abastecedor

	        // [Tu código aquí: Define 'vender' como synchronized]
	        public synchronized void vender(int cantidad) {
	            stock -= cantidad;
	            System.out.println(Thread.currentThread().getName() + " vendió. Stock actual: " + stock);
	        }// nombre hebra= vendedor

	        public int getStock() {
	            return stock;
	        }
	    }

	    // Tarea A: Abastecedor (Implementa Runnable)
	    static class Abastecedor implements Runnable {
	        private Almacen almacen;
	        public Abastecedor(Almacen a) { 
	        	this.almacen = a; 
	        	}

	        @Override
	        public void run() {
	            // [Tu código aquí: Bucle para llamar a almacen.agregar(10) 10 veces]
	        	
	        	for(int i=0; i<10;i++) {
	        		almacen.agregar(10);
	        	}
	        }
	    }

	    // Tarea B: Vendedor (Implementa Runnable)
	    static class Vendedor implements Runnable {
	        private Almacen almacen;
	        public Vendedor(Almacen a) { 
	        	this.almacen = a; 
	        	}

	        @Override
	        public void run() {
	            // [Tu código aquí: Bucle para llamar a almacen.vender(12) 5 veces]

	        	for(int i=0; i<5;i++) {
	        		almacen.vender(12);
	        	}
	        }
	    }

	    public static void main(String[] args) throws InterruptedException {
	        Almacen almacen = new Almacen();
	        
	        Thread tAbastecedor = new Thread(new Abastecedor(almacen), "Abastecedor");
	        Thread tVendedor = new Thread(new Vendedor(almacen), "Vendedor");
	        
	        tAbastecedor.start(); // inicializa ambas hebras
	        tVendedor.start();
	        
	        // Esperar a que ambas hebras terminen
	        tAbastecedor.join();
	        tVendedor.join();
	        
	        System.out.println("\n--- FINAL ---");
	        System.out.println("Stock esperado: 140");
	        System.out.println("Stock final obtenido: " + almacen.getStock());
	    }
	}