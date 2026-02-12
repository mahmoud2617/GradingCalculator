package com.mahmoud.gradesConversion.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GradingScale {
    private String letter;
    private double gpa;
    private int percentageMinValue;
    private int percentageMaxValue;
}
