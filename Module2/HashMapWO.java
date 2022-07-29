package Module2;

public class HashMapWO { // this class is used to define the size of a hash table
	// the hash tables are very important in this assignment in order to make it work properly
	
    private int sizeHMap; 
    private Node[] tableHashMap; 
    public HashMapWO(int tableSize) {
    	sizeHMap = tableSize;
        tableHashMap = new Node[sizeHMap];
    }
   
    public Node[] getTableInfo(){
    	return tableHashMap;
    }
    
   
    public void printHashTable() {
        for (int i = 0; i < sizeHMap; i++) {
        printWordCabinet(tableHashMap[i], i);
        
     }
 }
    
    
    public int[] toIntArray() {
        int [] hashArray = new int[sizeHMap];
        	
        	for (int i = 0; i < sizeHMap; ++i) {
        		hashArray[i] = Node.length(tableHashMap[i]);
        	
     }	return hashArray;        
 }

   
    private void printWordCabinet(Node n, int wordIndex) { // the function of this is to store the values after analyzing
        if (n == null);
        
        else if (n.next == null) {
            System.out.print(n.word + "    [" + wordIndex + "]\n");
            
        	} else {
        		
        		System.out.print(n.word + ", ");
        		printWordCabinet(n.next, wordIndex);
        }
    }

    static public class Node implements Comparable<Node> {
        String word;

        public  int[] count; // this counts how many times the word repeats in the text given by th user 
        Node next;
        public Node(String nString, int wordDoc) {
            word = nString;
            next = null;
            count= new int[10];
            count[wordDoc]=1; 
            
        }
        
        // Following function is to add all the words that repeat in the text
        public int nAdd(){
        	int nTotal=0;
        	for(int i=0;i<10;i++){
        	nTotal= count[i] + nTotal;
        	
        	}	return nTotal;
        }
       
       
        public int compareTo(Node n){
        	if(this.nAdd() > n.nAdd()){ 
        		return -1; 
        		
        	} else if(this.nAdd()==n.nAdd()){
        		return this.word.compareTo(n.word);
        		
        	} else if(this.nAdd() < n.nAdd()){
        		return 1;
        		
        	} else {
        		return 0;
       }
        	        	
    }

        static public int length(Node n) {
            if (n == null) {
                return 0;
            	
            } else {
                return 1 + length(n.next);
            }
        }
    }

    public Boolean member(String bmString) {
        int boolMem = HashValuesWO.addValues(bmString, sizeHMap);
        return member(bmString, tableHashMap[boolMem]);
    }

    Boolean member(String bmString, Node boolMem) {
        if (boolMem == null)
            return false;
        else if (bmString.equals(boolMem.word))
            return true;
        else
            return member(bmString, boolMem.next);
    }

    Boolean member(String s, String[] bmOrdering) {
        Boolean findWord = false;
        for (int i = 0; i < bmOrdering.length; i++) {
            if (s.equals(bmOrdering[i])) {
            	findWord = true;
                
            	break;
            }
            
        } return findWord;
    }

    // this analyzes the already stored words and determines if it is done counting or there are no repeating words left before printing
    private Node storeW(String swString, Node n,int wordDoc) {
        if (n == null)
            return new Node(swString, wordDoc); 
        else if (swString.equals(n.word)) { 
           n.count[wordDoc]++; 
        	
           return n;
            
        } else { 
            n.next = storeW(swString, n.next, wordDoc);
            
            return n;
        }
    }
    
    // in the case of words not wanting to be read by the analyzer
    public void insert(String ulwString, int wordDoc) {
    	String unlistedWords[]={" "};
    	for(int i=0;i < unlistedWords.length;i++){
    		if(ulwString.equals(unlistedWords[i])){
    			
    		return;
    		
    		}
    		
    	} int wordStorage = 0;
    	
        	wordStorage = HashValuesWO.addValues(ulwString, sizeHMap); 

        		tableHashMap[wordStorage] = storeW(ulwString, tableHashMap[wordStorage], wordDoc); 
    	}

	}