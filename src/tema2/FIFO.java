package tema2;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
	List<Integer>cola=new ArrayList<>();
	
	public FIFO(List<Integer>cola) {
		this.cola=cola;
	}
	public void enqueue(int x) {
		cola.add(x);
		
	}
	public void dequeue() {
		cola.remove(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> lista = new ArrayList<>();
		FIFO cola=new FIFO(lista);	
	cola.enqueue(10);
		

		
		
		

	}

}
