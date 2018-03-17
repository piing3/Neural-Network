package neuralnet.math;

/**
 * A linear activation function
 * @author Davin Holmberg
 */
public class Linear implements IActivationFunction{

    private double a;
    
    public Linear(double a) {
        this.a = a;
    }

    @Override
    public double calc(double outputBeforeActivation) {
        return a * outputBeforeActivation;   
    }
}
