import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Attacks {

    private int number;

    private String name;
    private String effect;

    private String type;

    //kind is either physical or special, if physical then equals 0, if special then equals 1
    private int kind;

    private int power;

    private int accuracy;

    private int pp;

    private static ArrayList attackList = new ArrayList();

    public Attacks() throws FileNotFoundException {

        Random ra = new Random();

        int attackNumber;
        do {
            attackNumber = 1 + ra.nextInt(218);
        } while (attackList.contains(attackNumber));


        FileReader fileReader = new FileReader();
        String[] arrOfStr = fileReader.readAttacksWithScanner(attackNumber);

        this.number = Integer.parseInt(arrOfStr[0]);
        this.name = arrOfStr[1];
        this.effect = arrOfStr[2];
        this.type = arrOfStr[3];

        //explanation in variables
        if (Objects.equals(arrOfStr[4], "Physical")) {
            this.kind = 0;
        } else {
            this.kind = 1;
        }


        this.power = Integer.parseInt(arrOfStr[5]);

        String numbersOnly = arrOfStr[6].replaceAll("[^0-9]", "");

        this.accuracy = Integer.parseInt(numbersOnly);

        this.pp = Integer.parseInt(arrOfStr[7]);

        attackList.add(attackNumber);

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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    @Override
    public String toString() {

        String tempKind = "Physical";
        if (kind == 0) tempKind = "Special";

        return name + " " + power + " " + tempKind;

    }
}
