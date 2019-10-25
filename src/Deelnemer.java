import java.util.ArrayList;
import java.util.List;

public abstract class Deelnemer {
    private List<Kaart> getrokkenKaarten = new ArrayList<>();
    private int totalePunten = 0;

    public List<Kaart> getGetrokkenKaarten() {
        return getrokkenKaarten;
    }
    public void setGetrokkenKaarten(Kaart kaart) {
        this.getrokkenKaarten.add(kaart);
    }
    public int getTotalePunten() {
        return totalePunten;
    }
    public void setTotalePunten(int totalePunten) {
        this.totalePunten = totalePunten;
    }

    public abstract void speelSpel(List<Kaart> kaartenInSpel);
}
