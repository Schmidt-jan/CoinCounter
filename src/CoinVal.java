public class CoinVal {
    private int val, numberOf;

    CoinVal(int value, int numberOf) {
        if (value <= 0 || numberOf <= 0)
            throw new IllegalArgumentException("value and number need to be > 0");
        this.val = value;
        this.numberOf = numberOf;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        if (val <= 0)
            throw new IllegalArgumentException("value needs to be > 0");
        this.val = val;
    }

    public int getNumberOf() {
        return this.numberOf;
    }

    public void setNumberOf(int numberOf) {
        if (numberOf <= 0)
            throw new IllegalArgumentException("numberOf needs to be > 0");
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
