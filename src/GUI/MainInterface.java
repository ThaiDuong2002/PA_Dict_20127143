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
 * Date 11/16/2022 - 10:49 AM
 * Description: ...
 */
public class MainInterface extends JFrame implements ActionListener {
	private final SlangDictionary slangDictionary;
	private final JButton searchSlangBtn, searchDefinitionBtn, searchHistory;
	private final JButton addBtn, editBtn, deleteBtn;
	private final JButton resetBtn, randomBtn;
	private final JButton slangGameBtn, definitionGameBtn;
	private final JButton cancelBtn;
	
	public MainInterface(SlangDictionary dictionary) {
		this.slangDictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Slang Dictionary");
		this.setResizable(false);
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Slang Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 130, 400, 250);
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		
		searchSlangBtn = new JButton("Search By Slang");
		searchSlangBtn.setFocusable(false);
		searchSlangBtn.addActionListener(this);
		
		searchDefinitionBtn = new JButton("Search By Definition");
		searchDefinitionBtn.setFocusable(false);
		searchDefinitionBtn.addActionListener(this);
		
		searchHistory = new JButton("Search History");
		searchHistory.setFocusable(false);
		searchHistory.addActionListener(this);
		
		addBtn = new JButton("Add Slang");
		addBtn.setFocusable(false);
		addBtn.addActionListener(this);
		
		editBtn = new JButton("Edit Slang");
		editBtn.setFocusable(false);
		editBtn.addActionListener(this);
		
		deleteBtn = new JButton("Delete Slang");
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(this);
		
		resetBtn = new JButton("Reset Dictionary");
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		randomBtn = new JButton("Random Slang");
		randomBtn.setFocusable(false);
		randomBtn.addActionListener(this);
		
		slangGameBtn = new JButton("Mini Game (Slang)");
		slangGameBtn.setFocusable(false);
		slangGameBtn.addActionListener(this);
		
		definitionGameBtn = new JButton("Mini Game (Definition)");
		definitionGameBtn.setFocusable(false);
		definitionGameBtn.addActionListener(this);
		
		panel.add(searchSlangBtn);
		panel.add(searchDefinitionBtn);
		panel.add(searchHistory);
		panel.add(addBtn);
		panel.add(editBtn);
		panel.add(deleteBtn);
		panel.add(resetBtn);
		panel.add(randomBtn);
		panel.add(slangGameBtn);
		panel.add(definitionGameBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setFocusable(false);
		cancelBtn.setBounds(200, 400, 100, 30);
		cancelBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cancelBtn.addActionListener(this);
		
		this.add(label);
		this.add(panel);
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
		if (searchSlangBtn.equals(e.getSource())) {
			this.dispose();
			new SearchBySlang(this.slangDictionary);
		} else if (searchDefinitionBtn.equals(e.getSource())) {
			this.dispose();
			new SearchByDefinition(this.slangDictionary);
		} else if (searchHistory.equals(e.getSource())) {
			this.dispose();
			new SearchHistory(this.slangDictionary);
		} else if (addBtn.equals(e.getSource())) {
			this.dispose();
			new AddSlang(this.slangDictionary);
		} else if (editBtn.equals(e.getSource())) {
			this.dispose();
			new EditSlang(this.slangDictionary);
		} else if (deleteBtn.equals(e.getSource())) {
			this.dispose();
			new DeleteSlang(this.slangDictionary);
		} else if (randomBtn.equals(e.getSource())) {
			this.dispose();
			new RandomSlang(this.slangDictionary);
		} else if (resetBtn.equals(e.getSource())) {
			this.dispose();
			new ResetDict(this.slangDictionary);
		} else if (slangGameBtn.equals(e.getSource())) {
			this.dispose();
			new SlangGame(this.slangDictionary);
		} else if (definitionGameBtn.equals(e.getSource())) {
			this.dispose();
			new DefinitionGame(this.slangDictionary);
		} else if (e.getSource() == cancelBtn) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
