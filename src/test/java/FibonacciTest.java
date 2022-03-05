import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public interface FibonacciTest{

    // Exception test

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10, Integer.MIN_VALUE})
    @Order(1)
    default void throwExceptionWhenNegative(int negativeNumber){
        assertThrows(InvalidAlgorithmParameterException.class, () -> getFibonacci().compute(negativeNumber));
    }

    // Correct output test

    @ParameterizedTest
    @MethodSource("argumentsLow")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @Order(3)
    default void computeLow(int number, BigInteger expected) throws InvalidAlgorithmParameterException {
        assertEquals(expected, getFibonacci().compute(number));
    }

    @ParameterizedTest
    @MethodSource("argumentsMedium")
    @Timeout(value = 1, unit = TimeUnit.MINUTES)
    @Order(3)
    default void computeMedium(int number, BigInteger expected) throws InvalidAlgorithmParameterException {
        assertEquals(expected, getFibonacci().compute(number));
    }

    @ParameterizedTest
    @MethodSource("argumentsHigh")
    @Timeout(value = 10, unit = TimeUnit.MINUTES)
    @Order(4)
    default void computeHigh(int number, BigInteger expected) throws InvalidAlgorithmParameterException {
        assertEquals(expected, getFibonacci().compute(number));
    }

    // Time test

    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100, 150, 200})
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @Order(2)
    default void timeoutNotExceededOneMili(int n) {
        assertTimeout(ofMillis(1), () -> getFibonacci().compute(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100, 150, 200})
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @Order(2)
    default void timeoutNotExceededTenMilis(int n) {
        assertTimeout(ofMillis(10), () -> getFibonacci().compute(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100, 150, 200})
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @Order(2)
    default void timeoutNotExceededOneHundredMilis(int n) {
        assertTimeout(ofMillis(100), () -> getFibonacci().compute(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100, 150, 200})
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @Order(2)
    default void timeoutNotExceededOneSecond(int n) {
        assertTimeout(ofSeconds(1), () -> getFibonacci().compute(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100, 150, 200})
    @Timeout(value = 10, unit = TimeUnit.MINUTES)
    @Order(4)
    default void timeoutNotExceededOneMinute(int n) {
        assertTimeout(ofMinutes(1), () -> getFibonacci().compute(n));
    }

    // Auxiliary functions

    Fibonacci getFibonacci();

    static Stream<Arguments> argumentsLow(){
        return Stream.of(
                Arguments.of(0, BigInteger.ZERO),
                Arguments.of(1, BigInteger.ONE),
                Arguments.of(2, BigInteger.ONE),
                Arguments.of(10, BigInteger.valueOf(55)),
                Arguments.of(15, BigInteger.valueOf(610))
        );
    }

    static Stream<Arguments> argumentsMedium(){
        return Stream.of(
                Arguments.of(30, new BigInteger("832040")),
                Arguments.of(40, new BigInteger("102334155")),
                Arguments.of(50, new BigInteger("12586269025"))
        );
    }

    static Stream<Arguments> argumentsHigh() {
        return Stream.of(
                Arguments.of(100, new BigInteger("354224848179261915075")),
                Arguments.of(200, new BigInteger("280571172992510140037611932413038677189525")),
                Arguments.of(300, new BigInteger("222232244629420445529739893461909967206666939096499764990979600"))
        );
    }
}