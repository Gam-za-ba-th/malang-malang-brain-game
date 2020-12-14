package animal;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class animal implements ActionListener{
	static String[] images = {
			"animal_image/BSM20.jpg", "animal_image/CAO18.jpg", "animal_image/CCO14.jpg", "animal_image/DOS22.jpg",
			"animal_image/DSC18.jpg", "animal_image/MDS16.jpg", "animal_image/PCC8.jpg", "animal_image/SCP14.jpg"
	};
	
	JFrame legFrame;
	
	JPanel legPanel, imagePanel;
	
	JLabel guessLabel, titleLabel, scoreLabel, textLabel, imageLabel;
	
	ImageIcon imageIcon;
	
	JButton scoreButton;
	
	JTextField guessText;
	
	int i;
	
	Random rand = new Random();
    int index = rand.nextInt(8)+1;
    
    int guess;
    int answer;
    int score = 30;
    
    public animal()
	{
		
		legFrame = new JFrame();
		legFrame.setTitle("동물 다리 개수 맞추기");

		legFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		legPanel = new JPanel();
		legPanel.setLayout(new GridLayout(5,0));
		
        legFrame.getContentPane().add(legPanel, BorderLayout.CENTER);

		
		displayWidgets();
	
		legFrame.pack();
        legFrame.setVisible(true);
	}
    
    public void displayWidgets() 
    {
    	titleLabel = new JLabel("동물의 총 다리 개수 맞추기", SwingConstants.CENTER);
	    titleLabel.setFont(new Font("굴림", Font.BOLD, 30));
			
	    guessLabel = new JLabel("다리 개수를 입력하세요", SwingConstants.CENTER);
	    guessLabel.setFont(new Font("굴림", Font.CENTER_BASELINE, 20));
	     
	    textLabel = new JLabel(" ", SwingConstants.CENTER);
	    
	    guessText = new JTextField();
	    guessText.setHorizontalAlignment(JTextField.CENTER);
	    guessText.addActionListener(this);

	    imageIcon = new ImageIcon(images[index]);
	    imageLabel = new JLabel(imageIcon);
	    
	    ImageIcon scoreicon = new ImageIcon("socreicon.png");

        scoreButton = new JButton("점수를 확인하세요");
        scoreButton.setPressedIcon(scoreicon);
        
        scoreButton.addMouseListener(new MyMouseListener());

	    legPanel.add(titleLabel);
	    legPanel.add(guessLabel);
	    legPanel.add(imageLabel);
	    legPanel.add(guessText);
	    legPanel.add(scoreButton);
	    
	    if (index == 0)	answer = 20;
	    if (index == 1) answer = 18;
	    if (index == 2) answer = 14;
	    if (index == 3) answer = 22;
	    if (index == 4) answer = 18;
	    if (index == 5) answer = 16;
	    if (index == 6) answer = 8;
	    if (index == 7) answer = 14;

    }
    
    public void actionPerformed(ActionEvent event) 
    {        
    	guess = Integer.parseInt(guessText.getText());

        if (guess == answer)
        {
            score++;
            JOptionPane.showMessageDialog(null, "정답입니다", "", JOptionPane.INFORMATION_MESSAGE);
            scoreButton.setEnabled(true);
        }
        
        else
        {
        	score--;
        	JOptionPane.showMessageDialog(null, "오답입니다", "", JOptionPane.INFORMATION_MESSAGE);
        	scoreButton.setEnabled(false);
        }
	}
    
    class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
     	   if (e.getSource() == scoreButton)
     		   scoreButton.setText("점수는 " + score);
			}

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
		
			
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
			
			
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
			
			
        }
    }
    
    public static void main(String[] args)
    {
        animal frame = new animal();
    } 
}
