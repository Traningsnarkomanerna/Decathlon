package common;

import excel.ExcelPrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    // Implement a menu system that allows first asks the user for a category then gives a few options for what to do next.
    // The menu should be able to handle the following:
    // 1. Add competitor / Competitors
    // 2. Add result / Results
    // 3. Show results
    // 4. Exit
    // The menu should be able to handle invalid input and should not exit unless the user chooses to.

    enum Category {
        DECATHLON, HEPTATHLON
    }

    Scanner sc = new Scanner(System.in);

    String[] competitors;

    private List<Score> results = new ArrayList<>();

    public Category selectCategory() {
        boolean active = true;
        Category category = null;
        while (active) {
            System.out.println("Please select a category:\n1. Decathlon\n2. Heptathlon");
            int input = 0;
            if (!sc.hasNextInt()) {
                sc.next();
            } else {
                input = sc.nextInt();
            }

            if (input == 1) {
                category = Category.DECATHLON;
                active = false;
            } else if (input == 2) {
                category = Category.HEPTATHLON;
                active = false;
            } else {
                System.out.println("Please select a valid category.");
            }
        }
        return category;
    }

    public void showResults() {
        // Print table of results
        // Header
        System.out.println("Competitor\tDiscipline\tResult");
        for (Score score : results) {
            System.out.println(score.getCompetitorName() + "\t" + score.getDiscipline() + "\t" + score.getResult());
        }
    }

    public void menu() {
        boolean active = true;
        Category category = selectCategory();
        clearScreen();
        while (active) {
            // Print out the menu alternatives which are. Add competitor, add result, show results and exit.
            System.out.println("Please select an option:\n1. Add competitors\n2. Add results\n3. Show results\n4. Write results\n5. Exit");
            int input = 0;
            if (!sc.hasNextInt()) {
                sc.next();
            } else {
                input = sc.nextInt();
            }
            switch (input) {
                case 1 -> {
                    System.out.println("How many competitors would you like to add?");
                    while (!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("Please enter a valid number.");
                    }
                    int numberOfCompetitors = sc.nextInt();
                    competitors = new String[numberOfCompetitors];
                    for (int i = 0; i < numberOfCompetitors; i++) {
                        InputName inputName = new InputName();
                        competitors[i] = inputName.addCompetitor();
                    }
                }
                case 2 -> {
                    SelectDiscipline selectDiscipline = new SelectDiscipline(category, competitors, results);
                    results = selectDiscipline.inputSelection();
                }
                case 3 -> showResults();
                case 4 -> {
                    ExcelPrinter excelPrinter = null;
                    try {
                        excelPrinter = new ExcelPrinter(sc);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    //clear the scanner buffer
                    sc.nextLine();

                    excelPrinter.writeResults(results);
                }
                case 5 -> active = false;
                default -> System.out.println("Please select a valid option.");
            }
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
