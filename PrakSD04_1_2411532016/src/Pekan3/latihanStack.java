package Pekan3;
import java.util.*;
public class latihanStack {

	public static void main(String[] args) {
	Stack<Integer> s = new Stack<Integer>();
	s.push(42);
	s.push(-3);
	s.push(17);
	System.out.println("Nilai stack = "+s);
	System.out.println("Nilai pop = "+ s.pop());
	System.out.println("Nilai stack setelah pop = "+s);
	System.out.println("Nilai peek = "+s.peek());
	System.out.println("Niali stack setelah peek = "+s);

	}

}
