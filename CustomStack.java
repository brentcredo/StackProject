/*
 * Brent Credo
 * Project 4
 * CustomStack.java
 * This program conducts the push, pop, peek, clear, and checks 
 * if the stack is clear
 * basically manipulates the stack given
 * 10/19/2019
 */

package cmsc256;
/*
 * imports needed for the project
 */
import java.util.EmptyStackException;
import bridges.connect.Bridges;
import bridges.base.SLelement;


public class CustomStack<E> implements StackInterface<E>{

	/*
	 * create an object from generic that represents the top and sets it to null
	 */
	private SLelement<E> top = null;

	/*
	 * method that conducts the push action
	 */
	@Override
	public void push(E newEntry) {
		/*
		 * if there is no new entry it is null
		 */
		if (newEntry == null) {
			throw new IllegalArgumentException();
		}
		/*
		 * makes a node object that represents the new entry
		 */
		SLelement<E> node = new SLelement <>(newEntry);
		/*
		 * sets top equal to the node, which is set to the new top
		 */
		node.setNext(top);
		top = node;
	}
	/*
	 * conducts the pop action
	 */
	@Override
	public E pop() {
		/*
		 * checks if the top is null and returns an empty stackexception
		 */
		if (top == null) {
			throw new EmptyStackException();
		}
		/*
		 * creates a node object that contains the top
		 * gets the next value and sets it to the top
		 * returns the node, which is the new top
		 */
		E node = top.getValue();
		top = top.getNext();
		return node;
		

	}
	/*
	 * conducts a peek action
	 */
	@Override
	/*
	 * checks if the top is null and return an emptystackexception 
	 * if it is, which means there is no stack
	 */
	public E peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		/*
		 * gets the value of the top and returns it
		 */
		E result = top.getValue();
		return result;
	}
	/*
	 * checks if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		/*
		 * if it is empty, it returns true
		 */
		if(top == null) {
			return true;
		}
		/*
		 * if it is filled, that is false
		 */
		else{
		return false;
	}
	}

	@Override
	/*
	 * clears the top
	 */
	public void clear() {
		top = null;
		
	}
	
	
	/*
	 * main method
	 */
	@SuppressWarnings("unchecked")
	public static <E> void main(String [] args) throws Exception{
		/*
		 * bridges set up and title
		 */
		Bridges bridges = new Bridges(5, "brentcredo", "284655397948");
		bridges.setTitle("my stack");
		bridges.setDescription("SLelement with stack points");
		/*
		 * generic stack
		 */
		CustomStack<E> stack = new CustomStack<E>();
		/*
		 * numbers pushed in
		 */
		stack.push((E)"5");
		stack.push((E)"10");
		stack.push((E)"18");
		stack.push((E)"20");
		stack.push((E)"2019");
		stack.peek();
		/*
		 * sets the data structure from top with data from the stack
		 */
		bridges.setDataStructure(stack.top);
		/*
		 * visualizer
		 */
		bridges.visualize();
	}
	
	/*
	 * provides output of stack
	 */
	public void display() { if(isEmpty()) {
		System.out.println("The stack is empty"); }
		else {
		SLelement<E> current = top;
		StringBuffer output = new StringBuffer();
		output.append("Top of stack: " + current.getValue() + "\n");
		while(current.getNext() != null) { current = current.getNext();
		if(current.getNext() == null) output.append("Stack bottom: ");
		else
		                   output.append("              ");
		               output.append(current.getValue() + "\n");
		}
		System.out.println(output.toString()); }
		 
		}
	
	

}
