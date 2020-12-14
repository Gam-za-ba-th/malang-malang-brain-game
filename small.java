package small;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class small extends JFrame{
    int c=0;
    int score;
    
    JButton b;
    
    static long beforeTime = System.currentTimeMillis();
    JLabel[] la=new JLabel[20];
    small(){
        this.setTitle("작은 숫자 빠르게 클릭하기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        	count++;
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