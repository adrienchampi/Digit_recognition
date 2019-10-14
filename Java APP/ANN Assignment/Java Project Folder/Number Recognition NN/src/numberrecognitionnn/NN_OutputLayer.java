package numberrecognitionnn;

public class NN_OutputLayer extends BackProp {

    public NN_OutputLayer(int Max_Hidden,int Max_Output) {
        this.Max_Hidden = Max_Hidden;
        this.Max_Output = Max_Output;

        Neuron.set_Arcs(Max_Hidden);
        output_Layer = new Neuron[Max_Output];
        for (int x = 0; x < Max_Output; x++) {
            output_Layer[x] = new Neuron();
        }
    }

    protected void Initialize() {
        double rand; int i;
        for (int x = 0; x < Max_Output; x++) {
            for (int y = 0; y < Max_Hidden; y++) {
                rand = (-1 + Math.random() * 2.0);
                i = (int) (rand * 100);
                rand = (i / 100.0);
                output_Layer[x].set_weights(y, rand);
            }
        }
    }


    protected void Sigmoid_Function(NN_HiddenLayer HiddenLayer) {

        for (int x = 0; x < Max_Output; x++) {
            double sum = 0;
            for (int y = 0; y < Max_Hidden; y++) {
                sum = (sum + (output_Layer[x].get_weights(y) * HiddenLayer.hidden_Layer[y].get_NeuronOutput()));
            }
            output_Layer[x].set_NeuronOutput(Sigmoid(sum));
        }
    }

    private double Sigmoid(double sum) {
        double NueronOutput = (1 / (1 + Math.exp(-sum)));
        return NueronOutput;
    }

    protected double[] get_Output() {
        double[] Output = new double[10];
        for (int x = 0; x < Max_Output; x++) {
            Output[x] = output_Layer[x].get_NeuronOutput();
        }
        return Output;
    }

    protected double get_MaxOut() {
        double[] vec = get_Output();
        double Max = 0;
        for (int i = 0; i < 10; i++) {
            if (vec[i] > Max) {
                Max = vec[i];
            }
        }
        return Max;
    }

    protected int[] get_Result() {
        double[] vec = get_Output();
        double Max = 0;
        int pos = 0;
        int[] Vector = new int[10];
        for (int i = 0; i < 10; i++) {
            Vector[i] = 0;
        }
        for (int i = 0; i < 10; i++) {
            if (vec[i] > Max) {
                Max = vec[i];
                pos = i;
            }
        }
        Vector[pos] = 1;
        return Vector;
    }

    protected void Run_BackProp_Error(double[] expected_output) {
        output_Layer = OutputLayer_Error(expected_output, output_Layer, Max_Output);
    }

    protected void Run_BackProp_Weights(Neuron[] hidden_Layer) {
        output_Layer = Update_OutputWeights(hidden_Layer, output_Layer, Max_Hidden, Max_Output);
    }
    private int Max_Hidden,  Max_Output;
    protected Neuron[] output_Layer;
}
