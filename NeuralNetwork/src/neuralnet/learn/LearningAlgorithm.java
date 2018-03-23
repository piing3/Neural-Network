package neuralnet.learn;

import neuralnet.NeuralException;
import neuralnet.NeuralNet;
import neuralnet.data.NeuralDataSet;

/**
 * 
 * @author Davin Holmberg
 */
public abstract class LearningAlgorithm {
    protected NeuralNet neuralNet;
    public enum LearningMode {ONLINE, BATCH}; 
    protected enum LearningParadigm {SUPERVISED, UNSUPERVISED};
    
    protected int maxEpochs = 100;
    protected int epoch = 0;
    protected double minOverallError = 0.001;
    protected double learningRate = 0.1;
    protected NeuralDataSet trainingDataSet;
    protected NeuralDataSet testingDataSet;
    protected NeuralDataSet validatingDataSet;
    public boolean printTraining = false;
    
    public abstract void train() throws NeuralException;
    public abstract void forward() throws NeuralException;
    public abstract void forward(int i) throws NeuralException;  
    public abstract double calcNewWeight(int layer, int input, int neuron) throws NeuralException;
    public abstract double calcNewWeight(int layer, int input, int neuron, double error) throws NeuralException;
    
    
}
