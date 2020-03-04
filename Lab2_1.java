import java.util.*;

class Lab2_1 {
    static int cycleLength(int num) {
        int count = 1;
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        if (i < j) {
            int maxCycle = 0;
            int maxVal = 0;

            for (int iter = i; iter < j; iter++) {
                int cycleLength = cycleLength(iter);
                System.out.println("Cycle length of " + iter + " is " + cycleLength);
                if (cycleLength > maxCycle) {
                    maxCycle = cycleLength;
                    maxVal = iter;
                }

            }
            System.out.println("Maximum Cycle Length from " + i + "-" + j + ": " + maxCycle + " for " + maxVal);
        }
        System.out.println("Cycle Length of Registration Number is " + cycleLength(1082));

    }
}
