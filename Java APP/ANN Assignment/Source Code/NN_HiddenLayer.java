package numberrecognitionnn;

public class NN_HiddenLayer extends BackProp {

    public NN_HiddenLayer(int Max_Input, int Max_Hidden) {
        this.Max_Input = Max_Input;
        this.Max_Hidden = Max_Hidden;

        Neuron.set_Arcs(Max_Input);
        hidden_Layer = new Neuron[Max_Hidden];
        for (int x = 0; x < Max_Hidden; x++) {
            hidden_Layer[x] = new Neuron();
        }
    }

    protected void Initialize() {
        double rand;
        int i;
        for (int x = 0; x < Max_Hidden; x++) {
            for (int y = 0; y < Max_Input; y++) {
                rand = (-1 + Math.random() * 2.0);
                i = (int) (rand * 100);
                rand = (i / 100.0);
                hidden_Layer[x].set_weights(y, rand);
            }
        }
    }

    protected void Sigmoid_Function(NN_InputLayer InputLayer) {

        for (int x = 0; x < Max_Hidden; x++) {
            double sum = 0;
            for (int y = 0; y < Max_Input; y++) {
                sum = (sum + (hidden_Layer[x].get_weights(y) * InputLayer.input_Layer[y].get_NeuronOutput()));
            }
            hidden_Layer[x].set_NeuronOutput(Sigmoid(sum));
            
        }
    }

    private double Sigmoid(double sum) {
        double NueronOutput = (1 / (1 + Math.exp(-sum)));
        return NueronOutput;
    }

    protected void Run_BackProp_Error(Neuron[] output_Layer, int Max_Output) {
        hidden_Layer = HiddenLayer_Error(hidden_Layer, output_Layer, Max_Hidden, Max_Output);
    }

    protected void Run_BackProp_Weights(Neuron[] input_Layer) {
        hidden_Layer = Update_HiddenWeights(input_Layer, hidden_Layer, Max_Input, Max_Hidden);
    }
    private int Max_Hidden,  Max_Input;
    protected Neuron[] hidden_Layer;
}
