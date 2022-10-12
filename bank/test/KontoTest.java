package de.hs_mannheim.informatik.bank.test;

import de.hs_mannheim.informatik.bank.domain.Konto;
import de.hs_mannheim.informatik.bank.facade.Banksystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KontoTest {

    @Test
    void tausendEuroHinzufügen() {
        Konto testKonto = new Konto("Hans");
        testKonto.addGuthaben(1000);
        assertEquals(1000, testKonto.getGuthaben());
    }

    @Test
    void zweiMalTausendEuroHinzufügen() {
        Konto testKonto = new Konto("Hans");
        testKonto.addGuthaben(1000);
        testKonto.addGuthaben(1000);
        assertEquals(2000, testKonto.getGuthaben());
    }

    @Test
    void guthabenGetterTest() {
        Konto testKonto = new Konto("test");
        assertEquals(testKonto.getGuthaben(), 0);
    }
}
