package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 10:49 AM
 * Description: ...
 */
public class DictionaryInterface extends JFrame implements ActionListener {
	JButton searchSlangBtn;
	JButton searchDefinitionBtn;
	JButton searchHistory;
	JButton addBtn;
	JButton editBtn;
	JButton deleteBtn;
	JButton resetBtn;
	JButton randomBtn;
	JButton slangGameBtn;
	JButton definitionGameBtn;
	
	public DictionaryInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Slang Dictionary");
		
		JLabel label = new JLabel();
		label.setBounds(100, 50, 300, 50);
		label.setText("Slang Dictionary");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 150, 400, 250);
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		
		searchSlangBtn = new JButton("Search By Slang");
		searchSlangBtn.setFocusable(false);
		searchSlangBtn.addActionListener(this);
		
		searchDefinitionBtn = new JButton("Search By Definition");
		searchDefinitionBtn.setFocusable(false);
		
		searchHistory = new JButton("Search History");
		searchHistory.setFocusable(false);
		
		addBtn = new JButton("Add Slang");
		addBtn.setFocusable(false);
		
		editBtn = new JButton("Edit Slang");
		editBtn.setFocusable(false);
		
		deleteBtn = new JButton("Delete Slang");
		deleteBtn.setFocusable(false);
		
		resetBtn = new JButton("Reset Dictionary");
		resetBtn.setFocusable(false);
		
		randomBtn = new JButton("Random Slang");
		randomBtn.setFocusable(false);
		
		slangGameBtn = new JButton("Mini Game (Slang)");
		slangGameBtn.setFocusable(false);
		
		definitionGameBtn = new JButton("Mini Game (Definition)");
		definitionGameBtn.setFocusable(false);
		
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
		
		this.add(label);
		this.add(panel);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchSlangBtn) {
			this.dispose();
			SlangSearchPage slangSearchPage = new SlangSearchPage();
		}
	}
}
