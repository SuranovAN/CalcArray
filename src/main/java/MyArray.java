import java.util.Random;

public class MyArray {
    private int[] arr;
    private final int size, randomRange;

    public MyArray(int size, int randomRange) {
        this.size = size;
        this.randomRange = randomRange;
    }

    public int[] getArr() {
        return arr;
    }

    void initializeArr() {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(randomRange);
        }
        this.arr = arr;
    }
}
