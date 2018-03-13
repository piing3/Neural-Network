package neuralnet;

/**
 * An exception class for the neural network
 * @author Davin Holmberg
 */
public class NeuralException extends Exception {

    /**
     * Creates a new instance of <code>NeuralException</code> without detail
     * message.
     */
    public NeuralException() {
    }

    /**
     * Constructs an instance of <code>NeuralException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NeuralException(String msg) {
        super(msg);
    }
}
