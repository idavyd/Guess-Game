import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


void main() {

    Scanner scanner = new Scanner(System.in);

    int theNumber = getRandomNumber();
//        System.out.println("theNumber = " + theNumber);

    greetUser();

    int numberOfAttempts;
    numberOfAttempts = getDifficultyChoice(scanner);


    int guess;
    boolean isWinner = false;
    for (int i = 1; i <= numberOfAttempts; i++) {
        System.out.println("Attempt #"+ (i));
        while (true){
            try {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                if (0 < guess && guess <= 100 ){
                    break;
                }
                else {
                    System.out.println("The number must be between 1 and 100");
                }

            }
            catch (InputMismatchException e){
                System.out.println("Choice must be a whole number from the list.");
                scanner.next();
            }
        }

        if (guess == theNumber) {
            System.out.printf("Congratulations! You guessed the correct number in %d attempts.", i);
            isWinner = true;
            break;

        }
        else {
            if(guess > theNumber){
                System.out.println("Incorrect! The number is less than " + guess);

            }
            if(guess < theNumber){
                System.out.println("Incorrect! The number is greater than " + guess);

            }
            System.out.println();
        }



    }
    if (!isWinner){
        System.out.println("Not your day!");
        System.out.println("The number was " +  theNumber);
    }






    scanner.close();
}

public static int getRandomNumber(){
    Random randomizer = new Random();
    return randomizer.nextInt(1, 101);
}

public static void greetUser() {
    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("I'm thinking of a number between 1 and 100");
}

public static int getDifficultyChoice(Scanner scanner) {

    Map<Integer,Integer> difficultyList = Map.of(
            1, 10,
            2, 5,
            3, 3
    );


    System.out.println("Please select the difficulty level:");
    System.out.println("1. Easy (10 chances)");
    System.out.println("2. Medium (5 chances)");
    System.out.println("3. Hard (3 chances)");

    int choice;

    while(true){

        try {
            System.out.print("Your Choice: ");
            choice =  scanner.nextInt();
            if (difficultyList.containsKey(choice)){
                break;
            }
            else
                System.out.println("Incorrect Choice Value");

        }
        catch (InputMismatchException e){
            System.out.println("Choice must be a whole number from the list.");
            scanner.next();
        }

    }

    return difficultyList.get(choice);



}


