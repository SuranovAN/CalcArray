import java.util.Arrays;

public class OneThreadSolution implements Calc{
    private final int[] arr;
    private long sum;

    public OneThreadSolution(int[] arr) {
        this.arr = arr;
    }

    @Override
    public long calcSum(){
        sum = Arrays.stream(arr).asLongStream().sum();
        return sum;
    }

    @Override
    public long calcArithmeticalMean(){
        return sum / arr.length;
    }
}
