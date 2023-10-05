package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import decathlon.*;

import heptathlon.*;

public class SelectDiscipline {

	int disciplineSelected;
	InputResult inputResult = new InputResult();
	Scanner sc = new Scanner(System.in);
	Deca100M deca100M = new Deca100M();
	Deca400M deca400M = new Deca400M();
	Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
	Deca1500M deca1500M = new Deca1500M();
	DecaLongJump decaLongJump = new DecaLongJump();
	DecaHighJump highJump = new DecaHighJump();
	DecaDiscusThrow discusThrow = new DecaDiscusThrow();
	DecaShotPut decaShotPut = new DecaShotPut();
	DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
	DecaPoleVault poleVault = new DecaPoleVault();

	Hep200M hep200M = new Hep200M();
	Hep800M hep800M = new Hep800M();
	Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
	HeptHightJump hepHighJump = new HeptHightJump();
	HeptLongJump hepLongJump = new HeptLongJump();
	HeptShotPut hepShotPut = new HeptShotPut();
	HeptJavelinThrow hepJavelinThrow = new HeptJavelinThrow();

	//Receive input	of selection of discipline.

	private final Menu.Category category;

	private final String[] competitors;

	private final List<Score> results;

	//Array of disciplines for Decathlon. Along with how it's measured
	private final String[] decathlonDisciplines = { "100 meters. (Measured in seconds)", "400 meters. (Measured in seconds)",
			"110 meters hurdles. (Measured in seconds)", "1500 meters. (Measured in minutes and seconds)", "Long Jump. (Measured in centimeters)",
			"High Jump. (Measured in centimeters)", "Pole Vault. (Measured in centimeters)", "Discus Throw. (Measured in meters)",
			"Javelin Throw. (Measured in meters)", "Shot Put. (Measured in meters)" };

	//Array of disciplines for Heptathlon. Along with how it's measured
	private final String[] heptathlonDisciplines = { "200m (measured in seconds)", "800m (measured in seconds)",
			"100m Hurdles (measured in seconds)", "High Jump (measured in meters)", "Long Jump (measured in meters)",
			"Javelin Throw (measured in meters)", "Shot Put (measured in meters)" };


	public SelectDiscipline(Menu.Category category, String[] competitors, List<Score> results) {
		this.category = category;
		this.competitors = competitors;
		this.results = results;
	}

	public List<Score> inputSelection() {
		System.out.println("Select discipline.");
		printDisciplines();

		try {
			disciplineSelected = Integer.parseInt(sc.nextLine());

			if (isValidDiscipline(disciplineSelected)) {
				for (String competitor : competitors) {
					System.out.println("Enter result for " + competitor + " in discipline " + getDisciplineName(disciplineSelected) + ":");
					double result = inputResult.enterResult();
					calculateResult(disciplineSelected, result, competitor);
					reinitializeInstances();
				}
				return results;
			} else {
				System.out.println("Invalid discipline selection, please try again.");
				inputSelection();
			}

		} catch (Exception e) {
			System.out.println("Invalid input, try again.");
			System.out.println();
			inputSelection();
		}
		return new ArrayList<>();
	}

	public boolean isValidDiscipline(int disciplineSelected) {
		if (category == Menu.Category.DECATHLON) {
			return disciplineSelected >= 1 && disciplineSelected <= 10;
		} else if (category == Menu.Category.HEPTATHLON) {
			return disciplineSelected >= 1 && disciplineSelected <= 7;
		}
		return false;
	}

