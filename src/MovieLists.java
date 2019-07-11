import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieLists {
    private ArrayList <String> movies;

    public MovieLists(String path)
    {
        movies = new ArrayList();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                movies.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("File does not Exist!");
        }
    }

    public String getRandomMovie(){
        int movieIndex = (int)(Math.random()*movies.size());
        return movies.get(movieIndex);
    }
}
