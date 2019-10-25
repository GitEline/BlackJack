import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NieuwSpel {
    
    public static void zetNieuwSpelOp(){
        // vraag hoeveel spelers en loop door nieuw speler voor elke nieuwe speler
        // vraag met hoeveel decks er gespeeld moet worden en maak meerdere decks aan

//        boolean deckInvoerGedaan = false;
//        int aantalDecksInt = 0;
//        do {
//            boolean deckInvoerIncorrect = true;
//            String aantalDecks = null;
//            do {
//            System.out.println("Met hoeveel decks wil je spelen? [max. 4]");
//            Scanner scanner = new Scanner(System.in);                // maak een nieuwe scanner
//            aantalDecks = scanner.nextLine();
//                try {
//                    Integer.parseInt(aantalDecks);
//                    deckInvoerIncorrect = false;
//                } catch (Exception e) {
//                    System.out.println("Onjuiste input, vul een getal in voor het aantal decks");
//                }
//            } while (deckInvoerIncorrect);
//
//            if (Integer.parseInt(aantalDecks) > 4) {
//                System.out.println("Er kunnen maximaal 4 decks gebruikt worden");
//            } else if(Integer.parseInt(aantalDecks) < 1){
//                System.out.println("Er moet minimaal 1 deck gebruikt worden");
//            }else {
//                aantalDecksInt = Integer.parseInt(aantalDecks);
//                System.out.println(aantalDecksInt);
//                deckInvoerGedaan = true;
//            }
//        }while(!deckInvoerGedaan);
//
//        List<Kaart> kaartenInSpel = null;         //deze variabele koppelen aan de loop hieronder
//
//        for (int i = 0; i < aantalDecksInt; i++){ // deze loop werkt nog niet
//            kaartenInSpel = Deck.maakDeck();
//        }
//        System.out.println(kaartenInSpel);
        //kaart voor bank tonen


        List<Kaart> kaartenInSpel = Deck.maakDeck();                        // maak een deck voor een nieuw spel

        Speler speler1 = new Speler();
        speler1.speelSpel(kaartenInSpel);
    }


    public static int berekeningPunten(List<Kaart> getrokkenKaarten){
        int totaalAantalPunten = 0;                  // aantal punten bij de start van het spel (zijn dus geen kaarten getrokken)
        for(Kaart kaart:getrokkenKaarten){
            int kaartPunten = kaart.getWaarde();     // kaartwaarde wordt opgezocht
            totaalAantalPunten += kaartPunten;       // kaartwaarde wordt opgeteld bij totaal aantal punten


//functie voor checken op aas aanroepen, methode al gemaakt onderaan deze klasse



//            if(totaalAantalPunten > 21){
//                if(getrokkenKaarten.contains("AAS")){
//
//                    //stel vraag hoeveel aas kaarten je wilt aanpassen naar cijfer 1, en bereken opnieuw, loop opnieuw de vraag wat de volgende zet wordt als kleiner dan 21
//                }
//            }
        }
        return totaalAantalPunten;
    }



    public static void bepalenWieWint(int puntenSpeler, int puntenBank, Bank bank){
        System.out.println("Kaarten van de bank: " + bank.getGetrokkenKaarten() + " Totale punten van de bank: " + bank.getTotalePunten());
        if(puntenSpeler <= 21 && puntenSpeler > bank.getTotalePunten()){
            System.out.println("Gefeliciteerd, je hebt het spel gewonnen");
        }else if(bank.getTotalePunten() > 21) {
            System.out.println("Gefeliciteerd, je hebt het spel gewonnen");
        } else if (puntenSpeler == bank.getTotalePunten()){
            System.out.println("Gelijkspel");
        }else{
            System.out.println("Helaas, je hebt het spel verloren");
        }
    }



    public static void checkenOpAasKaarten(){

    }




}
