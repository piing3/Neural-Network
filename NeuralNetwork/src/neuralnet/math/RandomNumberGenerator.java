package neuralnet.math;

import java.util.Random;

/**
 * A random number generator
 * @author Davin Holmberg
 */
public class RandomNumberGenerator {

    private static final Random R = new Random();
    
    public static double generateNext() {
        return R.nextDouble();
    }
    
    public static void setSeed(long seed){
        R.setSeed(seed);
    }
}
