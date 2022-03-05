import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;

public class FibonacciIterative implements Fibonacci{

    @Override
    public BigInteger compute(int n) throws InvalidAlgorithmParameterException {
        checkNotNegative(n);

        BigInteger result;

        if(n == 0){
            result = BigInteger.ZERO;
        }else if(n == 1){
            result = BigInteger.ONE;
        }else {
            int current = 2;
            BigInteger less2Fibonacci = BigInteger.ZERO, less1Fibonacci = BigInteger.ONE, currentFibonacci = less2Fibonacci.add(less1Fibonacci);

            while (current < n){
                less2Fibonacci = less1Fibonacci;
                less1Fibonacci = currentFibonacci;
                currentFibonacci = less2Fibonacci.add(less1Fibonacci);
                current++;
            }
            result = currentFibonacci;
        }

        return result;
    }
}
