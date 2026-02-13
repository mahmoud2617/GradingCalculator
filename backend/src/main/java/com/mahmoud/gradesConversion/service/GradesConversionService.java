package com.mahmoud.gradesConversion.service;

import com.mahmoud.gradesConversion.dto.RequestDto;
import com.mahmoud.gradesConversion.dto.ResponseDto;
import com.mahmoud.gradesConversion.exception.InvalidRequestException;
import com.mahmoud.gradesConversion.util.GradeType;
import com.mahmoud.gradesConversion.util.GradingScale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesConversionService {
     private static final List<GradingScale> GRADES = List.of(
        new GradingScale("A+", 4.0f, 96, 100),
        new GradingScale("A", 3.7f, 92, 96),
        new GradingScale("A-", 3.4f, 88, 92),

        new GradingScale("B+", 3.2f, 84, 88),
        new GradingScale("B", 3.0f, 80, 84),
        new GradingScale("B-", 2.8f, 76, 80),

        new GradingScale("C+", 2.6f, 72, 76),
        new GradingScale("C", 2.4f, 68, 72),
        new GradingScale("C-", 2.2f, 64, 68),

        new GradingScale("D+", 2.0f, 60, 64),
        new GradingScale("D", 1.5f, 55, 60),
        new GradingScale("D-", 1.0f, 50, 55),

        new GradingScale("F", 0.0f, 0, 50)
     );

    public ResponseDto convert(RequestDto request) {
        String value = request.getValue();
        String from = request.getFrom();
        String to = request.getTo();
        String fromTextContent = (request.getFromTextContent() != null)? request.getFromTextContent() : from;
        String grade;

        try {
            GradeType gradeTypeFrom = GradeType.valueOf(from);
            GradeType gradeTypeTo = GradeType.valueOf(to);

             grade = getGrade(gradeTypeFrom, gradeTypeTo, value);

            if (grade == null) {
                throw new InvalidRequestException("Invalid " + fromTextContent + " value.");
            }

            return new ResponseDto(grade);

        } catch (InvalidRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidRequestException("Invalid JSON data");
        }
    }

    private String getGrade(
            GradeType gradeTypeFrom,
            GradeType gradeTypeTo,
            String value
    ) {
        GradingScale gradingScale = null;

        switch (gradeTypeFrom) {
            case LETTER -> {
                gradingScale = GRADES.stream()
                        .filter(g ->
                                g.getLetter().equalsIgnoreCase(value)
                        )
                        .findFirst()
                        .orElse(null);
            }

            case GPA -> {
                if (!isParsableToDouble(value))
                    return null;

                double gpaValue = Double.parseDouble(value);

                gradingScale = GRADES.stream()
                        .filter(g ->
                            gpaValue >= g.getGpa()
                            && gpaValue <= GRADES.getFirst().getGpa()
                        )
                        .findFirst()
                        .orElse(null);
            }

            case PERCENTAGE -> {
                if (!isParsableToDouble(value))
                    return null;

                double percentageValue = Double.parseDouble(value);

                gradingScale = GRADES.stream()
                        .filter(g ->
                                percentageValue >= g.getPercentageMinValue()
                                        && percentageValue <= g.getPercentageMaxValue()
                        )
                        .findFirst()
                        .orElse(null);
            }
        }

        if (gradingScale == null) {
            return null;
        }

        return switch (gradeTypeTo) {
            case LETTER ->
                    gradingScale.getLetter();
            case GPA ->
                    String.format("%.1f" ,gradingScale.getGpa());
            case PERCENTAGE ->
                    gradingScale.getPercentageMinValue()
                    + "% - "
                    + gradingScale.getPercentageMaxValue()
                    + "%";
        };
    }

    private boolean isParsableToDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
