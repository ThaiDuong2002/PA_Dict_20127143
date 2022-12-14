package GUI;

import Dictionary.SlangDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:36 PM
 * Description: ...
 */
public class SearchByDefinition extends JFrame implements ActionListener {
	private final SlangDictionary slangDictionary;
	private final JButton searchBtn;
	private final JButton backBtn, cancelBtn;
	private final JTextField textField;
	private final JList<String> list;
	
	public SearchByDefinition(SlangDictionary dictionary) {
		this.slangDictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Search By Definition");
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Search Slang By Definition");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 100, 400, 160);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		
		JLabel container = new JLabel();
		container.setText("Input the definition you want to search");
		container.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		container.setForeground(Color.BLACK);
		container.setBounds(60, 10, 300, 50);
		
		textField = new JTextField();
		textField.setBounds(50, 60, 300, 30);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setForeground(Color.BLACK);
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		searchBtn.setForeground(Color.BLACK);
		searchBtn.setFocusable(false);
		searchBtn.setBounds(150, 100, 100, 30);
		searchBtn.addActionListener(this);
		
		panel.add(container);
		panel.add(textField);
		panel.add(searchBtn);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList<>(model);
		list.setForeground(Color.BLACK);
		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 280, 400, 100);
		
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
		this.add(panel);
		this.add(scrollPane);
		this.add(backBtn);
		this.add(cancelBtn);
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
		} else if (e.getSource() == searchBtn) {
			String word = textField.getText().replaceAll(" ", "");
			List<String> items = this.slangDictionary.findByDefinition(word);
			if (items != null) {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addAll(items);
				list.setModel(temp);
			}else {
				DefaultListModel<String> temp = new DefaultListModel<>();
				temp.addElement(textField.getText() + " doesn't exist.");
				list.setModel(temp);
			}
		}
	}
}
