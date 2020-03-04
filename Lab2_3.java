import java.util.*;

class Lab2_3 {
    static void readEq(String equation) {
        String[] chemicals = equation.split("->");
        String[] reactants = chemicals[0].split("\\+");
        String[] products = chemicals[1].split("\\+");
        System.out.print("Reactants are ");
        for (String chem : reactants) {
            String str = chem.replaceAll("[A-Za-z]+", " ");
            int start = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    break;
                }
                start = start + 1;
            }

            String numAtom = "";
            if (start > 0) {
                for (int i = 0; i < start; i++) {
                    numAtom = numAtom + chem.charAt(i);
                }

            } else {
                numAtom = numAtom + "1";
            }
            System.out.print(numAtom + " moles of ");
            String chemAtom = "";
            for (int i = start; i < chem.length(); i++) {
                chemAtom = chemAtom + chem.charAt(i);
            }
            System.out.print(chemAtom + " ");
        }
        System.out.println();

        System.out.print("Products are ");

        for (String chem : products) {
            String str = chem.replaceAll("[A-Za-z]+", " ");
            int start = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    break;
                }
                start = start + 1;
            }

            String numAtom = "";
            if (start > 0) {
                for (int i = 0; i < start; i++) {
                    numAtom = numAtom + chem.charAt(i);
                }
            } else {
                numAtom = numAtom + "1";
            }
            System.out.print(numAtom + " moles of ");
            String chemAtom = "";
            for (int i = start; i < chem.length(); i++) {
                chemAtom = chemAtom + chem.charAt(i);
            }
            System.out.print(chemAtom + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();
        readEq(equation);

    }
}