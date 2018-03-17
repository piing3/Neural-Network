package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;
import neuralnet.math.RandomNumberGenerator;

/**
 * The artificial neuron
 * @author Davin Holmberg
 */
public class Neuron {
    protected ArrayList<Double> weights;
    private ArrayList<Double> inputs;
    private double output;
    private double outputBeforeActivation;
    private int numberOfInputs = 0;
    protected double bias = 1.0;
    private IActivationFunction activationFunction;

    public Neuron(int numberOfInputs, IActivationFunction iaf) {
        this.numberOfInputs = numberOfInputs;
        this.weights = new ArrayList<>(numberOfInputs+1);
        this.inputs = new ArrayList<>(numberOfInputs);
        this.activationFunction = iaf;        
    }
    
    public void init() {
        for (int i = 0; i <= numberOfInputs; i++) {
            double newWeight = RandomNumberGenerator.generateNext();
            try {
                weights.set(i, newWeight);
            } catch (IndexOutOfBoundsException iobe) {
                weights.add(newWeight);
            }
        }
    }
    
    public void calc() {
        outputBeforeActivation = 0.0;
        if (numberOfInputs > 0) {
            if (inputs != null && weights != null) {
                for (int i = 0; i <= numberOfInputs; i++) {
                    outputBeforeActivation += (i == numberOfInputs? bias : inputs.get(i))*weights.get(i);
                }
            }    
        }
        output = activationFunction.calc(outputBeforeActivation);
    }    

    public void setActivationFunction(IActivationFunction activationFnc) {
        this.activationFunction = activationFnc;
    }

    public void setInputs(ArrayList<Double> inputs) {
        this.inputs = inputs;
    }

    public double getOutput() {
        return output;
    }

}
