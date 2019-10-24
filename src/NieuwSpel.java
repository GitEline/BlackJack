import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NieuwSpel {



    public static void zetNieuwSpelOp(){
        List<Kaart> kaartenInSpel = Deck.maakDeck();                        // maak een deck voor een nieuw spel
        List<Kaart> getrokkenKaartenSpeler = new ArrayList<>();                   // maakt een lijst waar de getrokken kaarten in gaan


        System.out.println("De eerste twee kaarten zijn: ");
        System.out.println(kaartenInSpel.get(0) + ", " + kaartenInSpel.get(1));         // toont de eerste twee kaarten op het scherm
        getrokkenKaartenSpeler.add(kaartenInSpel.get(0));                                     // voegt de eerste kaart toe aan de getrokken kaarten stapel
        getrokkenKaartenSpeler.add(kaartenInSpel.get(1));                                     // voegt de tweede kaart toe aan de getrokken kaarten stapel
        kaartenInSpel.remove(0);                                                  // verwijdert de eerste kaart uit de stapel met speelkaarten
        kaartenInSpel.remove(1);                                                  // verwijdert de tweede kaart uit de stapel met speelkaarten
        System.out.println("Totale punten aantal: " + berekeningPunten(getrokkenKaartenSpeler));      // berekening puntenaantal van de eerste twee kaarten

        commandLoop(kaartenInSpel, getrokkenKaartenSpeler);
    }


    public static void commandLoop(List<Kaart> kaartenInSpel, List<Kaart> getrokkenKaartenSpeler){
        Boolean quit = false;
        System.out.println("Kies een kaart [k], pass[p], beëindig deze ronde[s] of quit [q]");
        do {
            Scanner commandReader = new Scanner(System.in);                // maak een nieuwe scanner
            String command = commandReader.nextLine();                     // lees de input uit
            if (command.equals("q")) {                                     // als q wordt ingevoerd door de speler, stopt het spel
                quit = true;
            } else if (command.equals("k")) {
                System.out.println(kaartenInSpel.get(0));
                getrokkenKaartenSpeler.add(kaartenInSpel.get(0));
                kaartenInSpel.remove(0);
                int totalePunten = berekeningPunten(getrokkenKaartenSpeler);
                System.out.println("Totale punten aantal: " + totalePunten);
                int puntenGelijkofMeerDan21 = meerDan21(totalePunten);
                if(puntenGelijkofMeerDan21 == 1) {
                    System.out.println("Helaas, je hebt verloren");
                }else if(puntenGelijkofMeerDan21 == 2) {
                    //laat bank spelen, als die 21 heeft, wint de bank, anders de speler
                } else {
                    continue;
                }
            } else if (command.equals("p")) {
                System.out.println("De getrokken kaarten zijn: " + getrokkenKaartenSpeler);
                System.out.println("Totale punten aantal: " + berekeningPunten(getrokkenKaartenSpeler));
                // laat de bank spelen, bij hoger punten aantal bank, wint bank, bij meer dan 21 punten verliest bank
                Bank.bankSpeelt(kaartenInSpel);
            } else if(command.equals("s")){
                System.out.println("Het totale aantal punten is: ");
            } else {
                System.out.println("Commando incorrect, probeer opnieuw.");
            }
        } while (!quit);
    }


    public static int berekeningPunten(List<Kaart> getrokkenKaartenSpeler){
        int totaalAantalPunten = 0;                 // aantal punten bij de start van het spel (zijn dus geen kaarten getrokken)
        for(Kaart kaart:getrokkenKaartenSpeler){
            int kaartPunten = kaart.getWaarde();     // kaartwaarde wordt opgezocht
            totaalAantalPunten += kaartPunten;       // kaartwaarde wordt opgeteld bij totaal aantal punten
        }
        return totaalAantalPunten;
    }

    public static int meerDan21(int totalePunten){
        if(totalePunten > 21){
            return 1;
        }else if (totalePunten == 21){
            return 2;
        } else{
            return 3;
        }
    }

}
