package GameLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WinAnimation extends MainGame implements ActionListener{
	
    public static void main(String[] args){
        JFrame winFrame = new JFrame();
        JPanel pnlWin = new JPanel(new BorderLayout());
        JPanel pnlText = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pnlScore = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblWin = new JLabel("YOU WIN L(^0^)/");
        JLabel lblScore = new JLabel("High Score:");
        JLabel lblTime = new JLabel();
        MainGame x = new MainGame();
        
        pnlWin.setBackground(Color.black);
        pnlText.setBackground(Color.black);
        pnlScore.setBackground(Color.black);
        winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winFrame.setSize(300,300);
        winFrame.setLocationRelativeTo(null);
        
        lblWin.setForeground(new Color(83,141,78));
        lblWin.setFont(new Font("SansSerif", Font.BOLD, 20));
        pnlText.add(lblWin);
        
        lblScore.setForeground(new Color(181,159,59));
        lblScore.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pnlScore.add(lblScore, BorderLayout.NORTH);
        
        pnlWin.add(pnlText, BorderLayout.NORTH);
        pnlWin.add(pnlScore, BorderLayout.CENTER);
        winFrame.add(pnlWin);
        winFrame.setVisible(true);
        
        Instant start = Instant.now();
        x.actionPerformed(null);
        Instant finish = Instant.now();
        
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        lblTime.setText(String.valueOf(timeElapsed));
        pnlScore.add(lblTime, BorderLayout.SOUTH);
        
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
