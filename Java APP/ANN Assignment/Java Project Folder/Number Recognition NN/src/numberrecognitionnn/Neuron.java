package numberrecognitionnn;

public class Neuron {

  private static int Arcs;
  private  double[] weights = new double[Arcs];
  private  double Neuron_Output;
  private  double Mule;

  public static void set_Arcs(int num){
    Arcs = num;
  }

  public int getArcs(){
   return Arcs;
  }

  protected void set_weights(int i, double weight){
    weights[i] = weight;
  }

   protected double get_weights(int i){
    return weights[i];
  }

  protected void set_mule(double Mule){
    this.Mule = Mule;
  }

   protected double get_mule(){
    return Mule;
  }

  protected void set_NeuronOutput(double Neuron_Output){
    this.Neuron_Output = Neuron_Output;
  }
  
  protected double get_NeuronOutput(){
    return Neuron_Output;
  }
}
