package numberrecognitionnn;

public class MachineOutput {

    public MachineOutput() {
    }

    public static void displayMachineOutput() {
        PictConver pictConver = PictConver.getInstance();

        int pix = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pictConver.getPix(x, y)) {                    
                    UII.setPix(pix);
                }
                pix++;
            }

        }

    }
}
