package DeploymentAssignment;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   
	public static void main(String[] args) {
		
        //This creates a scanner 
		
		Scanner client = new Scanner(System.in);
       
		try {
			//
		//Socket connection
			
			Socket socketConn = new Socket("localhost", 8080);
			
			DataInputStream scanInput = new DataInputStream(socketConn.getInputStream());
			DataOutputStream scanOutput = new DataOutputStream(socketConn.getOutputStream());
			
		// Used to collect Users input
			
			System.out.println("Prime Number Calculator");
			// input
			System.out.print("\nEnter your numer here: ");
          
			int userInput = client.nextInt();

		//Calculates input's value
			// is it prime?
			// prints out if it isn't
			
			scanOutput.writeInt(userInput);
			String calculatedValue = (String)scanInput.readUTF();
			System.out.println("\nIs "+ userInput +
                               " a prime number? "+ calculatedValue);
			scanOutput.flush();
			scanOutput.close();
			socketConn.close();
}
       catch(Exception y) {
           
    	   System.out.println(y);
    	   
       }	client.close();
   }
}


