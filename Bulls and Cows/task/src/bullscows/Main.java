package bullscows;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int length = scanner.nextInt();
        System.out.println("Okay, let's start a game!");
        String code = secretCode(length);

        String output = "";
        String expect = "";
        if (length == 1) {
            expect = "Grade: 1 bull";
        } else {
            expect = "Grade: " + length + " bulls";
        }

        int n = 1;

        while (!output.equals(expect)) {
            output = turn(n,code);
            System.out.println(output);
            n++;

        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String secretCode(int length) {
        long pseudoRandomNumber = System.nanoTime();
        String random = String.valueOf(pseudoRandomNumber);

        StringBuilder res = new StringBuilder();

        if (length > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", length);
        } else {
            for (int i = 0; i < length; i++) {
                String resStr = res.toString();
                String randomI = String.valueOf(random.charAt(i));
                if (!resStr.contains(randomI)) {
                    res.append(randomI);
                } else {
                    length += 1;
                }
            }
        }
        return res.toString();
    }

    public static String turn(int n, String code) {
        System.out.printf("Turn %d:%n", n);
        String input = Integer.toString(scanner.nextInt());

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < input.length(); i++) {
            System.out.println(i);
            String cek = String.valueOf(input.charAt(i));
            if (code.contains(cek)) {
                String cekCode = String.valueOf(code.charAt(i));
                if (cek.equals(cekCode)) {
                    bulls += 1;
                } else {
                    cows += 1;
                }
            }
        }

        StringBuilder output = new StringBuilder("Grade: ");

        if (bulls == 0 && cows == 0) {
            output.append("None");
        } else if (bulls > 0) {
            if (bulls == 1) {
                output.append("1 bull");
            } else {
                output.append(bulls + " bulls");
            }
        } else if (bulls > 0 && cows > 0) {
            output.append("and");
        } else if (cows > 0) {
            if (cows == 1) {
                output.append("1 cow");
            } else {
                output.append(cows + " cows");
            }
        }
        return output.toString();
    }
}
