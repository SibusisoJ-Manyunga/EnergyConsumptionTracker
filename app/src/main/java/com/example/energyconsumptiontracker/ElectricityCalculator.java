package com.example.energyconsumptiontracker;


public class ElectricityCalculator {

    public double calculateDailyConsumption(double watts,
                                            double hours) {

        return (watts * hours) / 1000;
    }

    public double calculateMonthlyConsumption(double daily) {

        return daily * 30;
    }

    public double calculateMonthlyCost(double monthly,
                                       double tariff) {

        return monthly * tariff;
    }
}
