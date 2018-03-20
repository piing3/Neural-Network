package neuralnet;

import java.util.ArrayList;
import neuralnet.math.IActivationFunction;

/**
 * The master class of the ANN
 * @author Davin
 */
public class NeuralNet {

    private InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayers;
    private OutputLayer outputLayer;
    private int numberOfHiddenLayers;
    private int numberOfInputs;
    private int numberOfOutputs;
    private ArrayList<Double> inputs;
    private ArrayList<Double> outputs;
 
    public NeuralNet(int numberOfInputs,int numberOfOutputs, int[] numberOfHiddenNeurons, IActivationFunction[] hiddenAcFnc, IActivationFunction outputAcFnc){
        
        this.numberOfInputs = numberOfInputs;
        this.numberOfHiddenLayers = numberOfHiddenNeurons.length;
        this.numberOfOutputs = numberOfOutputs;
        
        this.inputs = new ArrayList<>(numberOfInputs);
        this.inputLayer = new InputLayer(numberOfInputs);
        
        hiddenLayers = new ArrayList<>();
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            if (i == 0){
                hiddenLayers.add(new HiddenLayer(numberOfHiddenNeurons[i], hiddenAcFnc[i], inputLayer.getNumberOfInputs()));
                hiddenLayers.get(i).setPreviousLayer(inputLayer);
            }
            else {
                hiddenLayers.add(new HiddenLayer(numberOfHiddenNeurons[i], hiddenAcFnc[i], hiddenLayers.get(i-1).getNumberOfNeuronsInLayer()));
                hiddenLayers.get(i-1).setNextLayer(hiddenLayers.get(i));
                hiddenLayers.get(i).setPreviousLayer(hiddenLayers.get(i-1)); 
            }
        }
        
        if(this.numberOfHiddenLayers > 0){
            outputLayer = new OutputLayer(numberOfOutputs, outputAcFnc, hiddenLayers.get(numberOfHiddenLayers-1).getNumberOfNeuronsInLayer());
            hiddenLayers.get(numberOfHiddenLayers-1).setNextLayer(outputLayer);
            outputLayer.setPreviousLayer(hiddenLayers.get(numberOfHiddenLayers-1));
            inputLayer.setNextLayer(hiddenLayers.get(0));
        }
        else{
            outputLayer = new OutputLayer(numberOfInputs, outputAcFnc, numberOfOutputs);
            outputLayer.setPreviousLayer(inputLayer);
            inputLayer.setNextLayer(outputLayer);
        }
    }
    
    public void calc(){
        inputLayer.setInputs(inputs);
        inputLayer.calc();
        
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            HiddenLayer hl = hiddenLayers.get(i);
            hl.setInputs(hl.getPreviousLayer().getOutputs());
            hl.calc();
        }
        
        outputLayer.setInputs(outputLayer.getPreviousLayer().getOutputs());
        outputLayer.calc();
        outputs = outputLayer.getOutputs();
    }

    public void print() {
        System.out.println("Neural Network: " + this.toString());
        System.out.println("    Inputs: " + numberOfInputs);
        System.out.println("    Outputs: " + numberOfOutputs);
        System.out.println("    Hidden Layers: " + numberOfHiddenLayers);
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            System.out.println("        Hidden Layer " + i + ": "
                    + hiddenLayers.get(i).getNumberOfNeuronsInLayer() 
                    + " Neurons");
        }
    }

    public void setInputs(ArrayList<Double> inputs) {
        this.inputs = inputs;
    }    

    public ArrayList<Double> getOutputs() {
        return outputs;
    }

   
}
