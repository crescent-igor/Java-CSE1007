import java.util.*;

class Lab1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Marks = new int[5];
        for (int i = 0; i < Marks.length; i++) {
            Marks[i] = sc.nextInt();
        }
        sc.close();
        int Average = 0;
        for (int i = 0; i < Marks.length; i++) {
            Average = Average + Marks[i];
        }
        Average = Average / Marks.length;
        System.out.println("Average marks:" + Average);
        System.out.println("Percentage:" + ((double) Average / 100));
        if (Average >= 90) {

            System.out.println("Grade: S");
        } else if (Average >= 80) {

            System.out.println("Grade: A");
        } else if (Average >= 70) {

            System.out.println("Grade: B");
        } else if (Average >= 60) {

            System.out.println("Grade: C");
        } else if (Average >= 50) {

            System.out.println("Grade: D");
        } else {

            System.out.println("Fail");
        }

    }
}