import java.util.Random;
import java.util.Scanner;

public class diceprogram {
    public static void main(String[] args) {
        //java dice roller program
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        //declare variable
        int ndice;
        int total = 0;
        System.out.println("Enter the # of dice to roll : ");
        ndice = sc.nextInt();

        if (ndice > 0) {
            //System.out.println("you roll the dice");

            for (int i = 0; i < ndice; i++) {
                int roll = rm.nextInt(1, 6);
                printDie(roll);
                System.out.println("you rolled " + roll);
                total += roll;
            }
            System.out.println("total " + total);
        } else {
            System.out.println("# of dice must of greater than 0");
        }
        sc.close();
    }
        //roll the dice

        //total get
        // display ascii of dice
       static void printDie(int roll){
String dice1= """
         -------
        |      |
        |  ●   |
        |      |
        --------
        """;
           String dice2= """
         -------
        |      |
        |  ●   |
        |    ● |
        --------
        """;
           String dice3= """
         -------
        | ●    |
        |  ●   |
        |    ●  |
        --------
        """;
           String dice4= """
         -------
        | ●  ● |
        |      |
        | ●  ● |
        --------
        """;
           String dice5= """
         -------
        | ●  ● |
        |   ●  |
        | ●  ● |
        --------
        """;
           String dice6= """
         -------
        | ●  ● |
        | ●  ● |
        | ●  ● |
        --------
        """;

           switch(roll){
               case 1 -> System.out.println(dice1);
               case 2 -> System.out.println(dice2);
               case 3 -> System.out.println(dice3);
               case 4 -> System.out.println(dice4);
               case 5 -> System.out.println(dice5);
               case 6 -> System.out.println(dice6);
               default -> System.out.println("invalid");
           }


    }



}
