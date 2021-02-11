package com.example.healthmonitor.model.event;

public enum HealthEvent {
    STEPS("Steps"),
    TEMPERATURE("Body Temperature"),
    BP("Blood Pressure"),
    RESPIRATION("Respiration"),
    GLUCOSE("Glucose"),
    HEART_RATE("Heart Rate"),
    CHOLESTEROL("Cholesterol"),
    OXYGEN_SATURATION("Oxygen Saturation"),
    ;

    public String getName() {
        return name;
    }

    private String name;
    HealthEvent(String name){
        this.name = name;
    }


}
