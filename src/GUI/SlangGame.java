package GUI;

import Dictionary.SlangDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:40 PM
 * Description: ...
 */
public class SlangGame extends JFrame implements ActionListener {
	private final SlangDictionary slangDictionary;
	private final JButton backBtn, cancelBtn;
	private final JButton aBtn, bBtn, cBtn, dBtn;
	private final JButton checkBtn, nextBtn;
	private final JLabel correct, wrong;
	private final JTextField answerField;
	private final String gameAnswer;
	
	public SlangGame(SlangDictionary dictionary) {
		this.slangDictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Slang Game");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 30, 300, 50);
		label.setText("Mini Game about Slang");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 80, 400, 290);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel question = new JLabel();
		question.setText("What is the definition of");
		question.setBounds(130, 10, 200, 30);
		
		JTextField word = new JTextField();
		word.setEditable(false);
		word.setBounds(150, 40, 100, 30);
		
		aBtn = new JButton();
		aBtn.setBounds(20, 100, 180, 40);
		aBtn.setFocusable(false);
		aBtn.addActionListener(this);
		
		bBtn = new JButton();
		bBtn.setBounds(200, 100, 180, 40);
		bBtn.setFocusable(false);
		bBtn.addActionListener(this);
		
		cBtn = new JButton();
		cBtn.setBounds(20, 140, 180, 40);
		cBtn.setFocusable(false);
		cBtn.addActionListener(this);
		
		dBtn = new JButton();
		dBtn.setBounds(200, 140, 180, 40);
		dBtn.setFocusable(false);
		dBtn.addActionListener(this);
		
		JLabel answer = new JLabel();
		answer.setText("Your answer:");
		answer.setBounds(10, 190, 80, 30);
		
		answerField = new JTextField();
		answerField.setEditable(false);
		answerField.setBounds(90, 190, 200, 30);
		
		checkBtn = new JButton("Check");
		checkBtn.setBounds(300, 190, 90, 30);
		checkBtn.setFocusable(false);
		checkBtn.addActionListener(this);
		
		correct = new JLabel();
		correct.setText("Correct answer");
		correct.setBounds(80, 240, 100, 30);
		correct.setVisible(false);
		
		wrong = new JLabel();
		wrong.setText("Wrong answer. Answer again.");
		wrong.setBounds(110, 240, 200, 30);
		wrong.setVisible(false);
		
		nextBtn = new JButton("Next Question");
		nextBtn.setFocusable(false);
		nextBtn.setBounds(190, 240, 120, 30);
		nextBtn.setVisible(false);
		nextBtn.addActionListener(this);
		
		String data = this.slangDictionary.slangGameA();
		String[] item = data.split("`");
		word.setText(item[0]);
		gameAnswer = item[1];
		Random random = new Random();
		List<String> chosen = new ArrayList<>(Arrays.asList(item[2].split("\\|")));
		String word1 = chosen.get(random.nextInt(chosen.size()));
		aBtn.setText(word1);
		chosen.remove(word1);
		
		String word2 = chosen.get(random.nextInt(chosen.size()));
		bBtn.setText(word2);
		chosen.remove(word2);
		
		String word3 = chosen.get(random.nextInt(chosen.size()));
		cBtn.setText(word3);
		chosen.remove(word3);
		
		dBtn.setText(chosen.get(0));
		
		panel.add(aBtn);
		panel.add(bBtn);
		panel.add(cBtn);
		panel.add(dBtn);
		panel.add(question);
		panel.add(word);
		panel.add(checkBtn);
		panel.add(correct);
		panel.add(wrong);
		panel.add(nextBtn);
		panel.add(answerField);
		panel.add(answer);
		
		backBtn = new JButton("Back");
		backBtn.setFocusable(false);
		backBtn.setBounds(50, 400, 100, 30);
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backBtn.addActionListener(this);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setFocusable(false);
		cancelBtn.setBounds(350, 400, 100, 30);
		cancelBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cancelBtn.addActionListener(this);
		
		this.add(label);
		this.add(backBtn);
		this.add(cancelBtn);
		this.add(panel);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				slangDictionary.updateData();
				slangDictionary.updateHistory();
				super.windowClosing(e);
			}
		});
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {
			this.dispose();
			new MainInterface(this.slangDictionary);
		} else if (e.getSource() == cancelBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == aBtn) {
			answerField.setText(aBtn.getText());
		} else if (e.getSource() == bBtn) {
			answerField.setText(bBtn.getText());
		} else if (e.getSource() == cBtn) {
			answerField.setText(cBtn.getText());
		} else if (e.getSource() == dBtn) {
			answerField.setText(dBtn.getText());
		} else if (e.getSource() == checkBtn) {
			if (Objects.equals(answerField.getText(), gameAnswer)) {
				correct.setVisible(true);
				nextBtn.setVisible(true);
				wrong.setVisible(false);
			} else {
				correct.setVisible(false);
				nextBtn.setVisible(false);
				wrong.setVisible(true);
			}
		} else if (e.getSource() == nextBtn) {
			this.dispose();
			new SlangGame(this.slangDictionary);
		}
	}
}
