package primespackage;

public class Primes {

    public static boolean checkPrime(int n) {
        int i = 2;
        if (n == 1 || n == 2) {
            return false;
        }
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }

}