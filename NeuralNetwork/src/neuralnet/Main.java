package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;
import neuralnet.math.Linear;
import neuralnet.math.RandomNumberGenerator;
import neuralnet.math.Sigmoid;
import neuralnet.math.Step;

/**
 * Project main
 * @author Davin Holmberg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomNumberGenerator.setSeed(1);
        
        int numberOfInputs = 4;
        double[] inputs = {2.0, 1.5, 1.0, 0.5};
        int numberOfOutputs = 1;
        int[] numberOfHiddenNeurons = {3, 2};
        
        IActivationFunction[] hiddenAcFnc = { new Step(1.0), new Sigmoid(1.0)};
        Linear outputAcFcn = new Linear(1.0);

        System.out.println("Creating Neural Network...");
        NeuralNet nn = new NeuralNet(numberOfInputs, numberOfOutputs, numberOfHiddenNeurons, hiddenAcFnc, outputAcFcn);
        System.out.println("Neural Network created!");
        
        ArrayList<Double> neuralInput = new ArrayList<>();
        
        System.out.print("Feeding the values ["); 
        for (int i = 0; i < inputs.length-1; i++) {
            System.out.print(inputs[i] + " , ");
            neuralInput.add(inputs[i]);
        }
        System.out.println(inputs[inputs.length-1] + "] to the neural network"); 
        nn.setInputs(neuralInput);
        nn.print();
        System.out.println("Successful feeding!");
        
        System.out.println("Running neural network calculations...");
        nn.calc();
        ArrayList<Double> neuralOutput = nn.getOutputs();
        System.out.println("Output: " + neuralOutput);
        System.out.println("Successful operations!");
        System.out.println("Terminating Neural Network");
    }
}
