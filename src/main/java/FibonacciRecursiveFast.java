import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

public class FibonacciRecursiveFast implements Fibonacci{

    public FibonacciRecursiveFast(){}

    @Override
    public BigInteger compute(int n) throws InvalidAlgorithmParameterException {
        checkNotNegative(n);
        List<BigInteger> fibonacciSequence = new ArrayList<>(n+1);
        compute(n, fibonacciSequence);
        return fibonacciSequence.get(n);
    }

    private void compute(int n, List<BigInteger> fibonacciSequence) {
        if(n == 0){
            fibonacciSequence.add(0, BigInteger.ZERO);
        }else if(n == 1){
            compute(0, fibonacciSequence);
            fibonacciSequence.add(1, BigInteger.ONE);
        }else {
            compute(n - 1, fibonacciSequence);
            BigInteger result = fibonacciSequence.get(n-1).add(fibonacciSequence.get(n-2));
            fibonacciSequence.add(n, result);
        }
    }
}
