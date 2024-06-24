import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    private static int pokemonCount = 0;

    //This is the method that gets the correct line from the file
    public String[] readPokemonWithScanner(int lineNumber) throws
            FileNotFoundException {
        ArrayList pokemonsList = new ArrayList();
        File libraryFile = new File("C:\\Users\\Codersbay\\Desktop\\Java-Pokemon\\src\\main\\java\\2023-03-13-Pokemon.csv");
        Scanner fileScanner = new Scanner(libraryFile);
        while (fileScanner.hasNextLine()) {
            pokemonsList.add(fileScanner.nextLine());
        }
        String line = (String) pokemonsList.get(lineNumber);
        fileScanner.close();
        String[] arrOfStr = line.split(";");
        return arrOfStr;
    }

    public String[] readAttacksWithScanner(int lineNumber) throws
            FileNotFoundException {
        ArrayList pokemonsList = new ArrayList();
        File libraryFile = new File("C:\\Users\\Codersbay\\Desktop\\Java-Pokemon\\src\\main\\java\\2023-04-03-Attacks.csv");
        Scanner fileScanner = new Scanner(libraryFile);
        while (fileScanner.hasNextLine()) {
            pokemonsList.add(fileScanner.nextLine());
        }
        String line = (String) pokemonsList.get(lineNumber);
        fileScanner.close();
        String[] arrOfStr = line.split(";");
        return arrOfStr;
    }

    public int printPokemonWithCount() throws
            FileNotFoundException {
        ArrayList pokemonsList = new ArrayList();
        File libraryFile = new File("C:\\Users\\Codersbay\\Desktop\\Java-Pokemon\\src\\main\\java\\2023-03-13-Pokemon.csv");
        Scanner fileScanner = new Scanner(libraryFile);
        int lineNumber = 0;
        while (fileScanner.hasNextLine()) {
            pokemonsList.add(fileScanner.nextLine());
            String line = (String) pokemonsList.get(lineNumber);
            String[] arrOfStr = line.split(";");
            if (lineNumber != 0) System.out.println(arrOfStr[0] + " " + arrOfStr[1]);
            lineNumber++;
        }
        fileScanner.close();

        return pokemonsList.size() - 1;
    }

}
