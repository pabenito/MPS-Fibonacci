import org.junit.jupiter.api.BeforeAll;

class FibonacciIterativeTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciIterative();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}