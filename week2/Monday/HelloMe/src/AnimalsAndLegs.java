import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chickens does the farmer have?");
        int chickens=scan.nextInt();
        System.out.println("How many pigs does the farmer have?");
        int pigs= scan.nextInt();

        System.out.println("They have " + (chickens * 2 + pigs * 4) + " legs.");

    }
}
