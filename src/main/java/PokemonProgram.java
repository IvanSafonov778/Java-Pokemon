import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PokemonProgram {
    public static void main(String[] args) throws FileNotFoundException {
        PokemonArena pokemonArena = new PokemonArena();
        pokemonArena.play();
    }
}