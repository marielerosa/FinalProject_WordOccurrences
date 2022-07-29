package Module10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

	public class WordOccurrencesDB {
		
		 // @param args is below
	
		public static void main(String[] args)
{
			int moreInput;

		do {
			
		@SuppressWarnings("resource")
		Scanner dbWordOccurrences = new Scanner(System.in);
			
			try {
				System.out.println(" Enter here a word to input into the Wod Occurences Database:");
				String userInput = dbWordOccurrences.next();
				
// Connection to the Database for this project 
				// db called word_occurences
				//table is called words
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection connectWords = DriverManager.getConnection("jdbc:mysql://localhost/word_occurences","root","123456");

				PreparedStatement dbSent = connectWords.prepareStatement("insert into word (words) values(?)");
				dbSent.setString(1,userInput);
				dbSent.executeUpdate();
				
// Output after the database is updated
				// does the user wish to insert more?
				
				System.out.println("Here is the updated Database ");
				Statement filterWords = connectWords.createStatement();
				ResultSet printWords = filterWords.executeQuery("select * from word");

			while(printWords.next()) {
				
				System.out.println(printWords.getString(1));
			
			} connectWords.close();
		}
			
			catch(ClassNotFoundException |SQLException e){
				
				System.out.println(e.getMessage());
			}
			
		// do the user wants to input more words into the db?
			
			System.out.println("Do you wish to enter more words into the database? (1 = YES; 0 = NO)");
			moreInput = dbWordOccurrences.nextInt();
			
		} while(moreInput==1);
		
		// Final output to the user
		
		System.out.println(" This is the list of words + how many time they occurred: ");
		Map<String,Integer> countWords = new LinkedHashMap<>();

		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection connectWords = DriverManager.getConnection("jdbc:mysql://localhost/word_occurences","root","123456");
			Statement dbSent = connectWords.createStatement();
			ResultSet filterWords = dbSent.executeQuery("Select * from word");

				while(filterWords.next()){

					String getWords = filterWords.getString(1);
				
				if(countWords.get(getWords)==null) {
					
					countWords.put(getWords,1);
			} 
				else {

					countWords.put(getWords,countWords.get(getWords)+1);
				}
				
			} connectWords.close();
		}

			catch(ClassNotFoundException | SQLException e){
				
				System.out.println(e.getMessage());
				
			} Set<String> finalOutput = countWords.keySet();
			
			for(String finalWords:finalOutput) {
				
				System.out.println("Entered Words: "+ finalWords + " Occurrences: "+ countWords.get(finalWords));
		}
	}
}