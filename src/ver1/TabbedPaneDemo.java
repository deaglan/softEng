package ver1;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TabbedPaneDemo {

	
	public TabbedPaneDemo() {
		JTabbedPane examLayouts = new JTabbedPane();
//		TabbedPane matchAns  = new JTabbedPane();
		

		JComponent mcqPanel = makeTextPanel("MCQs");
		


		examLayouts.add("Demo",mcqPanel);
	}		
//		JPanel pan1 = new JPanel();
//		JPanel pan2 = new JPanel();
//		JPanel pan3 = new JPanel();
//		JFrame f1 = new JFrame();
		//f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//pan1.add.addTab("True/False", pan1);
		 private static void createAndShowGUI() {
		        //Create and set up the window.
		        JFrame frame = new JFrame("TabbedPaneDemo");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		         
		        //Add content to the window.
		        frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);
		         
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
		    }
	
	 protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }
	 
	 public static void main(String[] args) {
	        //Schedule a job for the event dispatch thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
	        createAndShowGUI();
	            }
	        });
	 }
}
