package number;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class number implements ActionListener 
{
       JFrame numberFrame;

       JPanel numberPanel;

       JTextField guessText;

       JLabel rangeLabel, guessLabel, winLabel, scoreLabel;
       
       JButton scoreButton;

       Random rand = new Random();
       int Answer = rand.nextInt(30)+1;
       int guess;
       
       int count = 0;
       boolean win = false;
       int score;

      public number() 
      {
           numberFrame = new JFrame();
           numberFrame.setTitle("Number Guess");
           
           numberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
           
           numberPanel = new JPanel();
           numberPanel.setLayout(new GridLayout(5,0));
           
           numberFrame.getContentPane().add(numberPanel, BorderLayout.CENTER);

           displayWidgets();

           numberFrame.pack();
           numberFrame.setVisible(true);  
       }

       public void displayWidgets() 
       {  

           guessText = new JTextField();
           guessText.setHorizontalAlignment(JTextField.CENTER);
           
           rangeLabel = new JLabel("1~30 사이 숫자 중 하나를 맞추기", SwingConstants.CENTER);
           rangeLabel.setFont(new Font("굴림", Font.BOLD, 30));
           
           guessLabel = new JLabel("추측된 숫자를 입력하세요", SwingConstants.CENTER);
           guessLabel.setFont(new Font("굴림", Font.CENTER_BASELINE, 20));
           
           winLabel = new JLabel(" ", SwingConstants.CENTER);
           
           ImageIcon scoreicon = new ImageIcon("socreicon.png");

           scoreButton = new JButton("점수를 확인하세요");
           scoreButton.setPressedIcon(scoreicon);
           
           scoreButton.addMouseListener(new MyMouseListener());

           guessText.addActionListener(this);

           numberPanel.add(rangeLabel);
           numberPanel.add(guessLabel);
           numberPanel.add(guessText);
           numberPanel.add(winLabel);
           numberPanel.add(scoreButton);
          
       }

       public void actionPerformed(ActionEvent event) 
       {        
           guess = Integer.parseInt(guessText.getText());

           if ( guess == Answer)
           {
               count ++;
               winLabel.setText("정답입니다");
               winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               scoreButton.setEnabled(true);
           }
           else if ( guess < Answer)
           {
               winLabel.setText("너무 작은 숫자입니다");
               winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               winLabel.setForeground(Color.blue);
               count ++;
               scoreButton.setEnabled(false);
           }
           else if ( guess > Answer)
           {
               winLabel.setText("너무 큰 숫자입니다");
               winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               winLabel.setForeground(Color.blue);
               count ++;
               scoreButton.setEnabled(false);
           }
           
           if (count > 30) score = 10;
           if (count < 20 && count > 10) score = 20;
           if (count < 10 && count > 5) score = 30;
           if (count < 5 && count > 1) score = 40;
           if (count == 1) score = 50;
           
           JOptionPane.showMessageDialog(null, count, "시도 횟수", JOptionPane.INFORMATION_MESSAGE);

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
           number frame = new number();
       } 
}