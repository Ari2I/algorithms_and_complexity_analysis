package Exercise_2;

import java.util.Arrays;

public class task_2 {
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int max = array[0];
        for (int val : array) {
            if (val > max) {
                max = val;
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] test1 = {9999, 12, 100, 12};
        System.out.println("Вход 1:  " + Arrays.toString(test1));
        sort(test1);
        System.out.println("Выход 1: " + Arrays.toString(test1));
        System.out.println();

        int[] test2 = {777, 7120, 700};
        System.out.println("Вход 2:  " + Arrays.toString(test2));
        sort(test2);
        System.out.println("Выход 2: " + Arrays.toString(test2));
    }
}

// сложность O(d * (k + n)) d - кол-во разрядов, k - диапазон значений