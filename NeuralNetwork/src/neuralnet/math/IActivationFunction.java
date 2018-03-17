package neuralnet.math;

/**
 * Interface for all activation functions
 * @author Davin Holmberg
 */
public interface IActivationFunction {

    public double calc(double outputBeforeActivation);

}
