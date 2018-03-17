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
 
    public NeuralNet(int numberOfInputs,int numberOfOutputs,
            int[] numberOfHiddenNeurons, IActivationFunction[] hiddenAcFnc, 
            IActivationFunction outputAcFnc){
        
        this.numberOfInputs = numberOfInputs;
        this.numberOfHiddenLayers = numberOfHiddenNeurons.length;
        this.numberOfOutputs = numberOfOutputs;
        
        this.inputs = new ArrayList<>(numberOfInputs);
        this.inputLayer = new InputLayer(numberOfInputs);
        
        this.hiddenLayers = new ArrayList<>(0);
        this.hiddenLayers.add(new HiddenLayer(numberOfHiddenNeurons[0], 
                hiddenAcFnc[0], inputLayer.getNumberOfNeuronsInLayer()));       
        for (int i = 1; i < numberOfHiddenLayers-1; i++) {
            this.hiddenLayers.add(new HiddenLayer(numberOfHiddenNeurons[i], 
                hiddenAcFnc[i], inputLayer.getNumberOfNeuronsInLayer()));
            hiddenLayers.get(i-1).setNextLayer(hiddenLayers.get(i));
        }
        
        if(this.numberOfHiddenLayers > 0){
            outputLayer = new OutputLayer(numberOfOutputs, outputAcFnc, 
                    hiddenLayers.get(numberOfHiddenLayers-1).getNumberOfNeuronsInLayer());
            hiddenLayers.get(numberOfHiddenLayers-1).setNextLayer(outputLayer);
            inputLayer.setNextLayer(hiddenLayers.get(0));
        }
        else{
            outputLayer = new OutputLayer(numberOfInputs, outputAcFnc, numberOfOutputs);
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
        System.out.println("Neural Network:" + this.toString());
        System.out.println("    Inputs:" + numberOfInputs);
        System.out.println("    Outputs:" + numberOfOutputs);
        System.out.println("    Hidden Layers:" + numberOfHiddenLayers);
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            System.out.println("        Hidden Layer" + i + ": "
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
