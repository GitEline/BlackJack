public enum KaartTypen {
    TWEE(2),
    DRIE(3),
    VIER(4),
    VIJF(5),
    ZES(6),
    ZEVEN(7),
    ACHT(8),
    NEGEN(9),
    TIEN(10),
    AAS(11),
    VROUW(10),
    HEER(10),
    BOER(10);

    private int value;

    public int getValue() {
        return value;
    }

    private KaartTypen(int value){
        this.value = value;
    }



}
