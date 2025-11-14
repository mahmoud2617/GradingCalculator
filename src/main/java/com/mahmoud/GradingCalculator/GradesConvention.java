package com.mahmoud.GradingCalculator;

public class GradesConvention {
    private final String[] letters = {"A+", "A", "A-",
                        "B+", "B", "B-",
                        "C+", "C", "C-",
                        "D+", "D", "D-", "F"};

    private final String[] percentage = {"96|100", "92|96", "88|92",
                           "84|88", "80|84", "76|80",
                           "72|76", "68|72", "64|68",
                           "60|64", "55|60", "50|55", "0|50"};

    private final float[] GPA = {4.0f, 3.7f, 3.4f,
                         3.2f, 3.0f, 2.8f,
                         2.6f, 2.4f, 2.2f,
                         2.0f, 1.5f, 1.0f, 0.0f};

    // From Percentage or GPA
    public String toLetter(int from, String grade) {
        if (from == 2) {
            int indexOfDelimiter;
            int start, end;
            float gradeAsFloat;

            indexOfDelimiter = grade.indexOf("%");

            try {
                if (indexOfDelimiter == 0)
                    gradeAsFloat = Float.parseFloat(grade.substring(1));
                else if (indexOfDelimiter > 0)
                    gradeAsFloat = Float.parseFloat(grade.substring(0, indexOfDelimiter));
                else
                    gradeAsFloat = Float.parseFloat(grade);
            } catch (Exception e) {
                return "";
            }

            for (int i = 0; i < letters.length; i++) {
                indexOfDelimiter = percentage[i].indexOf("|");
                start = Integer.parseInt(percentage[i].substring(0, indexOfDelimiter));
                end = Integer.parseInt(percentage[i].substring(indexOfDelimiter + 1));

                if (gradeAsFloat >= start && gradeAsFloat <= end)
                    return letters[i];
            }
        } else {
            float gradeAsFloat = Float.parseFloat(grade);

            if (GPA[0] == gradeAsFloat)
                return letters[0];

            for (int i = letters.length - 1; i >= 0; i--) {
                if (GPA[i] > gradeAsFloat)
                    return letters[i + 1];
            }
        }

        return "";
    }

    // From Letters or GPA
    public String toPercentage(int from, String grade) {
        if (from == 1) {
            for (int i = 0; i < percentage.length; i++) {
                if (grade.equals(letters[i]))
                    return percentage[i].replace("|", "% : ") + "%";
            }
        } else {
            float gradeAsFloat = Float.parseFloat(grade);

            if (GPA[0] == gradeAsFloat)
                return percentage[0].replace("|", "% : ") + "%";

            for (int i = percentage.length - 1; i >= 0; i--) {
                if (GPA[i] > gradeAsFloat)
                    return percentage[i + 1].replace("|", "% : ") + "%";
            }
        }

        return "";
    }

    // From Letters or Percentage
    public String toGPA(int from, String grade) {
        if (from == 1) {
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].equalsIgnoreCase(grade))
                    return String.valueOf(GPA[i]);
            }
        } else {
            int indexOfDelimiter = grade.indexOf("%");
            int start, end;
            float gradeAsFloat;

            try {
                if (indexOfDelimiter == 0)
                    gradeAsFloat = Float.parseFloat(grade.substring(1));
                else if (indexOfDelimiter > 0)
                    gradeAsFloat = Float.parseFloat(grade.substring(0, indexOfDelimiter));
                else
                    gradeAsFloat = Float.parseFloat(grade);
            } catch (Exception e) {
                return "";
            }

            for (int i = 0; i < percentage.length; i++) {
                indexOfDelimiter = percentage[i].indexOf("|");
                start = Integer.parseInt(percentage[i].substring(0, indexOfDelimiter));
                end = Integer.parseInt(percentage[i].substring(indexOfDelimiter + 1));

                if (gradeAsFloat >= start && gradeAsFloat <= end)
                    return String.valueOf(GPA[i]);
            }
        }

        return "";
    }
}