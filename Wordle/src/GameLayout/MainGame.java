package GameLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainGame implements ActionListener {
	
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.time.Duration;
	import java.time.Instant;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Random;
	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.Border;

	public class MainGame implements ActionListener {

	    static class PnlWords extends JPanel {

	        JLabel[] pnlWordVertical = new JLabel[5];

	        public PnlWords() {
	            this.setLayout(new GridLayout(1, 5));
	            Border borderLayout = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
	            for (int i = 0; i < 5; i++) {
	                pnlWordVertical[i] = new JLabel();
	                pnlWordVertical[i].setHorizontalAlignment(JLabel.CENTER);
	                pnlWordVertical[i].setOpaque(true);
	                pnlWordVertical[i].setBorder(borderLayout);
	                this.add(pnlWordVertical[i]);
	            }
	        }

	        public void clearPnlWords() {
	            for (int i = 0; i < 5; i++) {
	                pnlWordVertical[i].setText("");
	            }
	        }

	        public void setPanelText(String charValue, int position, Color color) {
	            this.pnlWordVertical[position].setText(charValue);
	            this.pnlWordVertical[position].setBackground(color);
	        }
	    }

	    static class PnlInput extends JPanel implements ActionListener {

	        private JTextField input;
	        private JButton btnEnter;

	        public PnlInput() {
	            this.setLayout(new GridLayout(1, 2));
	            input = new JTextField();
	            this.add(input);

	            btnEnter = new JButton("Enter");
	            btnEnter.addActionListener(e->input.setText(null));
	            this.add(btnEnter);
	        }

	        public JTextField getInput() {
	            return input;
	        }

	        public JButton getBtnEnter() {
	            return btnEnter;
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }
	    }

	    private JFrame mainFrame;
	    private PnlWords[] pnlWordArray = new PnlWords[6];
	    private PnlInput pnlUser;
	    private String wordleAns;
	    private int userTry = 0;
	    WinAnimation t;


	    public main() {
	        mainFrame = new JFrame("Wordle Game");
	        mainFrame.setSize(500, 500);
	        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        mainFrame.setLayout(new GridLayout(7, 1));
	        mainFrame.setVisible(true);
	        mainFrame.setLocationRelativeTo(null);

	        for (int i = 0; i < 6; i++) {
	            pnlWordArray[i] = new PnlWords();
	            mainFrame.add(pnlWordArray[i]);
	        }
	        pnlUser = new PnlInput();
	        pnlUser.getBtnEnter().addActionListener(this);
	        mainFrame.add(pnlUser);
	        mainFrame.revalidate();

	        wordleAns = getWordbank();
	        System.out.println("The Word : " + wordleAns);
	    }

	    public static void main(String[] args) {
	        new main();
	    }

	    //add time
	    //add dictionary



	    private boolean isWordleWordEqualTo(String inputWord) {
	        List<String>answerWord = Arrays.asList(wordleAns.split(""));
	        String[] inputArr = inputWord.split("");
	        List<Boolean> ansEqualTo = new ArrayList<>();

	        for (int i = 0; i < 5; i++) {
	            if (answerWord.contains(inputArr[i])) {
	                if (answerWord.get(i).equals(inputArr[i])) {
	                    getInputPnl().setPanelText(inputArr[i], i, Color.GREEN);
	                    ansEqualTo.add(true);
	                } else {
	                    getInputPnl().setPanelText(inputArr[i], i, Color.YELLOW);
	                    ansEqualTo.add(false);
	                }
	            } else {
	                getInputPnl().setPanelText(inputArr[i], i, Color.GRAY);
	                ansEqualTo.add(false);
	            }
	        }
	        return !ansEqualTo.contains(false);
	    }


	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Instant start = Instant.now();
	        int choice;

	        String userWord = this.pnlUser.getInput().getText();
	        if(userTry > 5){

	            choice = JOptionPane.showOptionDialog(null, "You Lost." + "Try Again?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	            if(choice == JOptionPane.YES_OPTION) {
	                new WinAnimation();
	                return;
	            }
	            else if(choice == JOptionPane.NO_OPTION) {
	                t = new WinAnimation();
	                mainFrame.dispose();
	                return;
	            }
	            else if(choice == JOptionPane.CANCEL_OPTION){
	                mainFrame.dispose();
	                return;
	            }

	            return;
	        }
	        if (userWord.length() > 4) {
	            if(isWordleWordEqualTo(userWord.trim().toUpperCase())){
	                Instant finish = Instant.now();
	                long timeElapsed = Duration.between(start, finish).toMillis();
	                choice = JOptionPane.showOptionDialog(null, "You Win." + "\nTime: " + timeElapsed + "s" + "\nNew Game?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	                if(choice == JOptionPane.YES_OPTION) {
	                    new main();
	                    mainFrame.dispose();
	                    return;
	                }
	                else if(choice == JOptionPane.NO_OPTION) {
	                    t = new WinAnimation();
	                    mainFrame.dispose();
	                    return;
	                }
	                else if(choice == JOptionPane.CANCEL_OPTION){
	                    mainFrame.dispose();
	                    return;
	                }
	                return;
	            }
	        }
	        userTry++;
	    }

	    public PnlWords getInputPnl() {
	        return this.pnlWordArray[userTry];
	    }

	    public String getWordbank() {
	        Path path = Paths.get("src/wordBank.txt");
	        List<String> wordList = new ArrayList<>();
	        try {
	            wordList = Files.readAllLines(path);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Random random = new Random();
	        int position = random.nextInt(wordList.size());
	        return wordList.get(position).trim().toUpperCase();
	    }

}
