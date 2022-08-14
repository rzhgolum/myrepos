
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {

    public static void main (String[] args) throws IOException {
        int num1, num2;
        char znak = 0;
        int res;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine().replaceAll("\\s+","");

        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                znak = '+';
            }
            if (under_char[i] == '-') {
                znak = '-';
            }
            if (under_char[i] == '*') {
                znak = '*';
            }
            if (under_char[i] == '/') {
                znak = '/';
            }
        }

        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();

        num1 = romanToNumber(stable00);
        num2 = romanToNumber(string03);

        if(num1 > 10 || num2 > 10){
            return;
        }

        if (num1 < 0 && num2 < 0) {
            res = 0;
        } else {
            res = calculated(num1, num2, znak);
            String resultRoman = convertNumToRoman(res);
            System.out.println(stable00 + " " + znak + " " + string03 + " = " + resultRoman);
        }

        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);

        // проверка араб
        if(num1 > 10 || num2 > 10){
            System.out.println("Numbers > 10");
            return;
        }

        res = calculated(num1, num2, znak);
        System.out.println("--result arab----");
        System.out.println(num1 + " " + znak + " " + num2 + " = " + res);

    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber (String roman) {
        String[] mas = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int d = 0;
        for(int j = 0; j < mas.length; j++) {
            try {
                if (roman.equals(mas[j])) {
                    d = j;
                    return d;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Non");
            }
        }

        if(d > 10){
            return 0;
        }
        return -1;
    }

    public static int calculated (int numc1, int numc2, char op) {
        int result = 0;

        switch (op) {
            case '+':
                result = numc1 + numc2;
                break;
            case '-':
                result = numc1 - numc2;
                break;
            case '*':
                result = numc1 * numc2;
                break;
            case '/':
                try {
                    result = numc1 / numc2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Error");
        }
        return result;
    }
}


