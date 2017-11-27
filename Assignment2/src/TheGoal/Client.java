package TheGoal;

public class Client<T>{

    // prints the contents of stack of Integers s, in
    // top-to-bottom order. This mthod may change s
    // temporarily, but by the time it exits, s must be
    // set back to the contens it had when printStack was
    // called.
	public static void printStack(Stack<Integer> s){
	    // fill in here
		Stack<Integer> copy = new Stack<>();

		while (!s.isEmpty())
		{
			Integer temp = s.pop();
			System.out.println(temp);
			copy.push(temp);
		}

		while (!copy.isEmpty())
		{
			s.push(copy.pop());
		}

	}

    // this method reverses the order of the items in the
    // stack.  What was the top Integer becomes the bottom,
    // next-to-top become next-to-bottom, etc.
	public static void flipStack(Stack<Integer> s){
	    //fill in here
	    Queue<Integer> flipped = new Queue<>();

	    while(!s.isEmpty())
		{
			flipped.enqueue(s.pop());
		}

		while (!flipped.isEmpty())
		{
			s.push(flipped.dequeue());
		}
	}

	public static void main(String[] args)
	{
		Stack<Integer> c = new Stack<>( );
		c.push(1);
		c.push(2);

		c.push(3);
		c.push(4);
		c.push(5);


		flipStack(c);
		printStack(c);
	}
}
