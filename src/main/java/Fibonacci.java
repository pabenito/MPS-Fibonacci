import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;

public interface Fibonacci {
    BigInteger compute(int n) throws InvalidAlgorithmParameterException;

    default void checkNotNegative(int number) throws InvalidAlgorithmParameterException {
        if(number < 0){
            throw new InvalidAlgorithmParameterException("Only fibonacci numbers of natural numbers can be computed.");
        }
    }
}
