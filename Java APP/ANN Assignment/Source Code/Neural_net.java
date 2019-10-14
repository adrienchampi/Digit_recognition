package numberrecognitionnn;

public class Neural_net {

    public Neural_net() {
        InputLayer = new NN_InputLayer(Max_Input);
        HiddenLayer = new NN_HiddenLayer(Max_Input, Max_Hidden);
        OutputLayer = new NN_OutputLayer(Max_Hidden, Max_Output);
        Initialize();
    }

    private void Initialize() {
        HiddenLayer.Initialize();
        OutputLayer.Initialize();
    }

    protected void Run_NeuralNet(double[] Vector) {
        Sigmoid_Function(Vector);
    }

    private void Sigmoid_Function(double[] Vector) {
        InputLayer.Set_Neurons(Vector);
        HiddenLayer.Sigmoid_Function(InputLayer);
        OutputLayer.Sigmoid_Function(HiddenLayer);
    }

    protected boolean Run_Teaching(double[] Input_Vector, double[] Output_Vector) {
        boolean Error;

        Run_NeuralNet(Input_Vector);

        Error = CheckForErrors(Output_Vector);

        if (Error == true) {
            Run_BackProp(Output_Vector);
        }

        return Error;
    }

    private boolean CheckForErrors(double[] expected_output) {
        final double threshold = 0.2;
        int x = 0;
        boolean error = false;
        double[] Real_OutPut = OutputLayer.get_Output();
        double Error;

        while ((x < 10) && (error != true)) {
            if ((expected_output[x] - Real_OutPut[x]) < 0) {
                Error = (-(expected_output[x] - Real_OutPut[x]));
            } else {
                Error = (expected_output[x] - Real_OutPut[x]);
            }

            if (Error > threshold) {
                error = true;
            }
            x++;
        }
        return error;
    }

    protected int[] Get_Result() {
        return OutputLayer.get_Result();
    }

    protected double Get_Max() {
        return OutputLayer.get_MaxOut();
    }

    private void Run_BackProp(double[] output_vector) {
        OutputLayer.Run_BackProp_Error(output_vector);
        HiddenLayer.Run_BackProp_Error(OutputLayer.output_Layer, Max_Output);
        OutputLayer.Run_BackProp_Weights(HiddenLayer.hidden_Layer);
        HiddenLayer.Run_BackProp_Weights(InputLayer.input_Layer);
    }


    final int Max_Input = 64;
    final int Max_Hidden = 38;
    final int Max_Output = 10;
    private NN_InputLayer InputLayer;
    private NN_HiddenLayer HiddenLayer;
    private NN_OutputLayer OutputLayer;
}
