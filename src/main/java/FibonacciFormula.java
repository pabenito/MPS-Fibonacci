import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;

public class FibonacciFormula implements Fibonacci{
    public FibonacciFormula(){}

    @Override
    public BigInteger compute(int n) throws InvalidAlgorithmParameterException {
        checkNotNegative(n);
        BigDecimal one = BigDecimal.ONE;
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal sqrtOfFive = BigDecimal.valueOf(Math.sqrt(5));
        BigDecimal goldenRatio = one.add(sqrtOfFive).divide(two);
        BigDecimal goldenRatioConjugate = one.subtract(goldenRatio);
        return goldenRatio.pow(n).subtract(goldenRatioConjugate.pow(n)).divide(sqrtOfFive).toBigInteger();
    }
}
