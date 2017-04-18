//Hovedtre
public class Tree {
	
	//Noder til treet
	public class Node {
		
		public String word;
		public int count;
		public Node left, right;
		
		public Node(String w){
			this.word = w;
			this.left = this.right = null;
			this.count = 1;
		}
			
	}
	
	Node root;
	
	//Når treet blir opprettet blir en tom node lagt inn
	public Tree()
    {
		root = null;
    }
	
	//Sjekk om tre er tomt
	public boolean isEmpty()
    {
		return (root == null);
    }
	
	//Legger til ny node eller høyner count på noder som finnes
	public void insert(String w)
    {

		// Hvis treet er tomt blir første node lagt inn
		if (isEmpty())
		{
		    root = new Node(w);
		    return;
		}

		Node current = root;
		boolean finished = false;
		
		// Leter etter node i treet. 
		while (!finished)
		{
			//Sjekker noden og ordet
			int compare = current.word.compareTo(w);
			
			//HVis vi finner en node i treet som allerede har samme verdi,
			//så skal ingen ny node blir lagt inn, men count til noden blir større.
			if(compare == 0){
				current.count++;
				finished = true;
			}
			//Ordet er alfabetisk før noden vi sjekker
			else if (compare > 0)
		    {
				//Hvis nodens venstre node er tom, så lages en ny node med ordet
				if (current.left == null)
				{
				    current.left = new Node(w);
				    finished = true;
				}
				//Hvis ikke nodens venstre node er tom, går vi til den og sjekker igjen.
				else {
				    current = current.left;
				}
			}
			//Ordet er alfabetisk etter noden vi sjekker
		    else if (compare < 0)
		    {
		    	//Hvis nodens høyre node er tom, så lages en ny node med ordet
				if (current.right == null)
				{
				    current.right = new Node(w);
				    finished = true;
				}
				//Hvis ikke nodens høyre node er tom, går vi til den og sjekker igjen.
				else {
				    current = current.right;
				}
			}
		}
	}
	
	//Printer ut fra satt node hele treet inorder.
	public void printInOrder(Node n){
		if(n != null){
			printInOrder(n.left);
			//Formatering i terminal for utskrift
			System.out.printf("%-20s%s%n",n.word,n.count);
			printInOrder(n.right);
		}
	}
}
