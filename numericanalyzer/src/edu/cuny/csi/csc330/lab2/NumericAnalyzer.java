package edu.cuny.csi.csc330.lab2;

/**
 * Course: 330-E001(12968)
 * Filename : NumericAnalyzer.java
 * Purpose: This program analyze numerical data from the array, such as sum, mean, median, variance, min, max, range
 * and standard deviation.
 *
 * @author Suresh Melvin Sigera
 * @date 08/10/2017
 */

import java.util.Arrays;

public class NumericAnalyzer {

    private static double input[], mean, sum, median, variance, min, max, range, std;
    private static int size;

    public NumericAnalyzer(String args[]) {
        input = new double[args.length];
        for (int i = 0; i < args.length; i++)
            input[i] = Integer.parseInt(args[i]);
    }

    private void sortedAscending(double input[]) {
        Arrays.sort(input);
        for (double n : input) {
            System.out.printf("%-8.2f", n);
        }
        System.out.print("\n");
    }

    private int getSize(double input[]) {
        return input.length;
    }

    private double getMax(double input[]) {
        double max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    private double getMin(double input[]) {
        double min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
            }
        }
        return min;
    }

    private double getSum(double input[]) {
        double total = 0;
        for (int i = 0; i < input.length; i++)
            total += input[i];
        return total;
    }

    private double getMean(double input[]) {
        double mean = 0, total = 0;
        for (int i = 0; i < input.length; i++) {
            total = total + input[i];
        }
        return mean = total / input.length;
    }

    private double getMedian(double input[]) {
        Arrays.sort(input);
        double median = 0;
        double pos1 = Math.floor((input.length - 1.0) / 2.0);
        double pos2 = Math.ceil((input.length - 1.0) / 2.0);
        if (pos1 == pos2) {
            median = input[(int) pos1];
        } else {
            median = (input[(int) pos1] + input[(int) pos2]) / 2.0;
        }
        return median;
    }

    public double getRange(double input[]) {
        return getMax(input) - getMin(input);
    }

    private double getVariance(double inputs[]) {
        double variance = 0;

        for (int i = 0; i < inputs.length; ++i) {
            variance += (inputs[i] - getMean(inputs)) * (inputs[i] - getMean(inputs));
        }
        variance /= inputs.length;
        return variance;
    }

    private double getStd(double inputs[]) {
        return Math.sqrt(getVariance(inputs));
    }


    private void calculate() {
        sum = getSum(input);
        size = getSize(input);
        max = getMax(input);
        min = getMin(input);
        mean = getMean(input);
        median = getMedian(input);
        range = getRange(input);
        variance = getVariance(input);
        std = getStd(input);
    }

    private void display() {
        sortedAscending(input);
        //System.out.printf("Size:%20d\nMedian:%20.2f*%n", size, median);
        System.out.printf("Size:%38d\n", size);
        System.out.printf("Min:%45.2f\n", min);
        System.out.printf("Max:%45.2f\n", max);
        System.out.printf("Range%45.2f:\n", range);
        System.out.printf("Sum:%45.2f\n", sum);
        System.out.printf("Mean:%45.2f\n", mean);
        System.out.printf("Median:%45.2f\n", median);
        System.out.printf("Variance:%45.2f\n", variance);
        System.out.printf("Standard Deviation:%45.2f\n", std);
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.print("Please enter some arguments");
            System.exit(1);
        }

        NumericAnalyzer analyzer = new NumericAnalyzer(args);
        analyzer.calculate();
        analyzer.display();
    }
}