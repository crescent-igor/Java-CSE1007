import java.util.Scanner;

import primespackage.*;

class TwinPrimes {
    static void display(int n, int m) {
        if (n > m) {
            System.out.println("Invalid Range");
        } else {
            for (int i = n + 2; i < m; i++) {
                if (Primes.checkPrime(i) && Primes.checkPrime(i - 2)) {
                    System.out.println(i + " " + (i - 2));
                }

            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        display(sc.nextInt(), sc.nextInt());
        sc.close();
    }
}
