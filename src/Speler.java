import java.util.List;
import java.util.Scanner;

public class Speler extends Deelnemer {

    @Override
    public void speelSpel(List<Kaart> kaartenInSpel) {
        Boolean quit = false;


        System.out.println("De eerste twee kaarten zijn: ");
        System.out.println(kaartenInSpel.get(0) + ", " + kaartenInSpel.get(1));         // toont de eerste twee kaarten op het scherm
        setGetrokkenKaarten(kaartenInSpel.get(0));                                      // voegt de eerste kaart toe aan de getrokken kaarten stapel
        setGetrokkenKaarten(kaartenInSpel.get(1));                                      // voegt de tweede kaart toe aan de getrokken kaarten stapel
        kaartenInSpel.remove(0);                                                  // verwijdert de eerste kaart uit de stapel met speelkaarten
        kaartenInSpel.remove(0);                                                  // verwijdert de tweede kaart uit de stapel met speelkaarten
        System.out.println("Totale punten aantal: " + NieuwSpel.berekeningPunten(getGetrokkenKaarten()));      // berekening puntenaantal van de eerste twee kaarten


        System.out.println("Kies een kaart [k], pas[p] of quit [q]");
        Scanner commandReader = new Scanner(System.in);                // maak een nieuwe scanner
        String command = commandReader.nextLine();                     // lees de input uit

        do {
            if (command.equals("q")) {                                     // als q wordt ingevoerd door de speler, stopt het spel
                quit = true;
            } else if (command.equals("k")) {
                System.out.println(kaartenInSpel.get(0));
                setGetrokkenKaarten(kaartenInSpel.get(0));
                kaartenInSpel.remove(0);
                setTotalePunten(NieuwSpel.berekeningPunten(getGetrokkenKaarten()));
                System.out.println("Totale punten aantal: " + getTotalePunten());
                if(getTotalePunten() > 21){
                    System.out.println("Helaas, je hebt meer dan 21 punten, je verliest deze ronde");
                    quit = true;
                } else if(getTotalePunten() == 21){
                    Bank bank = new Bank();
                    bank.speelSpel(kaartenInSpel);
                    NieuwSpel.bepalenWieWint(this.getTotalePunten(), bank.getTotalePunten(), bank);
                    quit = true;
                } else{
                    continue;
                } } else if (command.equals("p")) {
                System.out.println("De getrokken kaarten zijn: " + getGetrokkenKaarten());
                System.out.println("Totale punten aantal: " + NieuwSpel.berekeningPunten(getGetrokkenKaarten()));
                setTotalePunten(NieuwSpel.berekeningPunten(getGetrokkenKaarten()));
                Bank bank = new Bank();
                bank.speelSpel(kaartenInSpel);
                NieuwSpel.bepalenWieWint(this.getTotalePunten(), bank.getTotalePunten(), bank);
                quit = true;
            } else {
                System.out.println("Commando incorrect, probeer opnieuw");
            }
        } while (!quit);
    }
}
