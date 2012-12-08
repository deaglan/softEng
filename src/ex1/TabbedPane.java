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
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class TabbedPane extends JPanel {
	String giftString;
	static File gFile = new File("C:/Users/samsung/Desktop/giftFile.txt");
	static GiftFile giftFile;
	
	String correct = "";
	String wrong1 = "";
	String wrong2 = "";
	String wrong3 = "";
	

	public TabbedPane() {
		JTabbedPane giftInput = new JTabbedPane();
		 JPanel jplInnerPanel1 = createTrueFalseInnerPanel();
		 giftInput.addTab("True/False Question", jplInnerPanel1);
		 JPanel jplInnerPanel2 = createMCQInnerPanel();
		 giftInput.addTab("MCQs", jplInnerPanel2);
		 giftInput.setSelectedIndex(0);
		 JPanel jplInnerPanel3 = createMatchInnerPanel();
		 giftInput.addTab("Question/Answer Matching", jplInnerPanel3);
		 JPanel jplInnerPanel4 = createEssayPanel();
		 giftInput.addTab("Essay Question", jplInnerPanel4);
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
				if (jcTrue.isSelected())
					questionAnswer = "T";
				else
					questionAnswer = "F";
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(),
						jtQuestion.getText(), questionAnswer);
			}
		});
		return jp;
	}

	protected JPanel createMCQInnerPanel() {
		JPanel jp = new JPanel(new MigLayout("",
				"[align right, grow][][grow][][grow]", "[][grow][][]"));

		JLabel jlQTitle = new JLabel("Question Title:");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap, grow, span 4 ");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text");
		jp.add(jlQuestion);
		jp.add(jtQuestion, "span 4, wrap, grow");

		JLabel jlCorrectAnswer = new JLabel("Correct Answer");
		final ButtonGroup btnGrp = new ButtonGroup();
		final JRadioButton opt1 = new JRadioButton("");
		final JRadioButton opt2 = new JRadioButton("");
		final JRadioButton opt3 = new JRadioButton("");
		final JRadioButton opt4 = new JRadioButton("");
		final JTextField posAns1 = new JTextField("");
		final JTextField posAns2 = new JTextField("");
		final JTextField posAns3 = new JTextField("");
		final JTextField posAns4 = new JTextField("");
		btnGrp.add(opt1);
		btnGrp.add(opt2);
		btnGrp.add(opt3);
		btnGrp.add(opt4);
		jp.add(jlCorrectAnswer);
		jp.add(opt1);
		jp.add(posAns1, "align left,grow");
		jp.add(opt2);
		jp.add(posAns2, "wrap, grow");
		jp.add(opt3, "skip");
		jp.add(posAns3, "grow");
		jp.add(opt4);
		jp.add(posAns4, "wrap, grow");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (opt1.isSelected()) {
					correct = posAns1.getText();
					wrong1 = posAns2.getText();
					wrong2 = posAns3.getText();
					wrong3 = posAns4.getText();
				}
				if (opt2.isSelected()) {
					correct = posAns2.getText();
					wrong1 = posAns1.getText();
					wrong2 = posAns3.getText();
					wrong3 = posAns4.getText();
				}
				if (opt3.isSelected()) {
					correct = posAns3.getText();
					wrong1 = posAns2.getText();
					wrong2 = posAns1.getText();
					wrong3 = posAns4.getText();
				}
				if (opt4.isSelected()) {
					correct = posAns4.getText();
					wrong1 = posAns2.getText();
					wrong2 = posAns3.getText();
					wrong3 = posAns1.getText();
				}
				giftFile.createMCQuestion(jtQuestionTitle.getText(),
						jtQuestion.getText(), correct, wrong1,
						wrong2, wrong3);
			}
		});
		return jp;
	}
	
	
	protected JPanel createMatchInnerPanel() {
		JPanel jp = new JPanel(new MigLayout("",
				"[align right, grow][][grow][grow]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title:");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap, grow, span 4 ");
		JLabel aLabel = new JLabel("A");
		JLabel bLabel = new JLabel("B");
		JLabel cLabel = new JLabel("C");
		final JTextField jtQuestion = new JTextField();
		final JTextField jtQuestion2 = new JTextField();
		final JTextField jtQuestion3 = new JTextField();
		final JTextField jtAns =new JTextField();
		final JTextField jtAns2 =new JTextField();
		final JTextField jtAns3 =new JTextField();
		JLabel jlCorrectAnswer = new JLabel("Correct Answers");
		
		

		
		jp.add(jlCorrectAnswer, "align left");
		jp.add(aLabel, "align left");
		jp.add(jtQuestion, " grow");
		jp.add(jtAns, "grow,wrap");
		jp.add(bLabel,"skip");
		jp.add(jtQuestion2, " grow");
		jp.add(jtAns2, "span, wrap, grow");
		jp.add(cLabel, "skip");
		jp.add(jtQuestion3, "grow");
		jp.add(jtAns3, "span,grow,wrap");
		

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


			giftFile.createMatchQuestion(jtQuestionTitle.getText(), 
						jtQuestion.getText(), jtAns.getText(), jtQuestion2.getText(),jtAns2.getText(), jtQuestion3.getText(), 
						jtAns3.getText());
			}
		});
		return jp;
	}
	
	protected JPanel createEssayPanel() {
		JPanel jp = new JPanel(new MigLayout("", "[align right][fill]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title:");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 4, 10);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap");

		JLabel jlCorrectAnswer = new JLabel("Correct Answer");
		final JTextArea jtAns = new JTextArea("", 0,10);

		jp.add(jlCorrectAnswer);
		jp.add(jtAns, "grow,flowy,wrap");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(),
						jtQuestion.getText(), jtAns.getText());
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
