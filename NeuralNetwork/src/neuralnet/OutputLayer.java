package neuralnet;

import neuralnet.math.IActivationFunction;

/**
 * The neural output layer
 * @author Davin Holmberg
 */
public class OutputLayer extends NeuralLayer{

    public OutputLayer(int numberOfNeurons, IActivationFunction iaf, int numberOfInputs) {
        super(numberOfNeurons, numberOfInputs, iaf);
    }
}
