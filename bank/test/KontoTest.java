package de.hs_mannheim.informatik.bank.test;

import de.hs_mannheim.informatik.bank.domain.Konto;
import de.hs_mannheim.informatik.bank.facade.Banksystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KontoTest {
    @Test
    void guthabenTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontonummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontonummer);

        testKonto.addGuthaben(1000);
        assertEquals(testKonto.getGuthaben(), 1000);
    }
}
