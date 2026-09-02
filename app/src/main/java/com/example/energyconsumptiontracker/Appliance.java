package com.example.energyconsumptiontracker;


public class Appliance {

    private String applianceName;
    private String category;
    private double powerRating;
    private double dailyHours;
    private double tariff;

    // Default Constructor
    public Appliance() {

    }

    // Parameterized Constructor
    public Appliance(String applianceName,
                     String category,
                     double powerRating,
                     double dailyHours,
                     double tariff) {

        this.applianceName = applianceName;
        this.category = category;
        this.powerRating = powerRating;
        this.dailyHours = dailyHours;
        this.tariff = tariff;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(double powerRating) {
        this.powerRating = powerRating;
    }

    public double getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(double dailyHours) {
        this.dailyHours = dailyHours;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }
}