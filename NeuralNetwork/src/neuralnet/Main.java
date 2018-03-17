package neuralnet;

import java.util.ArrayList;
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
        RandomNumberGenerator.setSeed(0);
        
        int numberOfInputs = 2;
        int numberOfOutputs = 1;
        int[] numberOfHiddenNeurons = { 3 };
        IActivationFunction[] hiddenAcFnc = { new Sigmoid(1.0) };
        Linear outputAcFcn = new Linear(1.0);
        System.out.println("Creating Neural Network...");
        NeuralNet nn = new NeuralNet(numberOfInputs,numberOfOutputs,
                numberOfHiddenNeurons,hiddenAcFnc,outputAcFcn);
        System.out.println("Neural Network created!");
        nn.print();
        
        ArrayList<Double> neuralInput = new ArrayList<>(2);
        neuralInput.set(0, 1.5);
        neuralInput.set(1, 0.5);
        ArrayList<Double> neuralOutput = new ArrayList<>();
        System.out.println("Feeding the values [" 
                + String.valueOf(neuralInput.get(0)) + " ; " 
                + String.valueOf(neuralInput.get(1)) 
                + "] to the neural network");
        nn.setInputs(neuralInput);
        nn.calc();
        neuralOutput = nn.getOutputs();
    }
}
