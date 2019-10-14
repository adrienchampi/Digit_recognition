package numberrecognitionnn;

public class BackProp {

    protected Neuron[] OutputLayer_Error(double[] expected_output, Neuron[] output_Layer, int Max_Output) {

        for (int x = 0; x < Max_Output; x++) {
            output_Layer[x].set_mule((expected_output[x] - output_Layer[x].get_NeuronOutput()) * output_Layer[x].get_NeuronOutput() * (1 - output_Layer[x].get_NeuronOutput()));
        }
        
        return output_Layer;
    }

    protected Neuron[] HiddenLayer_Error(Neuron[] hidden_Layer, Neuron[] output_Layer, int Max_Hidden, int Max_Output) {

        for (int x = 0; x < Max_Hidden; x++) {
            double Sum = 0;
            for (int y = 0; y < Max_Output; y++) {
                Sum = (Sum + (output_Layer[y].get_mule() * output_Layer[y].get_weights(x)));
            }
            hidden_Layer[x].set_mule(hidden_Layer[x].get_NeuronOutput() * (1 - hidden_Layer[x].get_NeuronOutput()) * Sum);
        }
        return hidden_Layer;
    }

    protected Neuron[] Update_OutputWeights(Neuron[] hidden_Layer, Neuron[] output_Layer, int Max_Hidden, int Max_Output) {

        final double Learning_Rate = 0.4;

        for (int x = 0; x < Max_Output; x++) {
            for (int y = 0; y < Max_Hidden; y++) {
                output_Layer[x].set_weights(y, output_Layer[x].get_weights(y) + (Learning_Rate * output_Layer[x].get_mule() * hidden_Layer[y].get_NeuronOutput()));
            }
        }
      return output_Layer;
    }

    protected Neuron[] Update_HiddenWeights(Neuron[] input_Layer, Neuron[] hidden_Layer, int Max_Input, int Max_Hidden) {

        final double Learning_Rate = 0.4;

        for (int x = 0; x < Max_Hidden; x++) {
            for (int y = 0; y < Max_Input; y++) {
                hidden_Layer[x].set_weights(y, hidden_Layer[x].get_weights(y) + (Learning_Rate * hidden_Layer[x].get_mule() * input_Layer[y].get_NeuronOutput()));
            }
        }
        return hidden_Layer;
    }
}
