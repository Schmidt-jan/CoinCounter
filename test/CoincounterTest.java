import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CoincounterTest {

    @Test(expected = AssertionError.class)
    public void euroToCents() {
        assertEquals(200, Coincounter.euroToCents("2.00"));
        assertEquals(2, Coincounter.euroToCents("2.00"));
        assertEquals(0, Coincounter.euroToCents("0.00"));
        assertEquals(25, Coincounter.euroToCents("0.25"));
        Coincounter.euroToCents("0");
        Coincounter.euroToCents("0.0");
        Coincounter.euroToCents("0,00");
        Coincounter.euroToCents("010.00");
    }

    @Test(expected = AssertionError.class)
    public void calcCoins() {
        List<CoinVal> list = Coincounter.calcCoins(199);

        assertEquals(100, list.get(0).getVal());
        assertEquals(1, list.get(0).getNumberOf());
        assertEquals(50, list.get(1).getVal());
        assertEquals(1, list.get(1).getNumberOf());
        assertEquals(20, list.get(2).getVal());
        assertEquals(2, list.get(2).getNumberOf());
        assertEquals(10, list.get(2).getVal());
        assertEquals(1, list.get(2).getNumberOf());
        assertEquals(5, list.get(3).getVal());
        assertEquals(1, list.get(3).getNumberOf());
        assertEquals(2, list.get(4).getVal());
        assertEquals(2, list.get(4).getNumberOf());

        Coincounter.calcCoins(0);

    }
}