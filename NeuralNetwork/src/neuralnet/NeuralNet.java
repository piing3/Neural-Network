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
 
    public NeuralNet(int numberOfInputs,int numberOfOutputs,
            int[] numberOfHiddenNeurons, IActivationFunction[] hiddenAcFnc, 
            IActivationFunction outputAcFnc){
        
        this.numberOfInputs = numberOfInputs;
        this.numberOfHiddenLayers = numberOfHiddenNeurons.length;
        this.numberOfOutputs = numberOfOutputs;
        
        this.input = new ArrayList<>(numberOfInputs);
        this.inputLayer = new InputLayer(numberOfInputs);
        
        this.hiddenLayer.set(0, new HiddenLayer(numberOfHiddenNeurons[0], 
                hiddenAcFnc[0], inputLayer.getNumberOfNeuronsInLayer()));       
        for (int i = 1; i < numberOfHiddenLayers-1; i++) {
            this.hiddenLayer.set(i, new HiddenLayer(numberOfHiddenNeurons[i], 
                hiddenAcFnc[i], inputLayer.getNumberOfNeuronsInLayer()));
            hiddenLayer.get(i-1).setNextLayer(hiddenLayer.get(i));
        }
        
        if(this.numberOfHiddenLayers > 0){
            outputLayer = new OutputLayer(numberOfOutputs, outputAcFnc, 
                    hiddenLayer.get(numberOfHiddenLayers-1).getNumberOfNeuronsInLayer());
            hiddenLayer.get(numberOfHiddenLayers-1).setNextLayer(outputLayer);
            inputLayer.setNextLayer(hiddenLayer.get(0));
        }
        else{
            outputLayer = new OutputLayer(numberOfInputs, outputAcFnc, numberOfOutputs);
            inputLayer.setNextLayer(outputLayer);
        }
    }
    
    public void calc(){
        inputLayer.setInputs(input);
        inputLayer.calc();
        
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            HiddenLayer hl = hiddenLayer.get(i);
            hl.setInputs(hl.getPreviousLayer.getOutputs());
            hl.calc();
        }
        outputLayer.setInputs(hiddenLayer.getPreviousLayer.getOutputs());
        outputLayer.calc();
        output = outputLayer.getOutputs();
    }
    
    
    
}
