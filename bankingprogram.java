import java.util.Scanner;



public class bankingprogram {
    static Scanner sc=new Scanner((System.in));
    public static void main(String[] args){
        //JAVA BANKING PROGRAM
        //DECLARE VARIABLE
        double balance =100;

        boolean isRunning=true;
        int choice;
while(isRunning) {
    //DISPLAY MENU
    System.out.println("***********");
    System.out.println("BANKING PROGRAM: ");
    System.out.println("*********");
    System.out.println("Enter your choice: ");
    System.out.println("*************");
    //System.out.println("****************************");
    //GET AND PROCESS USER CHOICE
    System.out.println("1.balance");
    System.out.println("2.deposit");
    System.out.println("3.withdraw");
    System.out.println("4.exit");

    System.out.println("enter your choice between(1-4)");
    choice = sc.nextInt();

    switch (choice) {
        case 1 -> showbalance(balance);
        case 2 -> balance+=deposit();
        case 3 -> balance-=withdraw();
        case 4 -> {
            System.out.println("thank you for banking with us");
            isRunning=false;
        }
        default -> System.out.println("invalid ");
    }
}
sc.close();

    }
    static void showbalance(double balance) {
        System.out.printf("$%.2f\n", balance);
    }
        static double deposit() {
            double amount;
            System.out.println("enetr money to deposit");

            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("amount cant negative");
                return 0;

            } else {
                return amount;
            }
        }
            static double withdraw() {
                double money;
                System.out.println("enetr money to withdraw");

                money = sc.nextDouble();
                if (money < 0) {
                    System.out.println("amount cant negative");
                    return 0;

                } else {
                    return money;

                }
            }
            // exit page
            static void exit() {
                System.out.println("thank you for banking with us");


    }
}
