package de.hs_mannheim.informatik.bank.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import de.hs_mannheim.informatik.bank.domain.Konto;
import de.hs_mannheim.informatik.bank.facade.Banksystem;
import de.hs_mannheim.informatik.bank.domain.Bank;

public class UI {
	private Banksystem bs;
	Scanner sc = new Scanner(System.in);

	public UI(Banksystem bs) {
		this.bs = bs;
		hauptmenü();
	}

	private void hauptmenü() {
		System.out.println("Willkommen bei der " + bs.getBankname() + "!");

		mainloop: 
			while (true) {
				System.out.println();
				System.out.println("--------");
				System.out.println("Hauptmenü");
				System.out.println("1 -> Konten anzeigen");
				System.out.println("2 -> Konto anlegen");
				System.out.println("3 -> Geld einzahlen");
				System.out.println("4 -> Guthaben");
				System.out.println("9 -> Beenden");
				System.out.println();

				System.out.print("> ");

				int input = 0;
				try {
					input = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println();

				switch(input) {
					case 1 -> kontenAnzeigen();
					case 2 -> kontoAnlegen();
					case 3 -> kontoAufladen();
					case 4 -> guthabenAusgeben();
					case 9 -> {
						break mainloop;
					}
				}
			}

		System.out.println("Auf Wiedersehen!");

	} // hauptmenü

	private void guthabenAusgeben() {
		Konto konto = selectKonto();

		System.out.println("\nIhr aktuelles Guthaben ist: ");
		System.out.print(konto.getGuthaben());
		System.out.println("€");
	}

	private void kontoAufladen() {
		Konto konto = selectKonto();

		System.out.println("Wieviel möchten sie aufladen? (nur ganze Beträge)!");
		System.out.print("> ");

		int input = 0;
		try {
			input = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Bitte geben Sie einen gültigen Betrag ein!");
			kontoAufladen();

		}
		konto.addGuthaben(input);
		System.out.println("\n" + input + "€ wurden aufgeladen!");
		System.out.println("Ihr aktueller Kontostand beträgt " + konto.getGuthaben() + "€");
		System.out.println("Drücken Sie ENTER um zum Hauptmenu zurück zu kehren!");
		sc.nextLine();
	}

	private Konto selectKonto() {
		System.out.println("Bitte geben Sie die Kontonummer ihres Kontos an: ");

//		kontenAnzeigen();

		System.out.print("\n> ");
		int input = 0;
		try {
			input = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
//			System.out.println("An Error occured: " + e);
		};


		if (bs.getKonto(input) == null) {
			selectKonto();
		}

		return bs.getKonto(input);
	}

	private void kontenAnzeigen() {		
		String[] konten = bs.getKontenliste();
		if (konten.length > 0) {
			System.out.println("Folgende Konten sind aktuell verfügbar:");
			int i = 1;
			for (String s : konten) {
				System.out.println(i + ": " + s);
				i++;
			}
		} else {
			System.out.println("Bisher keine Konten angelegt.");
		}
	}

	private void kontoAnlegen() {
		System.out.println("Bitte den Namen des Kontoinhabers angeben: ");
		String name = sc.nextLine();

		int kontonummer = bs.kontoAnlegen(name);
		System.out.println("Konto mit der Nummer " + kontonummer + " neu angelegt.");
	}

}
