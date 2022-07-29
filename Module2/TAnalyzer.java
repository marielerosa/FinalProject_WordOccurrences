package Module2;

import java.util.Scanner;

public class TAnalyzer {

	public TAnalyzer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main (String [] args){
		@SuppressWarnings("resource")
		Scanner textAnalyzer = new Scanner(System.in); // this piece makes it a scanner to TAnalyzer
		
		openingMsg(); 
		// I used this to print an opening message to this project
		
		String wordLine= textAnalyzer.nextLine();
		int NewWordDocumentaion=0; // This creates a new variabel called NewNewWordDocumentaion
		HashMapWO hashArray = new HashMapWO(10000); 
		
		while(!(wordLine.equals("STOP"))){ // these are used to STOP or add NEW documents on the analyzer
			if(wordLine.equals("NEW")){ 
				NewWordDocumentaion++;
				
			} else {
				String[] lineArray = wordLine.toLowerCase().split("\\W+"); 
				
				for(int i=0;i<lineArray.length;i++){
					hashArray.insert(lineArray[i],NewWordDocumentaion);  
				}	
			} wordLine= textAnalyzer.nextLine(); 

		}
		
		TBinaries binaryOne =new TBinaries(); // this makes a binary tree
		
		HashMapWO.Node[] currentHash= hashArray.getTableInfo(); 
		for(int i=0;i<currentHash.length;i++){ 
			if(!(currentHash[i]==null)){ 
				HashMapWO.Node n = currentHash[i]; 
				
				while(n!=null){ 
					binaryOne.insert(n); 
					n=n.next; 
				}
			}
		} binaryOne.printNewWordDocumentaion(NewWordDocumentaion); // this prints the words stored in the variable NewWordDocumentaion
	}
	
	public static void openingMsg(){
		System.out.println("Here you can write or paste the text you want to be analyzed below by the Word Occurencies Application" +
		" \nYou should type (NEW) to add a new piece of text or (STOP) to quit the text analyzer application.\n\n Have fun!\n");
	}

}