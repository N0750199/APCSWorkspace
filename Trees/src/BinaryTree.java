/**
 * 
 */

/**
 * @author jack
 *
 */
public class BinaryTree {

	/**
	 * @param args
	 */
	
	private TreeNode root;
	
	//get num nodes
	public int countNodes()
	{
		return recCountNodes(root);
	}
	
	//recursive helper counter method
	private int recCountNodes(TreeNode r)
	{
		if(r==null)
			return 0;
		
		return recCountNodes(r.getLeft())+recCountNodes(r.getRight())+1;
	}
	
	//Traversals=prefix-node,left,right postfix-left,right,node infix-right,left,node
	
	//prints out node, then left, then right
	public void prefix()
	{
		recPrefix(root);
	}
	
	private void recPrefix(TreeNode r)
	{
		if(r==null)
			return;
		
		System.out.println(r.getValue());
		recPrefix(r.getLeft());
		recPrefix(r.getRight());
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
}