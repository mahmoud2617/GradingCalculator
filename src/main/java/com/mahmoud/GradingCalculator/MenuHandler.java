package com.mahmoud.GradingCalculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuHandler {
    private static final String[] gradesType = {"Letter Grade", "Percent Grade", "GPA"};

    private static final InputHandler inputHandler = new InputHandler();
    private static final GradesConvention gradesConvention = new GradesConvention();


    public void convertFromPrintStatements() {
        System.out.println("Enter the number of the grade type you want to convert from:");

        for (int i = 1; i <= gradesType.length; i++) {
            System.out.println(i + ". " + gradesType[i - 1]);
        }
    }

    /**
     * 1-based index.
     */
    // we cannot choose the same grade type twice, so we treat it as ignored index.
    public void convertToPrintStatements(int ignoredIndex) {
        System.out.println("\nEnter the number of the grade type you want to convert to:");

        int n = 1;

        for (int i = 0; i < gradesType.length; i++) {
            if (i + 1 == ignoredIndex) {
                continue;
            }

            System.out.println(n++ + ". " + gradesType[i]);
        }
    }

    public String[] convertToHandler(int from, int to) {
        System.out.print("\nEnter your " + gradesType[from] + ": ");
        String grade = inputHandler.getScanner().nextLine().toUpperCase();

        String res;
        List<String> choice = new ArrayList<>();

        for (int i = 0; i < gradesType.length; i++) {
            if (from != i)
                choice.add(gradesType[i]);
        }

        if (choice.get(to).equals("Letter Grade"))
            res = gradesConvention.toLetter(from + 1, grade);
        else if (choice.get(to).equals("Percent Grade"))
            res = gradesConvention.toPercentage(from + 1, grade);
        else
            res = gradesConvention.toGPA(from + 1, grade);

        return new String[]{choice.get(to), res};
    }
}
