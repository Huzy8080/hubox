package com.hubox.algorithms.sort;

import com.hubox.util.RandomUtils;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

import static com.hubox.algorithms.sort.AbstractSort.isSorted;
import static com.hubox.algorithms.sort.AbstractSort.show;
import static com.hubox.algorithms.sort.Quick.sort3String;

public class QuickTest {

    @Test
    public void sortTest() {
        int N = 20;
        int R = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(R);
        }
        show(a);
        Quick.sort(a);
        assert isSorted(a);
        show(a);
    }

    @Test
    public void sort3WayTest() {
        int N = 20;
        int R = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(R);
        }
        show(a);
        Quick.sort3Way(a);
        assert isSorted(a);
        show(a);
    }

    @Test
    public void sort3StringTest() {
        String[] a = RandomUtils.getRandomStrArray(20);
        show(a);
        sort3String(a);
        assert isSorted(a);
        show(a);
    }

    @Test
    public void sort3StringAvgTime() {
        int times = 22;
        int length = 1000000;
        String[] a = RandomUtils.getRandomStrArray(length);
        Double[] timeArray = new Double[times];
        for (int i = 0; i < times; i++) {
            StdRandom.shuffle(a);
            Stopwatch stopwatch = new Stopwatch();
            sort3String(a);
            double time = stopwatch.elapsedTime();
            timeArray[i] = time;
        }
        Quick.sort(timeArray);
        Double totalTime = 0.000;
        for (int i = 1; i < times - 1; i++) {
            totalTime += timeArray[i];
        }
        double avg = totalTime / (times - 2);
        System.out.println("sorted " + length + ": avg time=" + avg);
    }

}