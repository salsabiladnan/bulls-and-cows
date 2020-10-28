package bullscows;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String code = "1101";

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); 

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 4; i++) {
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

        if (bulls == 0 && cows == 0) {
            System.out.printf("Grade: None. The secret code is %s.", code);
        } else if (bulls > 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, code);
        } else if (bulls == 0 && cows > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, code);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is $s.", bulls, cows, code);
        }
    }
}