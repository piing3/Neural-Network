package neuralnet;

import neuralnet.math.IActivationFunction;
import neuralnet.math.Linear;
import neuralnet.math.RandomNumberGenerator;
import neuralnet.math.Sigmoid;

/**
 * Project main
 * @author Davin Holmberg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomNumberGenerator.seed = 0;
        
        int numberOfInputs = 2;
        int numberOfOutputs = 1;
        int[] numberOfHiddenNeurons = { 3 };
        IActivationFunction[] hiddenAcFnc = { new Sigmoid(1.0) };
        Linear outputAcFcn = new Linear(1.0);
        System.out.println("Creating Neural Network...");
        NeuralNet nn = new NeuralNet(numberOfInputs,numberOfOutputs,
                numberOfHiddenNeurons,hiddenAcFnc,outputAcFnc);
        System.out.println("Neural Network created!");
        nn.print();
        
        double [] neuralInput = { 1.5 , 0.5 };
        double [] neuralOutput;
        System.out.println("Feeding the values [" 
                + String.valueOf(neuralInput[0]) + " ; " 
                + String.valueOf(neuralInput[1]) 
                + "] to the neural network");
        nn.setInputs(neuralInput);
        nn.calc();
        neuralOutput = nn.getOutputs();

        neuralInput[0] = 1.0;
        neuralInput[1] = 2.1;
        nn.setInputs(neuralInput);
        nn.calc();
        neuralOutput = nn.getOutputs();
    }

}
