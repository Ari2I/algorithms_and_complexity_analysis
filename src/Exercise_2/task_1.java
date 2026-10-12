package Exercise_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class task_1 {
    public static void sort(double[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;

        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double val : array) {
            int bucketIndex = (int) (n * val);
            buckets[bucketIndex].add(val);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            for (double val : buckets[i]) {
                array[index++] = val;
            }
        }
    }

    public static void main(String[] args) {
        double[] test1 = {0.42, 0.11, 0.87, 0.35};
        System.out.println("Вход 1:   " + Arrays.toString(test1));
        sort(test1);
        System.out.println("Выход 1:  " + Arrays.toString(test1));
        System.out.println();

        double[] test2 = {0.01, 0.99, 0.50};
        System.out.println("Вход 2:   " + Arrays.toString(test2));
        sort(test2);
        System.out.println("Выход 2:  " + Arrays.toString(test2));
    }
}

// сложность O(n)