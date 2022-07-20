package GameLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainMenu extends MainGame implements ActionListener{
	
	public static void main(String[] args) {
		JFrame menuFrame = new JFrame();
		JButton btnKey = new JButton("Keyboard Game");
		JButton btnDrag = new JButton("Drag and Drop Game");
		JLabel title = new JLabel("WORDLE");
		JLabel text = new JLabel("A Daily Word Game");
		JPanel pnlMain = new JPanel(new BorderLayout());
		JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pnlText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		menuFrame.setTitle("Wordle");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(500,500);
		menuFrame.setLocationRelativeTo(null);
		
		title.setFont(new Font("SansSerif", Font.BOLD,90));
		pnlTitle.add(title);
		
		text.setFont(new Font("SansSerif", Font.PLAIN, 30));
		pnlText.add(text);
		
		btnKey.addActionListener(e -> new MainGame());
		btnKey.addActionListener(e -> {menuFrame.dispose();});
		btnKey.setPreferredSize(new Dimension(170,80));
		btnKey.setBackground(new Color(83,141,78));
		pnlButton.add(btnKey);
		
		//btnDrag.addActionListener(e -> new DragAndDrop());
		btnDrag.addActionListener(e -> {menuFrame.dispose();});
		btnDrag.setPreferredSize(new Dimension(170,80));
		btnDrag.setBackground(new Color(181,159,59));
		pnlButton.add(btnDrag);
		
		pnlMain.add(pnlTitle, BorderLayout.NORTH);
		pnlMain.add(pnlButton, BorderLayout.SOUTH);
		pnlMain.add(pnlText, BorderLayout.CENTER);
		
		menuFrame.add(pnlMain);
		menuFrame.setVisible(true);
		
	}

}
