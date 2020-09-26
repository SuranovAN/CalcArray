import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.RecursiveTask;

public class MultiThreadSolution extends RecursiveTask<Integer> implements Calc {
    int start;
    int end;
    int sum;
    private final int[] arr;

    public MultiThreadSolution(int[] arr) {
        this.arr = arr;
    }

    public MultiThreadSolution(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    public long calcSum() {
        sum = Arrays.stream(arr).parallel().sum();
        return sum;
    }

    @Override
    public long calcArithmeticalMean() {
        return sum / arr.length;
    }

    @Override
    public Integer compute() {
        final int diff = end - start;
        switch (diff) {
            case 0:
                return 0;
            case 1:
                return arr[start];
            case 2:
                return arr[start] + arr[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    private Integer forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;
        MultiThreadSolution task1 = new MultiThreadSolution(start, middle, arr);
        MultiThreadSolution task2 = new MultiThreadSolution(middle, end, arr);
        invokeAll(task1, task2);
        return task1.join() + task2.join();
    }

    public int getEnd() {
        return end;
    }
}
