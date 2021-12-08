package ojttask;

import java.util.ArrayList;
import java.util.Iterator;

public class A {

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		
		for (Integer obj : al) {
			
			System.out.println(obj);
			}
		Iterator<Integer> it = al.iterator();
		
		while (it.hasNext()) {
			Integer i = it.next();
			if (i==20) 
				
				it.remove();
			
		}
		System.out.println(al);
	}
}
