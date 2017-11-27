package TheGoal;

public class Queue<T> {

	private CLL<T> queue;  // the circular linked list that
	//                        represents the queue
	
	// constructor - new Queue( ) returns a
	// reference to an empty Queue
	public Queue( ){
	    // fill in here
	    queue = new CLL();
	    //I need to check that this actually returns null
	}
	
	public void enqueue(T data){
	    // fill in here
		queue.addAtRear(data);
	}
	public T dequeue( ){
	    // fill in here
		return queue.removeFront();
	}
	public boolean isEmpty( ){
	    // fill in here
	    return queue.isEmpty();
	}

	public static void main(String [ ] args){
		Queue<String> c = new Queue<>( );
		c.enqueue("r1");
		c.enqueue("r2");

		c.enqueue("first");
		c.enqueue("second");
		c.enqueue("3rd");
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.isEmpty());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.isEmpty());


		System.out.println("\nSecond try: \n");
		c.enqueue("r1");
		c.enqueue("r2");

		c.enqueue("first");
		c.enqueue("second");
		c.enqueue("3rd");
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.isEmpty());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.isEmpty());
	}
}
