import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coincounter {
    private static final int[] euroCoins = {200, 100, 50, 20, 10, 5, 2, 1};
    private static final String regexMoney = "^(0|([1-9][0-9]*))\\.\\d\\d$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                This program prints out the number of each coin needed for the change in Euro
                The input uses the form '$.$$'
                Example : '6.25' or '0.99'
                """);

        while (true) {
            System.out.println("Enter the amount in euro: ");

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

    /**
     *
     * @param input as String in Form of "^(0|([1-9][0-9]*))\\.\\d\\d$"
     * @return amount in cent
     * @throws AssertionError if input doesn't match the regex
     */
    public static int euroToCents(String input) {
        assert(input.matches(regexMoney));
        input = input.replace(".", "");
        return Integer.parseInt(input);
    }

    /**
     * @param cents input in cent. Only positive digits > 0 are allowed
     * @return a ArrayList of type CoinVal with the minimum needed number of Coins
     * @throws AssertionError if input of cents <= 0
     */
    public static List<CoinVal> calcCoins(int cents) {
        assert(cents > 0);
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
