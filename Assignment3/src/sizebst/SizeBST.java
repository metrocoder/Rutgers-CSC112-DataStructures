package sizebst;


/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST {
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root){
		rootNode =  root;
	}

	public String toString(){
		if (rootNode == null)
			return "(null)";
		else {
			return "("+ SizeBSTN.nodeString(rootNode) + ")";
		}
	}

	/**
	 * @param target the number to search for
	 * @return true iff target is in this tree
	 */
	public boolean search(int target)
	{
	    if(rootNode.getNode(rootNode,target) == null || rootNode.getNode(rootNode,target).data != target)
	        return false;

	    return true;
	}

	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData){


		if(search(newData) == false)
        {
			SizeBSTN newNode = new SizeBSTN(newData);
            SizeBSTN parentNode = rootNode.getNode(rootNode,newData);

			if(rootNode == null)
			{
				rootNode = newNode;
				return;
			}
			rootNode.getNodeIncr(rootNode,newData);

            if(parentNode.data > newData)
			{
				parentNode.LSubtree = newNode;
			}
            else
            	parentNode.RSubtree = newNode;
        }
        return;
	}

	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target)
	{
		if(rootNode.sumNodesLeq(rootNode,target) >0)
			return rootNode.sumNodesLeq(rootNode,target);

		return -1;
	}

	public static void main(String args []){
		SizeBST tree1 = new SizeBST(null);
		System.out.println("empty: "+tree1);
		tree1.insert(40);
		System.out.println("40 "+tree1);

		// add any test code you want here - this is not graded.  Just be sure it compiles
		tree1.insert(40);
		System.out.println("40 duplicated test "+tree1);
		tree1.insert(20);
		System.out.println("20 inserted after 40 should be left tree "+tree1);
		tree1.insert(20);
		System.out.println("20 duplicated left TEST "+tree1);
		tree1.insert(60);
		System.out.println("60 inserted after 40 should be right tree "+tree1);
		tree1.insert(60);
		System.out.println("60 duplicate right test "+tree1);

		System.out.println(tree1.numLEq(70));
		System.out.println("Lets make sure the tree is not fucked up after LEQ: " + tree1);

		//Testing adding/duplicates/increment/leq 3rd layer of the tree
		tree1.insert(10);
		System.out.println("10 inserted after 20 should be left tree "+tree1);
		tree1.insert(10);
		System.out.println("10 duplicated left 3rd layer TEST "+tree1);
		tree1.insert(30);
		System.out.println("30 inserted after 30 should be right tree "+tree1);
		tree1.insert(30);
		System.out.println("30 duplicate right/ 3rd layer test "+tree1);

		//Checking LEQ for 3rd layer
		System.out.println("Testing LeQ for the third layer: "+tree1.numLEq(50)); //Should be 4
		System.out.println("Lets make sure the tree is not fucked up after LEQ: " + tree1);
	}
}
