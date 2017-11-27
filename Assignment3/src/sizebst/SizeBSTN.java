package sizebst;

/**
 * Instances of class SizeBSTN are Nodes of the Size Binary Search Tree 
 * @author lou
 *
 */
public class SizeBSTN {
	SizeBSTN LSubtree;  // left subtree of this tree (may be null)
	SizeBSTN RSubtree;  // right subtree of this tree (may be null)
	int data; // data at this node of the tree
	int size; // number of tree entries that are less than or equal to data

/**
 * create a new leaf of the tree with the given data
 * @param data
 */
	public SizeBSTN(int data){
		LSubtree = null;
		RSubtree = null;
		this.data = data;
		size = 1;
	}
	
	/* see assignment for proper format for nodeString
	 */
	public static String nodeString(SizeBSTN node)
    {
        if(node == null)
            return "null";

        return "[" + nodeString(node.LSubtree) +" "+ node.data +"," + node.size+ " "+ nodeString(node.RSubtree) + "]";

	}
	
	/**
	 * search for the number target in the tree this node is the root of
	 * @param target number to search for
	 * @return either the node that holds target,
	 * if there is one, or the node which should point to the node that 
	 * will hold target if it is added now  
	 */
	public static SizeBSTN getNode(SizeBSTN node, int target)
    {
		if(node == null)
		    return null;

		if(node.data == target || node.size == 1)
		    return node;

		if(node.data > target)
		    return getNode(node.LSubtree, target);
		else
		{
			if(node.RSubtree == null)
				return node;

			return getNode(node.RSubtree, target);
		}
	}
	
	/**
	 * like getNode but increments size fields as appropriate
	 * @param target number to search for
	 */
	public static void getNodeIncr(SizeBSTN node, int target){
        if(node == null)
            return;

        if(node.size == 1)
        {
			++node.size;
            return;
        }

        if(node.data > target)
		{

			getNodeIncr(node.LSubtree, target);
			++node.size;
			return;
		}

        getNodeIncr(node.RSubtree, target);
	}
	
	/**
	 * actually calculates number of numbers <= target.  
	 * Does search for target like getNode but adds up 
	 * the size fields of all nodes whose data is <= target.
	 * @return the number of nodes with data <= target in the
	 * tree this node is the root of.
	 */
	public static int sumNodesLeq(SizeBSTN node, int target){
        if(node == null)
            return 0;

        if(node.data == target || node.size == 1)
            return node.size;

        if(node.data < target)
            return node.size + sumNodesLeq(node.RSubtree, target);

        return sumNodesLeq(node.LSubtree, target);
	}	
}