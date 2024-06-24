import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Pokemon {

    private int number;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private double hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;

    private Attacks attack1;

    public Attacks getAttack1() {
        return attack1;
    }

    public void setAttack1(Attacks attack1) {
        this.attack1 = attack1;
    }

    public Attacks getAttack2() {
        return attack2;
    }

    public void setAttack2(Attacks attack2) {
        this.attack2 = attack2;
    }

    private Attacks attack2;

    public Pokemon(int pokemonID) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        String[] arrOfStr = fileReader.readPokemonWithScanner(pokemonID);

        this.number = Integer.parseInt(arrOfStr[0]);
        this.name = arrOfStr[1];
        this.type1 = arrOfStr[2];
        this.type2 = arrOfStr[3];
        this.total = Integer.parseInt(arrOfStr[4]);
        this.hp = Integer.parseInt(arrOfStr[5]);
        this.attack = Integer.parseInt(arrOfStr[6]);
        this.defense = Integer.parseInt(arrOfStr[7]);
        this.spAttack = Integer.parseInt(arrOfStr[8]);
        this.spDefense = Integer.parseInt(arrOfStr[9]);
        this.speed = Integer.parseInt(arrOfStr[10]);
        this.attack1 = new Attacks();
        this.attack2 = new Attacks();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void PokemonList() {

    }

    //printing out the data of the exact pokemon
    @Override
    public String toString() {

        String typeTwo = "";
        if (!Objects.equals(type2, "")) {
            typeTwo += "/" + type2;
        }

        return "#" + number + " " +
                name + " (" +
                type1 +
                typeTwo + ") HP=" +
                hp + " ";
    }
}
