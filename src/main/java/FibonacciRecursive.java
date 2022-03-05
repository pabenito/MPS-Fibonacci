import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;

public class FibonacciRecursive implements Fibonacci{

    public FibonacciRecursive(){}

    @Override
    public BigInteger compute(int n) throws InvalidAlgorithmParameterException {
        checkNotNegative(n);

        BigInteger result;

        if(n == 0){
            result = BigInteger.ZERO;
        }else if(n == 1){
            result = BigInteger.ONE;
        }else {
            result = compute(n - 1).add(compute(n-2));
        }

        return result;
    }
}
