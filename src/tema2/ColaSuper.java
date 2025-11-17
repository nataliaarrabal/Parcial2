package tema2;

import java.util.LinkedList;
import java.util.Queue;

public class ColaSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String>cola=new LinkedList<>();
		
		cola.add("Ana");
		cola.add("Luis");
		cola.add("Carlos");
		cola.add("pepe");
		cola.add("maría");
		cola.add("marta");
		
		String atendido1= cola.remove();
		cola.remove(0);
		String atendido2=cola.remove();
		cola.remove(0);
		
		
		
		System.out.println("Los clientes atendidos fueron: "+ atendido1+ " "+atendido2);
		System.out.println("El próximo cliente en ser atendido será: "+ cola.peek());
		System.out.println(cola);
	}

}
