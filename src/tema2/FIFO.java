package tema2;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
	List<Integer>cola=new ArrayList<>();
	
	public FIFO(List<Integer>cola) {
		this.cola=cola;
	}
	public void enqueue(List<Integer>cola,int x) {
		cola.add(x);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FIFO cola=new FIFO();	
	cola.enqueue(10);
		

		
		
		

	}

}
