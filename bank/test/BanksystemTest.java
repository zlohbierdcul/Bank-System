package de.hs_mannheim.informatik.bank.test;

import de.hs_mannheim.informatik.bank.domain.Konto;
import de.hs_mannheim.informatik.bank.facade.Banksystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BanksystemTest {

    @Test
    void BanksystemTest() {
        Banksystem bs = new Banksystem("Testbank");
        int kontoNummer = bs.kontoAnlegen("Hans");
        Konto testKonto = bs.getKonto(kontoNummer);

        assertEquals(testKonto.getKontonummer(), kontoNummer);
    }
}
