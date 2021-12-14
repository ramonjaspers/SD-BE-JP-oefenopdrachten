package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Alex");
//        second alex wont be added since it already exists
        laResistanceMembers = addMembers(laResistanceMembers, "Alex");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");

//        show all the encrypted data
        laResistanceMembers = encryptData(laResistanceMembers);
        for (String member : laResistanceMembers) {
            System.out.println(member);
        }
//show all the unencrypted data
        laResistanceMembers = decryptData(laResistanceMembers);
        for (String member : laResistanceMembers) {
            System.out.println(member);
        }

        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        ----------------------------------------------------
        NOTE VAN STUDENT RAMON: ik weiger om A = 101 te doen, dit zou betekenen dat ik bij 1 begin te tellen en dus bij elke char een + 1 zou moeten doen
        als ik dit doe zou ik ook -1 moeten doen bij de decrypt wat eigenlijk al snel magic numbers worden of ik moet een onnodige letterStart = 1 maken oid...
        geen onnodige shit doen. 😛 Best regards, ramon
        -----------------------------------------------------
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */

        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */
    }

    private static List<String> addMembers(List<String> members, String name) {
        if (!members.contains(name)) {
            members.add(name);
        }
        return members;
    }

    private static List<String> encryptData(List<String> members) {
        List<String> enctryptedData = new ArrayList<>();
        for (String member : members) {
            StringBuilder encryptedMember = new StringBuilder();
            for (int i = 0; i < member.length(); i++) {
                char ch;
                if (enctryptedData.size() % 2 == 0) {
                    ch = member.charAt(member.length() - (i + 1));
                } else {
                    ch = member.charAt(i);
                }
                int letterNumber = Character.toLowerCase(ch) - 'a';
                if (Character.isUpperCase(ch)) {
                    letterNumber += 100;
                }
                encryptedMember.append(letterNumber).append(i == member.length() - 1 ? "" : "-");
            }
            enctryptedData.add(encryptedMember.toString());
        }
        return enctryptedData;
    }

    private static List<String> decryptData(List<String> members) {
        List<String> enctryptedData = new ArrayList<>();
        for (String member : members) {
            StringBuilder decryptedMember = new StringBuilder();
            String[] encryptedLetters = member.split("-");
            for (int i = 0; i < encryptedLetters.length; i++) {
                String letter = "";
                int number;
                if (enctryptedData.size() % 2 == 0) {
                    number = Integer.parseInt(encryptedLetters[encryptedLetters.length - (i + 1)]);
                } else {
                    number = Integer.parseInt(encryptedLetters[i]);
                }
                if (number >= 100) {
                    number = number - 100;
                    char c = (char) (number + 'A');
                    letter = Character.toString(c).toUpperCase();
                } else {
                    char c = (char) (number + 'A');
                    letter = Character.toString(c).toLowerCase();
                }
                decryptedMember.append(letter);
            }
            enctryptedData.add(decryptedMember.toString());
        }
        return enctryptedData;
    }
}
