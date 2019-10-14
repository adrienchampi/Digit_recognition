package numberrecognitionnn;

import java.awt.Color;
import java.awt.Graphics;


public class NewLabel extends javax.swing.JLabel {

    public NewLabel() {
       
    }

    protected void paintComponent(Graphics g) {
        int x = (540 / UII.epochs);
        
        super.paintComponent(g); 
        super.setSize((UII.epochs*x)+ 90, 530);
        
        g.setColor(Color.BLACK);
        g.drawLine(x+30,470,x+30,15); //draw y axis
        g.drawLine(x+30,470,UII.epochs*x+70,470); //draw x axis
        g.drawLine(x+30,15,x+25,30); //draw arrow
        g.drawLine(x+30,15,x+35,30); //draw arrow
        g.drawLine(UII.epochs*x+70,470,UII.epochs*x+55,465); //draw arrow
        g.drawLine(UII.epochs*x+70,470,UII.epochs*x+55,475); //draw arrow
        g.drawString("0", 33, 490 );
        g.drawString("Good Facts vs Epochs", (((UII.epochs*x)+90)/2)-40, 20);
        
         for (int i = 1; i < UII.epochs -1; i++) {
            int tmpx,tmpy;
            g.setColor(Color.RED);
            g.drawLine(i*x+30, (-(UII.coords[i] -100)*4) +70, (i + 1)*x+30,(-(UII.coords[i + 1] -100)*4)+70); //draw graph
           
            
            if ((i % 10 == 0) && (UII.epochs < 100)){                          //draw numbers multiple of tens
                g.setColor(Color.BLACK);
                String Out = String.valueOf(i);
                g.drawString(Out, i*x+30, 490 );
                tmpx =  i*x+30;
                g.setColor(Color.BLUE);
                g.drawLine(i*x+30,470,i*x+30,(-(UII.coords[i] -100)*4) +70);
                g.drawLine(i*x+30,(-(UII.coords[i] -100)*4) +70,38, (-(UII.coords[i] -100)*4) +70);
                Out = String.valueOf(UII.coords[i]);
                g.setColor(Color.BLACK);
                g.drawString(Out,19, (-(UII.coords[i] -100)*4) +72);
                tmpy = (-(UII.coords[i] -100)*3) +80;                
            }

               if ((i % 20 == 0) && (UII.epochs >= 100)){                          //draw numbers multiple of tens
                g.setColor(Color.BLACK);
                String Out = String.valueOf(i);
                g.drawString(Out, i*x+30, 490 );
                tmpx =  i*x+30;
                g.setColor(Color.BLUE);
                g.drawLine(i*x+30,470,i*x+30,(-(UII.coords[i] -100)*4) +70);
                g.drawLine(i*x+30,(-(UII.coords[i] -100)*4) +70,38, (-(UII.coords[i] -100)*4) +70);
                Out = String.valueOf(UII.coords[i]);
                g.setColor(Color.BLACK);
                g.drawString(Out,19, (-(UII.coords[i] -100)*4) +72);
                tmpy = (-(UII.coords[i] -100)*3) +80;                
            }
            
            if (i == UII.epochs-2){                //draw maximum epoch
                g.setColor(Color.BLACK);
                String Out = String.valueOf(i+1);
                g.drawString(Out, (i+1)*x+35, 490 );
                g.setColor(Color.BLUE);
                g.drawLine((i+1)*x+30,470,(i+1)*x+30,(-(UII.coords[i+1] -100)*4) +70);
                g.drawLine((i+1)*x+30,(-(UII.coords[i+1] -100)*4) +70,38, (-(UII.coords[i+1] -100)*4) +70);
                Out = String.valueOf(UII.coords[i+1]);
                g.setColor(Color.BLACK);
                g.drawString(Out,13, (-(UII.coords[i+1] -100)*4) +67);
            }
        } 

    }
    
    
}

