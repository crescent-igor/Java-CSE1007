import java.util.*;

class Lab2_2 {
    static int[] slowDist(int num) {
        int div = (int) (num / 4);
        int left = num % 4;

        int totalLength = 0;
        if (left != 0) {
            totalLength = div + 1;

        } else {
            totalLength = div;
        }
        int[] arr = new int[totalLength];
        for (int i = 0; i < div; i++) {
            arr[i] = 4;
        }
        if (left != 0) {
            arr[totalLength - 1] = left;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_batches = sc.nextInt();
        int[][] slowLearner = new int[num_batches][];
        for (int i = 0; i < slowLearner.length; i++) {
            int numSlowLearners = sc.nextInt();
            slowLearner[i] = slowDist(numSlowLearners);

        }

        sc.close();

        for (int[] val : slowLearner) {
            for (int v : val) {
                System.out.print(v + " ");
            }
            System.out.println("");

        }

    }
}