package GUI;

import Dictionary.SlangDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:39 PM
 * Description: ...
 */
public class ResetDict extends JFrame implements ActionListener {
	private final SlangDictionary slangDictionary;
	private final JButton backBtn, cancelBtn;
	private final JButton resetBtn;
	private final JLabel notify;
	
	public ResetDict(SlangDictionary dictionary) {
		this.slangDictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Reset Dictionary");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Reset Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JLabel question = new JLabel();
		question.setBounds(100, 150, 300, 50);
		question.setText("Do you want to reset?");
		question.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		question.setForeground(Color.BLACK);
		question.setHorizontalTextPosition(JLabel.CENTER);
		question.setVerticalTextPosition(JLabel.CENTER);
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setVerticalAlignment(JLabel.CENTER);
		
		resetBtn = new JButton("Reset");
		resetBtn.setFocusable(false);
		resetBtn.setBounds(200, 200, 100, 30);
		resetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		resetBtn.addActionListener(this);
		
		notify = new JLabel();
		notify.setBounds(100, 250, 300, 50);
		notify.setText("Reset successfully.");
		notify.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		notify.setForeground(Color.BLACK);
		notify.setHorizontalTextPosition(JLabel.CENTER);
		notify.setVerticalTextPosition(JLabel.CENTER);
		notify.setHorizontalAlignment(JLabel.CENTER);
		notify.setVerticalAlignment(JLabel.CENTER);
		notify.setVisible(false);
		
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
		
		this.add(backBtn);
		this.add(cancelBtn);
		this.add(resetBtn);
		this.add(label);
		this.add(question);
		this.add(notify);
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
		} else if (e.getSource() == resetBtn) {
			this.slangDictionary.resetDictionary();
			notify.setVisible(true);
		}
	}
}
