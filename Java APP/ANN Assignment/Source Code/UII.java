package numberrecognitionnn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import javax.swing.border.SoftBevelBorder;
import java.util.Scanner;

public class UII extends JPanel {

    public UII() {
        initComponents();
    }

    private void initComponents() {
        jPanel_buttons = new JPanel();
        jButton_teach = new JButton();
        jButton_Graph = new JButton();
        jPanel2 = new JPanel();
        jLabel_mOtpt = new JLabel();
        jLabel1 = new JLabel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel_Grid = new JPanel();
        jButton_Convert = new JButton();
        jButton_clear = new JButton();
        jButton_Recognize = new JButton();
        jlblGrid = new JLabel[64];
        neural_net = new Neural_net();
        BlackIcon = new ImageIcon(getClass().getResource("/blackdot.png"));
        WhiteIcon = new ImageIcon(getClass().getResource("/whitedot.png"));
        Hint = new JLabel("Click Right Mouse Button To Load Deafult Numbers");
        Hint.setForeground(Color.RED);

        setBackground(new Color(255, 255, 255));
        jPanel_buttons.setBackground(new Color(255, 255, 255));
        jButton_teach.setFont(new Font("Copperplate Gothic Bold", 1, 12));
        jButton_teach.setText("Teach Machine");
        jButton_teach.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jButton_teachActionPerformed(evt);
            }
        });
        jButton_Graph.setFont(new Font("Copperplate Gothic Bold", 1, 12));
        jButton_Graph.setText("Show Graph");
        jButton_Graph.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jButton_GraphActionPerformed(evt);
            }
        });
        GroupLayout jPanel_buttonsLayout = new GroupLayout(jPanel_buttons);
        jPanel_buttons.setLayout(jPanel_buttonsLayout);
        jPanel_buttonsLayout.setHorizontalGroup(jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_buttonsLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton_teach, -1, 165, 32767).addComponent(jButton_Graph, javax.swing.GroupLayout.Alignment.TRAILING, -1, 165, 32767)).addGap(23, 23, 23)));
        jPanel_buttonsLayout.setVerticalGroup(jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel_buttonsLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(jButton_teach).addGap(18, 18, 18).addComponent(jButton_Graph).addContainerGap(-1, 32767)));
        jPanel2.setBackground(new Color(255, 255, 255));
        jLabel_mOtpt.setFont(new Font("Tahoma", 1, 12));
        jLabel_mOtpt.setText("Machine Output");
        jLabel1.setFont(new Font("Tahoma",1,14));
        jLabel1.setText("");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(Hint).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel_mOtpt))                               
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel_mOtpt)
                .addComponent(jLabel1)).addGap(22, 22, 22)
                .addComponent(Hint)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))));
        jPanel4.setBackground(new Color(204, 204, 204));
        jPanel4.setBorder(BorderFactory.createTitledBorder(null, "User Input", 1, 0, new Font("Tahoma", 1, 11), new Color(0, 51, 255)));
        jPanel4.setForeground(new Color(204, 204, 204));
        Scribble scribble_pane = Scribble.getInstance();
        scribble_pane.setBackground(new Color(255, 255, 255));
        scribble_pane.setBorder(BorderFactory.createBevelBorder(0));
        GroupLayout jPanel1Layout = new GroupLayout(scribble_pane);
        scribble_pane.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 113, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 116, 32767));
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(scribble_pane, -2, -1, -2).addContainerGap(28, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(scribble_pane, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel5.setBackground(new Color(204, 204, 204));
        jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Machine Recognition", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 51, 255)));
        jPanel5.setForeground(new Color(204, 204, 204));
        jPanel_Grid.setBackground(new Color(255, 255, 255));
        jPanel_Grid.setBorder(BorderFactory.createBevelBorder(0));
        GroupLayout jPanel3Layout = new GroupLayout(jPanel_Grid);
        jPanel_Grid.setLayout(jPanel3Layout);
        jPanel_Grid.setSize(120, 120);
        jPanel_Grid.setLayout(new GridLayout(8, 1));
        for (int i = 0; i < 64; i++) {
            jPanel_Grid.add(jlblGrid[i] = new JLabel());
            jlblGrid[i].setSize(20, 20);
            jlblGrid[i].setBorder(new SoftBevelBorder(0));
            jlblGrid[i].setHorizontalAlignment(4);
            jlblGrid[i].setVerticalAlignment(1);
        }

        resetPix();
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 113, 32767));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 116, 32767));
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jPanel_Grid).addContainerGap(28, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jPanel_Grid).addContainerGap(-1, 32767)));
        jButton_Convert.setFont(new Font("Copperplate Gothic Bold", 1, 12));
        jButton_Convert.setText("Convert");
        jButton_Convert.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jButton_ConvertActionPerformed(evt);
            }
        });
        jButton_clear.setFont(new Font("Copperplate Gothic Bold", 1, 12));
        jButton_clear.setText("Clear");
        jButton_clear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });
        jButton_Recognize.setFont(new Font("Copperplate Gothic Bold", 1, 12));
        jButton_Recognize.setText("Recognize");
        jButton_Recognize.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jButton_RecognizeActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(43, 43, 43).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel4, -2, -1, -2).addComponent(jPanel_buttons, -2, -1, -2)).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addComponent(jButton_Convert, -2, 131, -2).addGap(55, 55, 55).addComponent(jPanel5, -2, -1, -2).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(221, 221, 221).addComponent(jPanel2, -1, -1, 32767).addGap(38, 38, 38)))).addGroup(layout.createSequentialGroup().addGap(93, 93, 93).addComponent(jButton_clear).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, 32767).addComponent(jButton_Recognize).addGap(95, 95, 95)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanel5, -1, -1, 32767).addComponent(jPanel4, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton_clear).addComponent(jButton_Recognize)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel_buttons, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2))).addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(jButton_Convert))).addContainerGap()));
    
    }

    private void jButton_teachActionPerformed(ActionEvent actionevent) {
        double[] input_vector = new double[64];
        double[] output_vector = new double[10];
        InputStream input = null;
        String input_v;
        String Output_v;
        int count = 0;
        boolean fact;

        while (count != 100) {
            count = 0;
            try {
                input = (getClass().getResourceAsStream("/cases.txt"));
                Scanner input_file = new Scanner(input);
                while ((input_file.hasNext() == true)) {

                    input_v = input_file.next();
                    Output_v = input_file.next();

                    for (int i = 0; i < 64; i++) {
                        input_vector[i] = Integer.parseInt(input_v.substring(i, i + 1));
                    }


                    for (int i = 0; i < 10; i++) {
                        output_vector[i] = Integer.parseInt(Output_v.substring(i, i + 1));
                    }
                    fact = neural_net.Run_Teaching(input_vector, output_vector);

                    if (fact == false) {
                        count++;
                    }
                }
                coords[epochs] = count;
                input.close();
                epochs++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void jButton_ConvertActionPerformed(ActionEvent evt) {
        Scribble scribble_pane = Scribble.getInstance();
        scribble_pane.saveimg();
        PictConver pictConver = PictConver.getInstance();
        pictConver.convertimg();
        MachineOutput.displayMachineOutput();
    }

    private void jButton_clearActionPerformed(ActionEvent evt) {
        Scribble scribble_pane = Scribble.getInstance();
        scribble_pane.clear();
        PictConver pictConver = PictConver.getInstance();
        pictConver.resetNums();

    }

    private void jButton_RecognizeActionPerformed(ActionEvent evt) {
        PictConver pictConver = PictConver.getInstance();
        neural_net.Run_NeuralNet(pictConver.get_Vector());
        int[] array_result = neural_net.Get_Result();
        String tmp = "";


        for (int i = 0; i < 10; i++) {
            Integer integer = new Integer(array_result[i]);
            tmp = tmp + integer.toString();
        }

        int result = Integer.parseInt(tmp);


        switch (result) {
            case 1: {
                jLabel1.setText("0");
                break;
            }
            case 10: {
                jLabel1.setText("1");
                break;
            }
            case 100: {
                jLabel1.setText("2");
                break;
            }
            case 1000: {
                jLabel1.setText("3");
                break;
            }
            case 10000: {
                jLabel1.setText("4");
                break;
            }
            case 100000: {
                jLabel1.setText("5");
                break;
            }
            case 1000000: {
                jLabel1.setText("6");
                break;
            }
            case 10000000: {
                jLabel1.setText("7");
                break;
            }
            case 100000000: {
                jLabel1.setText("8");
                break;
            }
            case 1000000000: {
                jLabel1.setText("9");
                break;
            }
        }

    }
    

    private void jButton_GraphActionPerformed(ActionEvent evt) {
        JFrame frame = new JFrame();
        GraphUI user_int = new GraphUI(frame);
        frame.getContentPane().add(user_int);
        int x = (540 / epochs);
        
        frame.setSize((epochs*x)+ 130, 320*2);     
        frame.setVisible(true);
    }

    public static void setPix(int pix) {
        jlblGrid[pix].setIcon(BlackIcon);
    }

    public static void resetPix() {
        for (int pix = 0; pix < 64; pix++) {
            jlblGrid[pix].setIcon(WhiteIcon);
        }
    }
    
    
    public static ImageIcon BlackIcon, WhiteIcon;
    protected static int epochs = 1;
    protected static int[] coords = new int[1000];
    private static JLabel jlblGrid[];
    private JButton jButton_Recognize;
    private JButton jButton_clear;
    private JButton jButton_teach;
    private JButton jButton_Convert;
    private JButton jButton_Graph;
    private JLabel jLabel1;
    private JLabel Hint;
    private JLabel jLabel_mOtpt;
    private JPanel jPanel2;
    private JPanel jPanel_Grid;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel_buttons;
    private Neural_net neural_net;
}
