//Using JavaX Swing I made this GUI Interface to display answers to the final user.
// Based on Module 6 class where I learned more about GUI and JavFX.
package Module6;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class TAnalyzerGUI extends JFrame implements ActionListener {
	
	//Main Pannel
	JPanel panel = new JPanel();
	
	JLabel openingMessage, instructions;
	JButton analyzeInput;
	JTextArea inputText, frequencyList;
	JScrollPane inputArea, resultsArea;
	
	TAnalyzerGUI () {
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setTitle("Text Analyzer");
		this.setLayout(null);
		this.setVisible(true);
		
		//Setting borders
	    this.add(panel, BorderLayout.SOUTH);
	    this.add(panel, BorderLayout.EAST);
	    this.add(panel, BorderLayout.WEST);
	    this.add(panel, BorderLayout.NORTH);
	    

		
	    // Default Font 
		Font  f1  = new Font(Font.SERIF, Font.PLAIN,  12);
		Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 12);
		
		this.getContentPane().setBackground( Color.pink );
		
		//Here the user is going to be able to add his own poem/text.
		//The display text should be erased before the user make its input
		//otherwise, it is going to mess the end result
		
		inputText = new JTextArea("Hello! Insert your text here...");
		inputText.setBounds(50, 150, 300, 250);
		inputText.setLineWrap(true);
		inputText.setMargin(new Insets(10,10,10,10));
		
		//Applying Font
		inputText.setFont(f1);
		
		this.add(inputText);
		
		
		//Here is where the result for the user input is going to be displayed.
		
		frequencyList = new JTextArea("Your result will be displayed here!");
		frequencyList.setBounds(600,150,500,450);
		frequencyList.setLineWrap(true);
		frequencyList.setMargin(new Insets(12,12,12,12));
		
		//Applying Font
		frequencyList.setFont(f1);
		
		this.add(frequencyList);
		
		inputArea = new JScrollPane(inputText);
		inputArea.setBounds(50,150,500,450);
		
		resultsArea = new JScrollPane(frequencyList);
		resultsArea.setBounds(600,150,500,450);
		
		//Title
		
		openingMessage = new JLabel("- Word Occurences Application -");
		
		openingMessage.setBounds(475,25,200,50);
		
		//Applying Font
		openingMessage.setFont(f2);
		
		instructions = new JLabel("	Write or paste your desired text below to receive a word occurence analysis.");
		instructions.setBounds(315,60,500,50);
		
		//Applying Font
		instructions.setFont(f2);
		
		//running button
		
		analyzeInput = new JButton("GO!");
		analyzeInput.setBounds(475,675,200,50);
		analyzeInput.addActionListener(this);
		analyzeInput.setBackground( Color.white );
		
		//Adding objects to jFrame
		this.add(panel);
		this.add(openingMessage);
		this.add(instructions);
		this.add(analyzeInput);
		this.add(inputArea);
		this.add(resultsArea);
		
	}
	

		//This function prints out the frequency of each word that is pasted/typed into the input area of the program
				@Override
				
				public void actionPerformed(java.awt.event.ActionEvent e) { 
					String userArea = inputText.getText();
					try (Scanner userInput = new Scanner(userArea)) {
						Map<String, Integer> wordFrequency = new HashMap<>();
						
						while (userInput.hasNext()) {
							String word = userInput.next();
							if(wordFrequency.containsKey(word) == false)
								wordFrequency.put(word,1);
							else {
								int count = (int)(wordFrequency.get(word));
								wordFrequency.remove(word);
								wordFrequency.put(word, count + 1);
								
								}
							
					        }
						
						frequencyList.setText("The following words have been analyzed: \n" + "\n" + wordFrequency);
					}
				}
				
			//Enables the program to run
			public static void main(String[] args) {
				new TAnalyzerGUI();
				
				}	
		}
