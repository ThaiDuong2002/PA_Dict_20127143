package GUI;

import Dictionary.SlangDictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI
 * Created by Thai Duong
 * Date 11/16/2022 - 3:38 PM
 * Description: ...
 */
public class EditSlang extends JFrame implements ActionListener {
	SlangDictionary slangDictionary;
	public EditSlang(SlangDictionary dictionary) {
		this.slangDictionary = dictionary;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Edit Slang");
		this.setResizable(false);
		
		
		
		this.setSize(500, 500);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
	
	}
}
