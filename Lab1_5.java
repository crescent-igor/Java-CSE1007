import java.util.*;

class Lab1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double w = sc.nextDouble();
        double h = sc.nextDouble();
        double BMI = w / (h * h);
        sc.close();
        if(BMI>30){
            System.out.println("Obese");
        } else if(BMI>25){
            System.out.println("Over Weight");
        } else if(BMI>18.5){
            System.out.println("Normal Weight");
        } else{
            System.out.println("Under Weight");
        }

    }
}