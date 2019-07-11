import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameIsOn = true;
        while(gameIsOn){
            Game game = new Game("/home/saikat/IdeaProjects/JavaProject/Movies.txt");
            System.out.println("Welcome to the Movie Guessing Game!");
            System.out.println("Here we give you a total of 10 chances to guess the movie name.");
            System.out.println("Please continue to play the game. Enjoy!");
            System.out.println("The length of the Movie Name is " + game.getMovieTitle().length());
            System.out.println("Guess the movie ");

            while (!game.GameEnded()) {
                System.out.println("You are guessing :" + game.getHiddenMovieTitle());
                System.out.println("You have guessed " + game.getWrongLetters().length() + " wrong letters.");
                System.out.println("Guess a letter : ");
                game.guessLetter();
            }
            if (game.isGameWon()) {
                System.out.println("You have WON and guessed the movie correctly!");
                System.out.println("The movie is " + game.getMovieTitle());
            } else {
                System.out.println("Sorry, but you have run out of chances...");
                System.out.println("The total number of wrong guesses are " + game.getWrongLetters().length());
                System.out.println("The movie was " + game.getMovieTitle());
                System.out.println("Better luck next time");
            }
            System.out.println("Do you want to play again? Y/N");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().toUpperCase().contains("N"))
                gameIsOn = false;
        }
    }
}
