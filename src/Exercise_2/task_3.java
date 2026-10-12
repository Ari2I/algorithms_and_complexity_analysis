package Exercise_2;

import java.util.Arrays;

public class task_3 {
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] count = new int[4];

        for (int num : array) {
            count[num]++;
        }

        int index = 0;
        for (int level = 0; level < count.length; level++) {
            while (count[level] > 0) {
                array[index++] = level;
                count[level]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = {3, 0, 2, 3, 1};
        System.out.println("Вход:  " + Arrays.toString(test1));
        sort(test1);
        System.out.println("Выход: " + Arrays.toString(test1));

        int[] test2 = {2, 2, 0, 3};
        System.out.println("Вход:  " + Arrays.toString(test2));
        sort(test2);
        System.out.println("Выход: " + Arrays.toString(test2));
    }
}


// Сложность O(n)