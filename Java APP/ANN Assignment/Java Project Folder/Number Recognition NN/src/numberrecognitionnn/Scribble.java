package numberrecognitionnn;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;


//            UII, PictConver
public class Scribble extends JPanel {

    public static Scribble getInstance() {
        if (instance == null) {
            instance = new Scribble();
        }
        return instance;
    }

    private Scribble() {


        setPreferredSize(new Dimension(182, 182));


        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int modifiers = e.getModifiers();
                if ((modifiers & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem item = new JMenuItem("Load Deafult Number");
                    item.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            clear();


                            int rand = (int) (0 + Math.random() * 10);
                            InputStream textfile = null;

                            try {
                                load = true;
                                ImageIcon img = new ImageIcon(getClass().getResource("/Num_" + rand + ".png"));
                                scribblepane = bi.createGraphics();
                                scribblepane.drawImage(img.getImage(), 0, 0, null);
                                repaint();


                                PictConver pictConver = PictConver.getInstance();
                                textfile = (getClass().getResourceAsStream("/Num_" + rand + ".txt"));
                                Scanner input_file = new Scanner(textfile);

                                pictConver.Max_X = input_file.nextInt();
                                pictConver.Max_Y = input_file.nextInt();
                                pictConver.Min_X = input_file.nextInt();
                                pictConver.Min_Y = input_file.nextInt();

                                textfile.close();

                            } catch (Exception exp) {
                                System.out.println("Failed");
                            }
                        }
                    });

                    menu.add(item);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                } else {
                    moveto(e.getX(), e.getY());

                    requestFocus();
                }

            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                lineto(e.getX(), e.getY());
                PictConver pictConver = PictConver.getInstance();
                pictConver.Max_Min(e.getX(), e.getY());
            }
        });
    }

    private void moveto(int x, int y) {
        last_x = x;
        last_y = y;
    }

    private void lineto(int x, int y) {
        scribblepane.setColor(Color.black);
        scribblepane.drawLine(last_x, last_y, x, y);

        Graphics g = getGraphics();
        g.setColor(Color.black);
        g.drawLine(last_x, last_y, x, y);

        moveto(x, y);
    }

    protected void clear() {
        load = false;
        bi = new BufferedImage(182, 182, BufferedImage.TYPE_INT_ARGB);
        scribblepane = bi.createGraphics();
        UII.resetPix();
        PictConver pictConver = PictConver.getInstance();
        pictConver.clearpix();
        repaint();        
    }

    protected void saveimg() {
        BuffImg = bi;
    }

    public void paintComponent(Graphics g) {
        if (load == true){
       Graphics2D g2d = (Graphics2D) g;        
        g2d.setBackground(Color.WHITE);
        bi = EditImg.setTransparency(bi);
        g2d.drawImage(bi, null, 0, 0);    
        }
        else{
            super.paintComponent(g);
        }
    }
    
    
    
    protected BufferedImage bi = new BufferedImage(182, 182, BufferedImage.TYPE_INT_ARGB);
    protected static BufferedImage BuffImg = null;
    protected Graphics2D scribblepane = bi.createGraphics();
    private static Scribble instance = null;
    protected int last_x;
    protected int last_y;
    private boolean load = false;
}
