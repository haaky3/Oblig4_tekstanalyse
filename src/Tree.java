public class Tree {
	
	public class Node {
		public String word;
		public int count;
		public Node left, right;
		
		public Node(String w){
			this.word = w;
			this.left = this.right = null;
			this.count = 1;
		}
		
		@Override
		public String toString() {
			return this.word + "\t\t\t\t" + this.count;
		}
	}
	
	Node root;
	
	public Tree()
    {
		root = null;
    }
	
	public boolean isEmpty()
    {
		return (root == null);
    }
	
	public void insert(String value)
    {

		// Create new root if tree is empty
		if (isEmpty())
		{
		    root = new Node(value);
		    return;
		}

		Node current = root;
		boolean finished = false;
		
		// Insert new node as a leaf in the tree
		while (!finished)
		{
			int compare = current.word.compareTo(value);
			
			if(compare == 0){
				current.count++;
				finished = true;
			}
			else if (compare > 0)
		    {
				if (current.left == null)
				{
				    current.left = new Node(value);
				    finished = true;
				}
				else {
				    current = current.left;
				}
			}
		    else if (compare < 0)
		    {
				if (current.right == null)
				{
				    current.right = new Node(value);
				    finished = true;
				}
				else {
				    current = current.right;
				}
			}
		}
	}
	
	public void printInOrder(Node n){
		if(n != null){
			printInOrder(n.left);
			System.out.printf("%-20s%s%n",n.word,n.count);
			printInOrder(n.right);
		}
	}
}
