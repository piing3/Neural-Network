package neuralnet;

import java.util.ArrayList;

/**
 * The neural input layer
 * @author Davin Holmberg
 */
public class InputLayer extends NeuralLayer{

    public InputLayer(int numberOfInputs) {
        super(numberOfInputs);
    }

    @Override
    protected void calc() {
    for (int i = 0; i < numberOfInputs; i++) {
            try {
                outputs.set(i, inputs.get(i));
            } catch (IndexOutOfBoundsException iobe) {
                outputs.add(inputs.get(i));
            }
        }
    }
}
