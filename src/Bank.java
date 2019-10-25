import java.util.ArrayList;
import java.util.List;

public class Bank extends Deelnemer{

    @Override
    public void speelSpel(List<Kaart> kaartenInSpel) {
        boolean spelBezig = true;

        while(spelBezig){
            if (getTotalePunten() < 17){
                setGetrokkenKaarten(kaartenInSpel.get(0));
                kaartenInSpel.remove(0);
                setTotalePunten(NieuwSpel.berekeningPunten(getGetrokkenKaarten()));
            } else {
                spelBezig = false;
            }
        }
    }


}
