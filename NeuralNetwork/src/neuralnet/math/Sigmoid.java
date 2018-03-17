package neuralnet.math;

/**
 * A sigmoid activation function
 * @author Davin Holmberg
 */
public class Sigmoid implements IActivationFunction{

    private double a; 
    
    public Sigmoid(double a) {
        this.a = a;
    }

    @Override
    public double calc(double outputBeforeActivation) {
        return 1 / (1 + Math.pow(Math.E, (-a*outputBeforeActivation)));
    }
}
