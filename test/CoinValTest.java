import org.junit.Test;

import static org.junit.Assert.*;

public class CoinValTest {

    CoinVal val = new CoinVal(200, 5);

    @Test(expected = IllegalArgumentException.class)
    public void CoinVal() {
        CoinVal val2 = new CoinVal(5, 0);
    }

    @Test
    public void getVal() {
        assertEquals(200, val.getVal());
    }


    @Test(expected = IllegalArgumentException.class)
    public void setVal() {
        val.setVal(500);
        assertEquals(500, val.getVal());
        val.setVal(0);
    }


    @Test
    public void getNumberOf() {
        assertEquals(5, val.getNumberOf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNumberOf() {
        val.setNumberOf(1);
        assertEquals(1, val.getNumberOf());
        val.setNumberOf(0);
    }

    @Test
    public void testToString() {
        assertEquals("5x 2 Euro", val.toString());
        CoinVal val2 = new CoinVal(5, 20);
        assertEquals("20x 5 Cent", val2.toString());
    }
}