import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public interface FibonacciTest<T extends Fibonacci> {
    T getFibonacci();

    @ParameterizedTest
    @MethodSource("arguments")
    default void compute(int number, BigInteger expected) {
        assertEquals(expected, getFibonacci().compute(number));
    }

    static Stream<Arguments> arguments(){
        return Stream.of(
            Arguments.of(0, BigInteger.ZERO),
            Arguments.of(1, BigInteger.ONE),
            Arguments.of(2, BigInteger.ONE),
            Arguments.of(10, BigInteger.valueOf(55)),
            Arguments.of(50, BigInteger.valueOf(12586269025L)),
            Arguments.of(75, BigInteger.valueOf(2111485077978100L))
        );
    }
}