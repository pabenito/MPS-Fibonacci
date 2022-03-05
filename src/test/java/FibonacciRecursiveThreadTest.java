import org.junit.jupiter.api.BeforeAll;

class FibonacciRecursiveThreadTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciRecursiveThread();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}