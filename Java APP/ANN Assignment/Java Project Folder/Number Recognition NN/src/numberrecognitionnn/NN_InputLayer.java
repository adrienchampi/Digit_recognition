package numberrecognitionnn;

public class NN_InputLayer extends BackProp{

    public NN_InputLayer(int Max_Input) {
        this.Max_Input = Max_Input;

        Neuron.set_Arcs(Max_Input);
        input_Layer = new Neuron[Max_Input];
        for (int x = 0; x < Max_Input; x++){
            input_Layer[x] = new Neuron();
        }
    }

    protected void Set_Neurons(double[] Vector) {
        for (int x = 0; x < Max_Input; x++) {
                input_Layer[x].set_NeuronOutput(Vector[x]);      
        }
    }


    private  int Max_Input;
    protected  Neuron[] input_Layer = null;
}
