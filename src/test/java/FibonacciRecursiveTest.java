import org.junit.jupiter.api.BeforeAll;

class FibonacciRecursiveTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciRecursive();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}