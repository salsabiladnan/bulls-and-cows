package bullscows;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long pseudoRandomNumber = System.nanoTime();
        
        String random = String.valueOf(pseudoRandomNumber);
        
        int input = scanner.nextInt(); 
        
        StringBuilder res = new StringBuilder();

        if (input > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", input);
        } else {
            for (int i = 0; i < input; i++) {
                String resStr = res.toString();
                String randomI = String.valueOf(random.charAt(i));
                if (!resStr.contains(randomI)) {
                    res.append(randomI);
                } else {
                    input += 1;
                }
            }
            System.out.printf("The random secret number is %s.", res);
        }
    }
}