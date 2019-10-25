import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    public static List<Kaart> maakDeck (){                              // methode voor het aanmaken van een deck
        List<Kaart> kaartenInSpel = new ArrayList<>();                  // aanmaken van een lijst om alle kaarten in te bewaren
        for (KaartKleuren kaartKleur : KaartKleuren.values()) {         // twee foreach loops om alle kaartkleuren met de kaarttypen te combineren
            for (KaartTypen kaartType : KaartTypen.values()) {
                Kaart kaart = new Kaart(kaartKleur, kaartType);         // nieuwe kaarten worden gelijk aangemaakt
                kaartenInSpel.add(kaart);                               // nieuw aangemaakte kaart wordt gelijk aan de lijst toegevoegd
            }
        }
//        System.out.println(kaartenInSpel);                            // de lijst met kaarten vóór de shuffle
        Collections.shuffle(kaartenInSpel);                             // shuffle deck
//        System.out.println(kaartenInSpel);                            // de lijst met kaarten na het shufflen
        return kaartenInSpel;
    }



}
