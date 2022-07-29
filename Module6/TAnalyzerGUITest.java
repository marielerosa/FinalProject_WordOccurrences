package Module6;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TAnalyzerGUITest {

	// USED THIS TO PERFORM A PASS OR FAIL TEST ON JUNIT
	 
	@Test
	public void TestAnalyzerGUI() {

	}		
	
		public static void main(String[] args) {
		      Result TestAnalyzerResults = JUnitCore.runClasses(TAnalyzerGUI.class);
				
		      for (Failure failure : TestAnalyzerResults.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
		      System.out.println(TestAnalyzerResults.wasSuccessful());
	
	}
}
