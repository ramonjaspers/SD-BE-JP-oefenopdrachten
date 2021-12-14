package nl.novi.opdrachten.beslissingsstructuren;

import java.util.Scanner;

public class Geslacht {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Wat is uw geslacht?");
        String geslacht = userInputScanner.nextLine();

        if (geslacht.equalsIgnoreCase("man")) {
            System.out.println("Dag meneer.");
        } else if (geslacht.equalsIgnoreCase("mevrouw.")) {
            System.out.println("Dag mevrouw.");
        } else {
            System.out.println("Dag persoon.");
        }
        /*
        Hier boven heeft de gebruiker zijn geslacht ingevoerd. Print met behulp van een beslissingsstructuur (if/else)
        de volgende berichten:
        Wanneer de gebruiker een 'man' is: "Dag meneer."
        Wanneer de gebruiker een 'vrouw' is": "Dag mevrouw."
        In alle andere gevallen: "Dag persoon."

        Bonus: Lukt het je om de code zo te maken dat hoofdletters genegeerd worden?
         */

    }

}
