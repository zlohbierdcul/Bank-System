package de.hs_mannheim.informatik.bank.test;

import de.hs_mannheim.informatik.bank.domain.Konto;
import de.hs_mannheim.informatik.bank.facade.Banksystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BanksystemTest {

    @Test
    void getKontoTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontoNummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontoNummer);

        assertEquals(testKonto.getKontonummer(), kontoNummer);
    }

    @Test
    void eineAufladungTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontonummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontonummer);

        long tempGuthaben = testKonto.getGuthaben();
        testKonto.addGuthaben(1000);
        assertEquals(1000 + tempGuthaben , testKonto.getGuthaben());
    }

    @Test
    void zweiAufladungenTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontonummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontonummer);

        long tempGuthaben = testKonto.getGuthaben();
        testKonto.addGuthaben(1000);
        testKonto.addGuthaben(1000);
        assertEquals(1000 + 1000 + tempGuthaben , testKonto.getGuthaben());
    }

    @Test
    void negativAufladungenTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontonummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontonummer);

        long tempGuthaben = testKonto.getGuthaben();
        testKonto.addGuthaben(- 1000);
        assertEquals(-1000 + tempGuthaben , testKonto.getGuthaben());
    }

}
