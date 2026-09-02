package com.example.energyconsumptiontracker;


public class Recommendation {

    public String getRating(double monthlyConsumption) {

        if (monthlyConsumption < 150) {

            return "Excellent";

        } else if (monthlyConsumption < 300) {

            return "Good";

        } else if (monthlyConsumption < 500) {

            return "Average";

        } else if (monthlyConsumption < 700) {

            return "High Consumption";

        } else {

            return "Very High Consumption";
        }
    }

    public String getRecommendation(String rating) {

        switch (rating) {

            case "Excellent":
                return "Continue maintaining your current electricity usage.";

            case "Good":
                return "Consider switching to LED lighting.";

            case "Average":
                return "Reduce appliance usage during peak hours.";

            case "High Consumption":
                return "Replace old appliances with energy-efficient models.";

            default:
                return "Immediate action is recommended to reduce electricity usage.";
        }
    }
}