import java.util.Scanner;

public class Coincounter {
    private static final int[] euroCoins = {200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Geben sie den Betrag in Cent ein: ");

            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                System.out.println("Goodbye");
                System.exit(0);
            }
            else if (input.matches("^[1-9]\\d*$") && input.length() <= 20) {
                calcCoins(Integer.parseInt(input));
            }
            else {
                System.err.println("Your input is not correct, please check it");
            }
        }
    }
    private static void calcCoins(int mod) {
       for (int coinVal : euroCoins) {
           int numberOf = mod / coinVal;

           if(numberOf > 0) {
               if (coinVal >= 100) System.out.printf("%dx %d Euro\n", numberOf, coinVal / 100);
               else System.out.printf("%dx %d Cent\n", numberOf, coinVal);
           }
           mod %= coinVal;
       }
    }
}
