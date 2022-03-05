import org.junit.jupiter.api.BeforeAll;

class FibonacciRecusiveLinearTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciRecusiveLinear();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}