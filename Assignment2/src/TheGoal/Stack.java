package TheGoal;

public class Stack<T>{
    
	private CLL<T> stack;  // the circular linked list that
	//                        represents the stack
	
	// constructor - new Stack( ) returns a
	// reference to an empty Stack	
	public Stack( ){
	    // fill in here
		stack = new CLL<>();
	}
	
	public void push(T data){
	    // fill in here
		stack.addAtFront(data);
	}
	public T pop( ){
	    // fill in here
	    return stack.removeFront();
	}
	public boolean isEmpty( ){
	    // fill in here
	    return stack.isEmpty();
	}

	public static void main(String [ ] args){
		Stack<String> c = new Stack<>( );
		c.push("r1");
		c.push("r2");

		c.push("first");
		c.push("second");
		c.push("3rd");
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.isEmpty());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.isEmpty());


		System.out.println("\nSecond try: \n");
		c.push("r1");
		c.push("r2");

		c.push("first");
		c.push("second");
		c.push("3rd");
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.isEmpty());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.isEmpty());

	}
}
