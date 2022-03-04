import java.math.BigInteger;

public class FibonacciRecursiveThread extends Thread implements Fibonacci{
    private int number;
    private BigInteger result;

    // Constructors
    public FibonacciRecursiveThread(){}

    private FibonacciRecursiveThread(int n){
        this.number = n;
    }

    // API Fibonacci
    @Override
    public BigInteger compute(int n) {
        this.number = n;
        run();
        return result;
    }

    // Thread
    @Override
    public void run(){
        if(result == null){
            if(number == 0){
                result = BigInteger.ZERO;
            }else if(number == 1){
                result = BigInteger.ONE;
            }else {
                FibonacciRecursiveThread less1 = new FibonacciRecursiveThread(number - 1);
                FibonacciRecursiveThread less2 = new FibonacciRecursiveThread(number - 2);
                less1.run();
                less2.run();
                try {
                    less1.join();
                    less2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.result = less1.getResult().add(less2.getResult());
            }
        }
    }

    // Private
    private BigInteger getResult() {
        return result;
    }
}
