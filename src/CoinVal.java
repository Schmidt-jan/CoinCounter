public class CoinVal {
    private int val, numberOf;


    CoinVal(int value, int numberOf) {
        this.val = value;
        this.numberOf = numberOf;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    @Override
    public String toString() {
        String unity = "Euro";
        if (val >= 100)
            return "" + numberOf + "x " + val  / 100 + " Euro";
        else return "" + numberOf + "x " + val + " Cent";
    }
}
