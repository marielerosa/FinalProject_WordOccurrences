package Module2;

public class TBinaries {

	private Node orgWord;	
	public TBinaries(){
		this.orgWord=null;
	}
	
    static class Node {
        HashMapWO.Node finalBatch;
        Node firstBatch, secondBatch;
        
        // Node Variables 
        // first - second are null
    public Node(HashMapWO.Node n) {
        firstBatch = null;
        secondBatch = null;
        finalBatch= n;
        
       }
    }
    
    // this is a function to store the words
    public void insert(HashMapWO.Node n){
    	orgWord= storeWord(orgWord,n);
    }
    
    
    private static Node storeWord(Node n,HashMapWO.Node finalBatch) { 
        if (n == null)
            return new Node(finalBatch);   
        if (n.finalBatch.compareTo(finalBatch)>0) {
            n.firstBatch = storeWord(n.firstBatch, finalBatch); 
            return n;
            
        } else if (n.finalBatch.compareTo(finalBatch)<0) { 
            n.secondBatch = storeWord(n.secondBatch, finalBatch);
            return n;
            
        	} else
        		return n;
    }
    
    // this helps prints the stored words on NewWordDocumentaion
    public void printNewWordDocumentaion(int NewWordDocumentaion){
    	printWordCollector(orgWord,NewWordDocumentaion);
    }
   
    
   // this helps print the words in correct format 
    private void printWordCollector(Node n,int NewWordDocumentaion) {
           if( n != null ) {
        	   printWordCollector(n.firstBatch,NewWordDocumentaion); //prints all left words first
                
        	   		System.out.print(n.finalBatch.word); 
               
                printBlankSpace(12-n.finalBatch.word.length()); //inserts correct space to be aligned properly
                for(int i=0;i<=NewWordDocumentaion;i++){
                	
                	System.out.print("["+ n.finalBatch.count[i] + "]");
                	
                }	System.out.println(); 
                	printWordCollector(n.secondBatch,NewWordDocumentaion); //print all right words
            }
         }
        
    	//  spaces between words and values  
      public void printBlankSpace(int blankSpace){
    	  
      	for(int i=0;i<blankSpace;i++ ){
      		System.out.print(" ");
      }
   }


	public void printNewWordDocumentaion1(int newWordDocumentaion) {
		// TODO Auto-generated method stub
		
	}  
}
