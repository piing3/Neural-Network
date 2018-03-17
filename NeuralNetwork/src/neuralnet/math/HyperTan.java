package neuralnet.math;

/**
 * A hyper tangent activation function
 * @author Davin Holmberg
 */
public class HyperTan implements IActivationFunction{

    private double a;

    public HyperTan(double a) {
        this.a = a;
    }

    @Override
    public double calc(double outputBeforeActivation) {
        return (1 - Math.pow(Math.E, (-a*outputBeforeActivation)))
                / (1 + Math.pow(Math.E, (-a*outputBeforeActivation))); 
    }
}
