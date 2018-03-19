package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;

/**
 * Abstract class that defines a layer of neurons
 * @author Davin Holmberg
 */
public abstract class NeuralLayer {
    protected int numberOfNeuronsInLayer;
    private ArrayList<Neuron> neurons;
    protected IActivationFunction activationFnc;
    protected NeuralLayer previousLayer;
    protected NeuralLayer nextLayer;
    protected ArrayList<Double> inputs;
    protected ArrayList<Double> outputs;
    protected int numberOfInputs;

    public NeuralLayer(int numberOfInputs) {
        this.numberOfInputs = numberOfInputs; 
        this.inputs = new ArrayList<>(numberOfInputs);
        this.outputs = new ArrayList<>(numberOfInputs);
    }

    public NeuralLayer(int numberOfNeurons, int numberOfInputs, IActivationFunction iaf) {
        this.numberOfInputs = numberOfInputs; 
        this.numberOfNeuronsInLayer = numberOfNeurons;
        this.inputs = new ArrayList<>(numberOfInputs);
        this.outputs = new ArrayList<>(numberOfNeurons);
        this.neurons = new ArrayList<>(numberOfNeuronsInLayer);
        this.activationFnc = iaf;
        init();
    }

    
    protected void init() {    
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            try {
                neurons.get(i).setActivationFunction(activationFnc);
                neurons.get(i).init();
            } catch (IndexOutOfBoundsException iobe) {
                neurons.add(new Neuron(numberOfInputs, activationFnc));
                neurons.get(i).init();
            }
        }
    }
    
    protected void calc(){
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            neurons.get(i).setInputs(inputs);
            neurons.get(i).calc();
            try {
                outputs.set(i, neurons.get(i).getOutput());
            } catch (IndexOutOfBoundsException iobe) {
                outputs.add(neurons.get(i).getOutput());
            }
        }
    }

    public int getNumberOfNeuronsInLayer() {
        return numberOfNeuronsInLayer;
    }

    public void setNextLayer(NeuralLayer nextLayer) {
        this.nextLayer = nextLayer;
    }

    public void setPreviousLayer(NeuralLayer previousLayer) {
        this.previousLayer = previousLayer;
    }
    
    public NeuralLayer getPreviousLayer() {
        return previousLayer;
    }
    
    public void setInputs(ArrayList<Double> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<Double> getOutputs() {
        return outputs;
    }
    
}