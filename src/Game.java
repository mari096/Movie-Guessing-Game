import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private String movieTitle;
    private int pointsLost;
    private String rightLetters;
    private String wrongLetters;
    private boolean gameWon;

    public Game(String path)
    {
        MovieLists movieLists = new MovieLists(path);
        movieTitle = movieLists.getRandomMovie().trim();
        pointsLost = 0;
        rightLetters = "";
        wrongLetters = "";
        gameWon = false;
    }

    public String getMovieTitle()
    {
        return movieTitle;
    }

    public String getWrongLetters()
    {
        return wrongLetters;
    }

    public String getRightLetters()
    {
        return rightLetters;
    }

    public boolean isGameWon()
    {
        return gameWon;
    }

    public String getHiddenMovieTitle()
    {
        if(rightLetters=="")
            return movieTitle.replaceAll("[a-zA-Z]","-");
        return movieTitle.replaceAll("[a-zA-Z&&[^"+ rightLetters +"]]","-");
    }

    public boolean GameEnded()
    {
        if(pointsLost>=10)
            return true;
        if(!getHiddenMovieTitle().toString().contains("-")) {
            gameWon = true;
            return true;
        }
        return false;
    }

    private String inputLetter()
    {
        System.out.println("Please enter your next guess :");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();
        if(letter.length()>1){
            System.out.println("Wrong input!");
            return inputLetter();
        }
        else if(letter.charAt(0)>122 || letter.charAt(0)<97){
            System.out.println("Not an input letter");
            return inputLetter();
        }
        else if(rightLetters.contains(letter) || wrongLetters.contains(letter)){
            System.out.println("Already tried before");
            return inputLetter();
        }
        return letter;
    }

    public void guessLetter()
    {
        String guessedLetter = inputLetter();
        if(movieTitle.contains(guessedLetter)){
            rightLetters = rightLetters + guessedLetter;
        }
        else {
            pointsLost++;
            wrongLetters = wrongLetters + guessedLetter;
        }
        return;
    }
}
