
class Lab1_3 {
    public static void main(String[] args) {
        int pop = 1000;
        int count = 0;
        while (pop < 30000) {
            pop = pop + (pop / 10);
            count = count + 1;
            if (pop < 30000) {
                System.out.println("Population in year " + count + ": " + pop);
            }
        }

    }
}