import java.util.*;

class Lab1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int aa = 10 * a + a;
        int aaa = aa + 100 * a;
        int aaaa = aaa + 1000 * a;
        System.out.println("a+aa+aaa+aaaa= "+(a+aa+aaa+aaaa));
        sc.close();

    }
}