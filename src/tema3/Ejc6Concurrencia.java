package tema3;

public class Ejc6Concurrencia {

	    static class Cuenta {
	        private final int id; // Usaremos el ID para la ordenación
	        private long balance;

	        public Cuenta(int id, long balance) {
	            this.id = id;
	            this.balance = balance;
	        }

	        public void transferir(Cuenta otraCuenta, long cantidad) {
	            // [Tu código aquí: Implementar la lógica con DOS bloques synchronized anidados,
	            // primero sobre 'this' y luego sobre 'otraCuenta', para CAUSAR el deadlock.]
	        }
	        
	        // ... (Métodos auxiliares para obtener ID y Balance)
	    

	    static class TareaTransferencia implements Runnable {
	        private Cuenta origen;
	        private Cuenta destino;
	        private long cantidad;

	        // ... Constructor
	        
	        @Override
	        public void run() {
	            // [Tu código aquí: Llamar al método transferir]
	        	transferir();
	        }
	    }}

	    public static void main(String[] args) throws InterruptedException {
	        Cuenta cuentaA = new Cuenta(1, 1000);
	        Cuenta cuentaB = new Cuenta(2, 2000);
	        
	        // T1: Bloquea A, luego B
	        Thread t1 = new Thread(new TareaTransferencia(cuentaA, cuentaB, 100), "T1");
	        // T2: Bloquea B, luego A
	        Thread t2 = new Thread(new TareaTransferencia(cuentaB, cuentaA, 200), "T2");
	        
	        t1.start();
	        t2.start();
	        
	        // Esperar indefinidamente... (¡o hasta que se produzca el deadlock!)
	        t1.join(); 
	        t2.join();
	        
	        System.out.println("El programa finalizó (Si ves esto, no hubo deadlock, o lo corregiste).");
	    }

}
