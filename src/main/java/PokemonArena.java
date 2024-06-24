import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class PokemonArena {
    private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";

    Scanner myScan = new Scanner(System.in);
    Random ra = new Random();
    int maxAccuracy = 101;
    FileReader fileReader = new FileReader();

    public void play() throws FileNotFoundException {

        int pokemonQuantity = fileReader.printPokemonWithCount();
        System.out.println(GREEN + "CHOOSE POKEMON (ENTER #1-" + pokemonQuantity + ")" + RESET);
        int humanPokemonNumber = myScan.nextInt();
        myScan.nextLine();
        Pokemon humanPokemon = new Pokemon(humanPokemonNumber);
        int computerPokemonNumber = 1 + ra.nextInt(pokemonQuantity);
        Pokemon computerPokemon = new Pokemon(computerPokemonNumber);
        pokemonsInfo(humanPokemon, computerPokemon);
        boolean humanTurn = ifHumanGoesFirst(humanPokemon, computerPokemon);
        while (computerPokemon.getHp() > 0 && humanPokemon.getHp() > 0
        ) {
            Attacks tempAttack;
            Pokemon attacker, defender;
            if (humanTurn) {
                tempAttack = attackOptions(humanPokemon);
                attacker = humanPokemon;
                defender = computerPokemon;
            } else {
                tempAttack = attackComputer(computerPokemon);
                defender = humanPokemon;
                attacker = computerPokemon;
            }
            if (ra.nextInt(maxAccuracy) <= tempAttack.getAccuracy()) {
                defender.setHp(defender.getHp() - calculation(attacker, defender, tempAttack));
                System.out.println("HP NOW = " + defender.getHp() + RESET);
            } else System.out.println(RESET + "MISS! NO ATTACK.");
            humanTurn = !humanTurn;
            System.out.println();
        }
        endResult(humanTurn);
    }


    public double calculation(Pokemon attacker, Pokemon defender, Attacks attack) {
        double damage;
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";

        System.out.println("ATTACK " + RED + attack.getName() + RESET);
        if (attack.getKind() == 0) {
            damage = ((attack.getPower()) *
                    ((double) attacker.getAttack() / defender.getDefense())
                    * (1.0 / 25.0));
        } else {
            damage = ((attack.getPower()) *
                    ((double) attacker.getSpAttack() / defender.getSpDefense())
                    * (1.0 / 25.0));
        }
        System.out.println(RED + "DAMAGE IS " + damage);
        return damage;
    }


    public boolean ifHumanGoesFirst(Pokemon humanPokemon, Pokemon computerPokemon) {
        boolean humanTurn;
        System.out.println();
        if (computerPokemon.getSpeed() > humanPokemon.getSpeed()) {
            humanTurn = false;
            System.out.println("COMPUTER'S POKEMON IS FASTER");
        } else if (computerPokemon.getSpeed() < humanPokemon.getSpeed()) {
            humanTurn = true;
            System.out.println("YOU GO FIRST, YOUR POKEMON IS FASTER");
        } else {
            humanTurn = ra.nextBoolean();
            System.out.println("POKEMONS HAVE THE SAME SPEED, RANDOMLY ASSIGNING WHO GOES 1ST");
        }
        System.out.println();
        return humanTurn;
    }

    public void pokemonsInfo(Pokemon humanPokemon, Pokemon computerPokemon) {
        System.out.println(YELLOW + "YOU CHOSE POKEMON WITH THESE QUALITIES:");
        System.out.println(humanPokemon);
        System.out.println("COMPUTER CHOSE POKEMON WITH THESE QUALITIES:");
        System.out.println(computerPokemon + RESET);
    }

    public void endResult(boolean humanTurn) {
        if (humanTurn) {
            System.out.println(RED + "YOU LOST. GAME OVER");
        } else System.out.println(GREEN + "YOU WIN!");
    }

    public Attacks attackOptions(Pokemon humanPokemon) {
        System.out.println(GREEN + "TURN OF THE HUMAN!" + RESET);
        System.out.println("PLEASE CHOOSE ATTACK (1-2):");
        System.out.println("1)" + humanPokemon.getAttack1());
        System.out.println("2)" + humanPokemon.getAttack2());
        System.out.println("IF YOU WRITE SMTH OTHER THAN 1 OR 2 WE WILL DO ATTACK 2");
        String attackNumber = myScan.nextLine();
        int choice = 2;
        if (Objects.equals(attackNumber, "1")) {
            choice = 1;
        }

        Attacks tempAttack;
        if (choice == 1) {
            tempAttack = humanPokemon.getAttack1();
        } else {
            tempAttack = humanPokemon.getAttack2();
        }
        return tempAttack;
    }

    public Attacks attackComputer(Pokemon computerPokemon) {
        System.out.println(GREEN + "TURN OF THE COMPUTER!" + RESET);
        int attackNumberComputer = ra.nextInt(2);
        Attacks tempAttack = computerPokemon.getAttack2();
        if (attackNumberComputer == 1) {
            tempAttack = computerPokemon.getAttack1();
        }
        return tempAttack;
    }

}
