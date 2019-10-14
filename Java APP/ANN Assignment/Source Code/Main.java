package numberrecognitionnn;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String args[]) {
        Main NN = new Main();
        NN.pack();
        NN.setVisible(true);
    }

    public Main() {
        super("Artificial Neural Network");
        UII user_int = new UII();
        getContentPane().add(user_int);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
