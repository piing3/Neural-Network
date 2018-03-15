package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;

/**
 * The master class of the ANN
 * @author Davin
 */
public class NeuralNet {

    private InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayer;
    private OutputLayer outputLayer;
    private int numberOfHiddenLayers;
    private int numberOfInputs;
    private int numberOfOutputs;
    private ArrayList<Double> input;
    private ArrayList<Double> output;
 
    public NeuralNet(int numberofinputs,int numberofoutputs,
            int[] numberofhiddenneurons, IActivationFunction[] hiddenAcFnc, 
            IActivationFunction outputAcFnc){
        
        this.input = new ArrayList<>(numberOfInputs);
        this.inputLayer = new InputLayer(numberofinputs);
        
        this.hiddenLayer.set(0, new HiddenLayer(inputLayer.getNumberOfNeuronsInLayer(), numberofhiddenneurons[0], hiddenAcFnc[0]));
    }
    
}
