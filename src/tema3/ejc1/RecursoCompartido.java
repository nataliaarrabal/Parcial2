package tema3.ejc1;



public class RecursoCompartido {
	
	private Integer entero = null; 
    
    private int numLectores = 0;
    private boolean escribiendo = false;
    
    private synchronized void accesoLectura(String nombreLector)throws InterruptedException {
    	while(escribiendo||this.entero==null) {
    		System.out.println("Lector: "+nombreLector+ " espera para leer");
    		wait();
    	}
    	numLectores++;
    	
    	System.out.println("Lector: "+nombreLector+ " ha empezado a leer");
    }
    	 private synchronized void terminaLectura(String nombreLector)throws InterruptedException{
    	    	escribiendo=false;
    	    	notifyAll();
    	    	System.out.println(" Lector " + nombreLector + " ha terminado de leer.");
    	    
    }
    
    private synchronized void accesoEscritura(String nombreEscritor)throws InterruptedException{
    	while(numLectores>0||escribiendo) {
    		System.out.println("Escritot: "+nombreEscritor+ " espera para escribir");
    		wait();
    		
    	}
    	escribiendo=true;
    	System.out.println("Escritor: "+nombreEscritor+ " ha empezado a escribir");
    	
    }
    
    private synchronized void terminaEscritura(String nombreEscritor)throws InterruptedException{
    	escribiendo=false;
    	notifyAll();
    	System.out.println(" Escritor " + nombreEscritor + " ha terminado de escribir.");
    }
    
    public void leer(String nombreLector)throws InterruptedException{
    	//adquirir acceso lectura
    	accesoLectura(nombreLector);
    	
    	Integer valorLeido=this.entero;
    	System.out.println("Lector "+nombreLector+ " está leyendo. Valor = "+valorLeido);
    	
    	//espera 500ms
    	Thread.sleep((long) (Math.random()*500));
    	 
    	//liberar permiso de e¡lectura
    	
    	terminaLectura(nombreLector);
    	
    }
    
    public void escribir(String nombreEscritor) throws InterruptedException{
    	
    	//adquirir acceso lectura
    	accesoEscritura(nombreEscritor);
    	
    	Integer valorLeido=this.entero;
    	System.out.println("Escritor "+nombreEscritor+ " está escribiendo. ValorAntiguo = "+valorLeido+ "Escribe valor nuevo: "+this.entero);
    	this.entero=(int)(Math.random()*10000);
    	
    	//espera 500ms
    	Thread.sleep((long) (Math.random()*500));
    	 
    	//liberar permiso de e¡lectura
    	
    	terminaEscritura(nombreEscritor);
    	
    }
    static class HebraLectora extends Thread{
    	 private final RecursoCompartido recurso;
    	    private final String nombre;

    	    public HebraLectora(RecursoCompartido recurso, String nombre) {
    	        this.recurso = recurso;
    	        this.nombre = nombre;
    	    }

    	    @Override
    	    public void run() {
    	        try {
    	            // Intenta leer del recurso
    	            recurso.leer(nombre);
    	        } catch (InterruptedException e) {}
    	    }
    }
    
    static class HebraEscritora extends Thread{
    	private final RecursoCompartido recurso;
    	 private final String nombre;

    	    public HebraEscritora(RecursoCompartido recurso, String nombre) {
    	        this.recurso = recurso;
    	        this.nombre = nombre;
    	    }

    	    @Override
    	    public void run() {
    	        try {
    	            // Intenta escribir en el recurso
    	            recurso.escribir(nombre);
    	        } catch (InterruptedException e) {}
    	    }
    	
    }
    private static final int NUM_LECTORAS = 300;
	private static final int RATIO_LECTORAS_ESCRITORAS = 10;
    
    public static void main(String[] args) {
		// Recurso compartido (monitor)
		RecursoCompartido recurso = new RecursoCompartido();

		System.out.println("Iniciando: " + NUM_LECTORAS + " lectoras y " +
							NUM_LECTORAS / RATIO_LECTORAS_ESCRITORAS + " escritoras.");
		try {
			// Crear y arrancar hebras
			for (int i = 0; i < NUM_LECTORAS; i++) {
				Thread t = new HebraLectora(recurso, "L" + i);
				t.start();
				// 1 escritora por cada N lectoras
				if (i % RATIO_LECTORAS_ESCRITORAS == 0) {
					Thread t2 = new HebraEscritora(recurso, "E" + i);
					t2.start();
				}
				// Esperar hasta 500 ms entre creación de hebras.
				Thread.sleep((long) (Math.random() * 500));
			}
		} catch (InterruptedException e) {}
}}
