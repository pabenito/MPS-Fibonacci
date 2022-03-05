import org.junit.jupiter.api.BeforeAll;

class FibonacciRecursiveFastTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciRecursiveFast();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}