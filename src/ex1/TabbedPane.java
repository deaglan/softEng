package ex1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class TabbedPane extends JPanel {
	String giftString;
	static File gFile =  new File("C:/Users/samsung/Desktop/giftFile.txt");
	static GiftFile giftFile;
	public TabbedPane() {
		JTabbedPane giftInput = new JTabbedPane();
//		JPanel jplInnerPanel1 = createTrueFalseInnerPanel();
//		giftInput.addTab("True/False Question", jplInnerPanel1);
//		//giftInput.setSelectedIndex(0);
//		giftInput.addTab("True/False Question", jplInnerPanel1);
		JPanel jplInnerPanel2 = createMCQInnerPanel();
		giftInput.addTab("MCQs", jplInnerPanel2);
		giftInput.setSelectedIndex(0);
//		JPanel jplInnerPanel3 = createInnerPanel("Q&A Matching");
//		giftInput.addTab("Question/Answer Matching", jplInnerPanel3);
		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(giftInput);
	}

	protected JPanel createTrueFalseInnerPanel() {
		JPanel jp = new JPanel(new MigLayout("", "[align right][]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title:");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 20, 20);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap");

		JLabel jlCorrectAnswer = new JLabel("Correct Answer");
		final ButtonGroup btnGrp = new ButtonGroup();
		final JRadioButton jcTrue = new JRadioButton("True");
		final JRadioButton jcFalse = new JRadioButton("False");
		btnGrp.add(jcTrue);
		btnGrp.add(jcFalse);
		jp.add(jlCorrectAnswer, "wrap");
		jp.add(jcTrue);
		jp.add(jcFalse, "wrap");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String questionAnswer;
				if(jcTrue.isSelected())
					questionAnswer = "T";
				else
					questionAnswer = "F";
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), questionAnswer);
			}
		});
		return jp;
	}
	
	
	protected JPanel createMCQInnerPanel() {
		JPanel jp = new JPanel(new MigLayout("", "[align right][ grow, fill]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title:");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text");
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap, growxy");

		JLabel jlCorrectAnswer = new JLabel("Correct Answer");
		final ButtonGroup btnGrp = new ButtonGroup();
		final JRadioButton opt1 = new JRadioButton("");
		final JRadioButton opt2 = new JRadioButton("");
		final JRadioButton opt3 = new JRadioButton("");
		final JRadioButton opt4 = new JRadioButton("");
		btnGrp.add(opt1);
		btnGrp.add(opt2);
		btnGrp.add(opt3);
		btnGrp.add(opt4);
		jp.add(jlCorrectAnswer);
		jp.add(opt1);
		jp.add(opt2, "wrap");
		jp.add(opt3, "skip");
		jp.add(opt4, "wrap");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String questionAnswer;
				if(opt3.isSelected())
					questionAnswer = "T";
				else
					questionAnswer = "F";
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), questionAnswer);
			}
		});
		return jp;
	}
	

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Gift Question Generator");
		giftFile = new GiftFile(gFile);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new TabbedPane(), BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
