import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "churchill.txt";
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
         

        System.out.println("File Found : " + file.exists());
         
        //Read File Content
        String[] words = null;
		try {
			String content = new String(Files.readAllBytes(file.toPath())).toUpperCase();
			words = content.split("\\W+");

				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		Tree wordTree = new Tree();
		
		for(String w: words){
			wordTree.insert(w);
		}
		
		wordTree.printInOrder(wordTree.root);
		
	}

}
