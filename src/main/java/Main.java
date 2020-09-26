import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyArray arr = new MyArray(50_000_000, 10);
        arr.initializeArr();
        Calc oneThreadSolution = new OneThreadSolution(arr.getArr());
        Calc multiThreadSolution = new MultiThreadSolution(arr.getArr());

        test(oneThreadSolution);
        test(multiThreadSolution);

        MultiThreadSolution multiThreadSolution1 = new MultiThreadSolution(0, 50_000_000, arr.getArr());
        ForkJoinPool pool = new ForkJoinPool(6);
        long startTime = System.currentTimeMillis();
        Integer mySum = pool.invoke(multiThreadSolution1);
        System.out.println("!Сумма = " + mySum);
        System.out.println("!Cреднее арифметическое = " + mySum / multiThreadSolution1.getEnd());
        long endTime = System.currentTimeMillis();
        System.out.println("!Затраченое время : " + (endTime - startTime) + " мс\n");

        System.out.println("-------------------");
    }

    static void test(Calc calc){
        long startTime = System.currentTimeMillis();
        System.out.println("Сумма = " + calc.calcSum());
        System.out.println("Cреднее арифметическое = " + calc.calcArithmeticalMean());
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченое время : " + (endTime - startTime) + " мс\n");
    }
}
