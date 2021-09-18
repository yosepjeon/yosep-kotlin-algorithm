package baekjoon.ds.stack.p17298오큰수;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int N = scr.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int element = scr.nextInt();
            arr[i] = element;
        }

        int index = 0;

        for (int i = 0; i < N; ) {
            int element = arr[i];

            for (int j = i + 1; j < N; j++) {
                if (element < arr[j]) {
                    i = j;
                }

                for (int k = i; k < j; k++) {
                    queue.add(arr[j]);
                }
            }
        }

        queue.add(-1);

        System.out.println(queue);
    }
}
