import java.util.Scanner;

class IllegalArgumentException extends RuntimeException {
    IllegalArgumentException(String meesage) {
        super(meesage);
    }
}

class NumberFormatException extends RuntimeException {
    NumberFormatException(String meesage) {
        super(meesage);
    }
}

class NoSuchElementException extends RuntimeException {
    NoSuchElementException(String meesage) {
        super(meesage);

    }
}

class Lab4_1 {
    static void validate(String RegNo, String mobNum) {
        if (RegNo.length() != 9 || mobNum.length() != 10) {
            throw new IllegalArgumentException("IllegalArgumentException: Details not Valid");
        }
        for (int i = 0; i < mobNum.length(); i++) {
            if (mobNum.charAt(i) < '0' || mobNum.charAt(i) > '9') {
                throw new NumberFormatException("NumberFormatException: Mobile  Number not Valid");
            }
        }
        for (int i = 0; i < RegNo.length(); i++) {
            if (!((RegNo.charAt(i) >= 'a' && RegNo.charAt(i) <= 'z')
                    || (RegNo.charAt(i) >= 'A' && RegNo.charAt(i) <= 'Z')
                    || (RegNo.charAt(i) >= '0' && RegNo.charAt(i) <= '9'))) {
                throw new NoSuchElementException("NoSuchElementException: Reg number not Valid");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String RegNo = sc.next();
        String mobNum = sc.next();
        sc.close();
        try {
            validate(RegNo, mobNum);
            System.out.println("Valid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid");

        }

    }
}