//import java.util.Random;
//import java.util.Scanner;
//
//public class slotmachinearray {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int balance = 100;
//        int bet;
//        int payout;
//        String[] row;
//
//        System.out.println("**************");
//        System.out.println("Welcome to Java Machine Slots");
//        System.out.println("Symbols: 🍇 🍈 🍍 🍒 🥝 🍎");
//        System.out.println("**************");
//
//        while (balance > 0) {
//            System.out.println("Current Balance: $" + balance);
//            System.out.print("Place your bet: ");
//            bet = sc.nextInt();
//
//            if (bet > balance) {
//                System.out.println("Insufficient funds!");
//                continue;
//            } else if (bet <= 0) {
//                System.out.println("Bet must be greater than 0!");
//                continue;
//            }
//
//            balance -= bet;
//            System.out.println("Spinning...");
//            row = spinRow();
//            printRow(row);
//
//            payout = getPayout(row, bet);
//            balance += payout;
//
//            if (payout > 0) {
//                System.out.println("You won $" + payout + "!");
//            } else {
//                System.out.println("No match, you lost your bet.");
//            }
//
//            System.out.println("-----------------------------------");
//        }
//
//        System.out.println("Game over! You ran out of money.");
//        sc.close();
//    }
//
//    static String[] spinRow() {
//        String[] symbols = {"🍇", "🍈", "🍍", "🍒", "🥝", "🍎"};
//        String[] row = new String[3];
//        Random rm = new Random();
//
//        for (int i = 0; i < 3; i++) {
//            row[i] = symbols[rm.nextInt(symbols.length)];
//        }
//
//        return row;
//    }
//
//    static void printRow(String[] row) {
//        System.out.println("************");
//        System.out.println(" " + String.join(" | ", row));
//        System.out.println("************");
//    }
//
//    static int getPayout(String[] row, int bet) {
//        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
//            switch (row[0]) {
//                case "🍇":
//                    return bet * 2;
//                case "🍈":
//                    return bet * 3;
//                case "🍍":
//                    return bet * 4;
//                case "🍒":
//                    return bet * 5;
//                case "🥝":
//                    return bet * 6;
//                case "🍎":
//                    return bet * 10;
//                default:
//                    return 0;
//            }
//        }
//        return 0;
//    }
//}
import java.util.Scanner;

public class slotmachinearray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 100;
        int payout;
        String[] row;
        int turn = 0;

        System.out.println("**************");
        System.out.println("Welcome to Java Machine Slots");
        System.out.println("Symbols: 🍇 🍈 🍍 🍒 🥝 🍎");
        System.out.println("**************");

        while (balance > 0) {
            System.out.println("Current Balance: $" + balance);
            System.out.print("Enter your bet: ");
            int bet = sc.nextInt();

            if (bet <= 0 || bet > balance) {
                System.out.println("Invalid bet amount.");
                continue;
            }

            balance -= bet;

            // Controlled win/loss pattern: 10 wins, then 2 losses
            if ((turn % 12) < 10) {
                // Win
                row = generateWinningRow();
            } else {
                // Loss
                row = generateLosingRow();
            }

            printRow(row);
            payout = getPayout(row, bet);
            balance += payout;

            if (payout > 0) {
                System.out.println("You WON $" + payout + "!");
            } else {
                System.out.println("You LOST your bet.");
            }

            turn++;
            System.out.println("------------------------------------");

            if (balance <= 0) {
                System.out.println("Game over. You're out of balance!");
                break;
            }
        }

        sc.close();
    }

    static String[] generateWinningRow() {
        String symbol = "🍒"; // fixed winning symbol
        return new String[]{symbol, symbol, symbol};
    }

    static String[] generateLosingRow() {
        return new String[]{"🍇", "🍈", "🍍"}; // always mismatched
    }

    static void printRow(String[] row) {
        System.out.println("************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("************");
    }

    static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            switch (row[0]) {
                case "🍇": return bet * 2;
                case "🍈": return bet * 3;
                case "🍍": return bet * 4;
                case "🍒": return bet * 5;
                case "🥝": return bet * 6;
                case "🍎": return bet * 10;
            }
        }
        return 0;
    }
}
