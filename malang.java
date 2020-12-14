package malang;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class malang extends JFrame implements ActionListener 
{
	JFrame malangFrame;
	
	JPanel malangPanel;
	
	JButton animalButton, numberButton, smallButton;
	
	public malang()
	{
		malangFrame = new JFrame();
		malangFrame.setTitle("malang game");
		
		malangFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		malangPanel = new JPanel();
		malangPanel.setLayout(new GridLayout(0,3,5,5));
		
		malangFrame.getContentPane().add(malangPanel, BorderLayout.CENTER);

        displayWidgets();

        malangFrame.setSize(700, 700);
        malangFrame.setVisible(true); 
	}
	
	public void displayWidgets() 
    {  
		animalButton = new JButton("동물 다리 맞추기 게임");
		malangPanel.add(animalButton);
		
		animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new animal();
            }
            
        });
		
		numberButton = new JButton("UP & DOWN 게임");
		malangPanel.add(numberButton);
		
		numberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new number();
            }
            
        });
	
		smallButton = new JButton("작은 순서대로 클릭 게임");
		malangPanel.add(smallButton);
		
		smallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new small();
            }
            
        });
		
	}
	
	public static void main(String[] args)
	{
		malang frame = new malang();
	}
}

class number implements ActionListener 
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

           scoreButton = new JButton("점수를 확인하세요", scoreicon);
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

class animal implements ActionListener{
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

class small extends JFrame{
    int c=0;
    int score;
    
    JButton b;
    
    static long beforeTime = System.currentTimeMillis();
    JLabel[] la=new JLabel[20];
    small(){
        this.setTitle("작은 숫자 빠르게 클릭하기");

        this.setLayout(null);
        for(int i=0; i<20; i++){
            la[i]= new JLabel("");
            la[i].setText(""+i);
            la[i].setSize(30,30);
            la[i].setFont(new Font ("", Font.BOLD, 20));
            int x=(int)(Math.random()*450);
            int y=(int)(Math.random()*450);
            la[i].setLocation(x,y);
            
            la[i].addMouseListener(new MyMouseListener());
            this.add(la[i]);
        }
        this.setSize(500, 500);
        this.setVisible(true);

        }
    class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        	
        	long afterTime = 0;
        	JLabel a =(JLabel)e.getSource();
            if(la[c]==a){
                la[c].setText("");
                a.setText("");
                c++;
            }
            
            if (c > 19) {
            	afterTime = System.currentTimeMillis();
            	JOptionPane.showMessageDialog(null, "성공하셨습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
            	
            }
            
            long secDiffTime = (afterTime - beforeTime) / 1000;
            if (c > 19)
            {         
            
            	if (secDiffTime > 50) score = 10;
            	if (secDiffTime < 50 && secDiffTime > 40) score = 20;
            	if (secDiffTime < 40 && secDiffTime > 30) score = 30;
            	if (secDiffTime < 30 && secDiffTime > 20) score = 40;
            	if (secDiffTime < 20) score = 50;

            	JOptionPane.showMessageDialog(null, secDiffTime, "걸린 시간", JOptionPane.INFORMATION_MESSAGE);
            	JOptionPane.showMessageDialog(null, score, "점수", JOptionPane.INFORMATION_MESSAGE);

            }
            
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static void main(String[] args) {
        new small();
    }
}