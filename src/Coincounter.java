import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coincounter {
    private static final int[] euroCoins = {200, 100, 50, 20, 10, 5, 2, 1};
    private static final String regexMoney = "^(0|([1-9][0-9]*))\\.\\d\\d$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                This program prints out the number of each coin needed for the change
                The input uses the form '$.$$'
                Example : '6.25' or '0.99'
                """);

        while (true) {
            System.out.println("Enter the amount in Euro: ");

            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                System.out.println("Goodbye");
                System.exit(0);
            } else if (input.matches(regexMoney) && input.length() <= 10) {
                List<CoinVal> calcCoins = calcCoins(euroToCents(input));
                calcCoins.forEach(element -> System.out.println(element.toString()));
            } else {
                System.err.println("Your input is not correct, please check it");
            }
        }
    }

    private static int euroToCents(String input) {
        input = input.replace(".", "");
        return Integer.parseInt(input);
    }

    /**
     * @param cents input
     * @return a ArrayList of type CoinVal with the minimum needed number of Coins
     */
    private static List<CoinVal> calcCoins(int cents) {
        List<CoinVal> list = new ArrayList<>();

        for (int coinVal : euroCoins) {
            int numberOf = cents / coinVal;
            if (numberOf > 0)
                list.add(new CoinVal(coinVal, numberOf));

            cents %= coinVal;
        }
        return list;
    }
}
