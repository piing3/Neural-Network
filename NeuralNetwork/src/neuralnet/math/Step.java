package neuralnet.math;

/**
 * A step activation function
 * @author Davin Holmberg
 */
public class Step implements IActivationFunction{

    private double a;
    
    public Step(double a) {
        this.a = a;
    }

    @Override
    public double calc(double outputBeforeActivation) {
        if (outputBeforeActivation < a){
            return 0;
        }
        else{
            return 1;
        }
    }

}
