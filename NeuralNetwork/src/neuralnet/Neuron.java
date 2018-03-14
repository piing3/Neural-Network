package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;
import neuralnet.math.RandomNumberGenerator;

/**
 * The artificial neuron
 * @author Davin Holmberg
 */
public class Neuron {
    protected ArrayList<Double> weight;
    private ArrayList<Double> input;
    private double output;
    private double outputBeforeActivation;
    private int numberOfInputs = 0;
    protected double bias = 1.0;
    private IActivationFunction activationFunction;

    public Neuron(int numberOfInputs, IActivationFunction iaf) {
        this.numberOfInputs = numberOfInputs;
        this.weight = new ArrayList<>(numberOfInputs+1);
        this.input = new ArrayList<>(numberOfInputs);
        this.activationFunction = iaf;        
    }
    
    public void init() {
        for (int i = 0; i <= numberOfInputs; i++) {
            double newWeight = RandomNumberGenerator.generateNext();
            try {
                weight.set(i, newWeight);
            } catch (IndexOutOfBoundsException iobe) {
                weight.add(newWeight);
            }
        }
    }
    
    public void calc() {
        outputBeforeActivation = 0.0;
        if (numberOfInputs > 0) {
            if (input != null && weight != null) {
                for (int i = 0; i <= numberOfInputs; i++) {
                    outputBeforeActivation += (i == numberOfInputs? bias : input.get(i))*weight.get(i);
                }
            }    
        }
        output = activationFunction.calc(outputBeforeActivation);
    }    
}
