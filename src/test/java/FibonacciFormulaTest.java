import org.junit.jupiter.api.BeforeAll;

class FibonacciFormulaTest implements FibonacciTest{
    static private Fibonacci fibonacci;

    @BeforeAll
    static void create(){
        fibonacci = new FibonacciFormula();
    }

    @Override
    public Fibonacci getFibonacci() {
        return fibonacci;
    }
}