	public void calculateResult(int disciplineSelected, double result, String competitor) {
		int points = 0;
		if (category == Menu.Category.DECATHLON) {
			// Handle Decathlon disciplines
			switch (disciplineSelected) {
				case 1 -> {
					deca100M.calculateResult(result);
					points = deca100M.getScore();
				}
				case 2 -> {
					deca400M.calculateResult(result);
					points = deca400M.getScore();
				}
				case 3 -> {
					deca110MHurdles.calculateResult(result);
					points = deca110MHurdles.getScore();
				}
				case 4 -> {
					deca1500M.calculateResult(result);
					points = deca1500M.getScore();
				}
				case 5 -> {
					decaLongJump.calculateResult(result);
					points = decaLongJump.getScore();
				}
				case 6 -> {
					highJump.calculateResult(result);
					points = highJump.getScore();
				}
				case 7 -> {
					poleVault.calculateResult(result);
					points = poleVault.getScore();
				}
				case 8 -> {
					discusThrow.calculateResult(result);
					points = discusThrow.getScore();
				}
				case 9 -> {
					decaShotPut.calculateResult(result);
					points = decaShotPut.getScore();
				}
				case 10 -> {
					decaJavelinThrow.calculateResult(result);
					points = decaJavelinThrow.getScore();
				}
				default -> {
					System.out.println("Invalid discipline selection, please try again.");
					inputSelection();
				}
			}
		} else if (category == Menu.Category.HEPTATHLON) {
			// Handle Heptathlon disciplines
			switch (disciplineSelected) {
				case 1 -> {
					hep200M.calculateResult(result);
					points = hep200M.getScore();
				}
				case 2 -> {
					hep800M.calculateResult(result);
					points = hep800M.getScore();
				}
				case 3 -> {
					hep100MHurdles.calculateResult(result);
					points = hep100MHurdles.getScore();
				}
				case 4 -> {
					hepHighJump.calculateResult(result);
					points = hepHighJump.getScore();
				}
				case 5 -> {
					hepLongJump.calculateResult(result);
					points = hepLongJump.getScore();
				}
				case 6 -> {
					hepShotPut.calculateResult(result);
					points = hepShotPut.getScore();
				}
				case 7 -> {
					hepJavelinThrow.calculateResult(result);
					points = hepJavelinThrow.getScore();
				}
				default -> {
					System.out.println("Invalid discipline selection, please try again.");
					inputSelection();
				}
			}
		}
		Score score = new Score(competitor, getDisciplineName(disciplineSelected), points);
		results.add(score);
	}

	// Needs more stuff.
	public void printDisciplines() {
		if (category == Menu.Category.DECATHLON) {
			printDecaDisciplines();
		} else if (category == Menu.Category.HEPTATHLON) {
			printHepDisciplines();
		}
	}

	public void printDecaDisciplines() {
		System.out.println("1.\tDecathlon 100 meters.\t\t\t(Measured in seconds)");
		System.out.println("2.\tDecathlon 400 meters.\t\t\t(Measured in seconds)");
		System.out.println("3.\tDecathlon 110 meters hurdles.\t(Measured in seconds)");
		System.out.println("4.\tDecathlon 1500 meters.\t\t\t(Measured in minutes and seconds)");
		System.out.println("5.\tDecathlon Long Jump.\t\t\t(Measured in centimeters)");
		System.out.println("6.\tDecathlon High Jump.\t\t\t(Measured in centimeters)");
		System.out.println("7.\tDecathlon Pole Vault.\t\t\t(Measured in centimeters)");
		System.out.println("8.\tDecathlon Discus Throw.\t\t\t(Measured in meters)");
		System.out.println("9.\tDecathlon Javelin Throw.\t\t(Measured in meters)");
		System.out.println("10.\tDecathlon Shot Put.\t\t\t\t(Measured in meters)");
	}

	public void printHepDisciplines() {
		System.out.println("1. Heptathlon 200 meters.");
		System.out.println("2. Heptathlon 800 meters.");
		System.out.println("3. Heptathlon 100 meters hurdles.");
		System.out.println("4. Heptathlon High Jump.");
		System.out.println("5. Heptathlon Long Jump.");
		System.out.println("6. Heptathlon Shot Put.");
		System.out.println("7. Heptathlon Javelin Throw.");
	}

	public String getDisciplineName(int disciplineSelected) {
		return switch (category) {
			case DECATHLON -> this.decathlonDisciplines[disciplineSelected - 1];
			case HEPTATHLON -> this.heptathlonDisciplines[disciplineSelected - 1];
		};
	}

	private void reinitializeInstances() {
		// Reinitialize instances
		deca100M = new Deca100M();
		deca400M = new Deca400M();
		deca110MHurdles = new Deca110MHurdles();
		deca1500M = new Deca1500M();
		decaLongJump = new DecaLongJump();
		highJump = new DecaHighJump();
		discusThrow = new DecaDiscusThrow();
		decaShotPut = new DecaShotPut();
		decaJavelinThrow = new DecaJavelinThrow();
		poleVault = new DecaPoleVault();
		hep200M = new Hep200M();
		hep800M = new Hep800M();
		hep100MHurdles = new Hep100MHurdles();
		hepHighJump = new HeptHightJump();
		hepLongJump = new HeptLongJump();
		hepShotPut = new HeptShotPut();
		hepJavelinThrow = new HeptJavelinThrow();
	}
}