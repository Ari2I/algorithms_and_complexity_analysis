package practice1;


import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class sortTest {
    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testBubbleSort(int N) {
        //Random random = new Random(7777);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = N - i + 1;//random.nextInt(100);

        long start = System.nanoTime();
        sort.selectionSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }

    }

    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testBubbleSortBest(int N) {
        //Random random = new Random(7777);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;//random.nextInt(100);

        long start = System.nanoTime();
        sort.selectionSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }

    }

    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testBubbleSortAVG(int N) {
        Random random = new Random(7777);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = random.nextInt(100);

        long start = System.nanoTime();
        sort.selectionSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }

    }

    static Stream<Arguments> testSelectionSort() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(2000),
                Arguments.of(4000),
                Arguments.of(8000),
                Arguments.of(16000),
                Arguments.of(32000),
                Arguments.of(64000),
                Arguments.of(120000)
        );
    }

}