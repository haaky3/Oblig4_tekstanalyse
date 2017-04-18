import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

	public static void main(String[] args) {
		//Vi valgte å bruke resource-filer som tekst i dette prosjektet.
		//Selvfølgelig bruker vi Winston Churchill sin tale som fil.
		//Kunne ha implementert valg om ulike tekstfiler, men vi er nær innleveringsfrist, så vi står over ;)
		
		//Henter tekstdokumentet i resource-mappen
		String fileName = "churchill.txt";
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
         
        
        String[] words = null;
		try {
			//Leser innholder til filen
			String content = new String(Files.readAllBytes(file.toPath())).toUpperCase();
			
			//Splitter opp teksten 
			//Litt dårlig regex, siden den splitter opp store tall og fnutter
			//Eks. "100,000" -> ["100", "000"] og "Hitler's" -> ["Hitler", "s"]
			words = content.split("\\W+");

				
		} catch (IOException e) {
			// Greier ikke lese filen. Feil med filen
			e.printStackTrace();
			System.exit(0); //Stopper programmet hvis filen ikke eksisterer
		}
		
		//Oppretter det binære treet
		Tree wordTree = new Tree();
		
		//Legger inn alle ord i treet
		for(String w: words){
			wordTree.insert(w);
		}
		
		//Printer ut treet alfabetisk (inorder).
		wordTree.printInOrder(wordTree.root);
		
	}

}
