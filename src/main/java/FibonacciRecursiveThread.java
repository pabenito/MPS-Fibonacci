import java.math.BigInteger;

public class FibonacciRecursiveThread extends Thread{
    private int number;
    private BigInteger result;

    public FibonacciRecursiveThread(int n){
        this.number = n;
    }

    @Override
    public void run(){
        if(result == null){
            if(number == 0 || number == 1){
                //result = new BigInteger(1);
            }
        }
    }
}
