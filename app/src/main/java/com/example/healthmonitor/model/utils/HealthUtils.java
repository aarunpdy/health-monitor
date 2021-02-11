package com.example.healthmonitor.model.utils;

import com.example.healthmonitor.R;
import com.example.healthmonitor.model.event.HealthCard;
import com.example.healthmonitor.model.event.HealthEvent;

import java.util.ArrayList;
import java.util.List;

public class HealthUtils {

    public static List<HealthCard> getHealthEvents() {
        ArrayList<HealthCard> list = new ArrayList<>();
        list.add(new HealthCard(HealthEvent.STEPS, R.drawable.ic_steps, "8489", "Enter "));
        list.add(new HealthCard(HealthEvent.TEMPERATURE, R.drawable.ic_temperature, "36.3", "Enter Body Temperature"));
        list.add(new HealthCard(HealthEvent.BP, R.drawable.ic_bp, "83", "Enter Blood pressure value"));
        list.add(new HealthCard(HealthEvent.RESPIRATION, R.drawable.ic_respiration, "16", "Enter Respiration value"));
        list.add(new HealthCard(HealthEvent.GLUCOSE, R.drawable.ic_glucose, "103", "Enter Glucose value"));
        list.add(new HealthCard(HealthEvent.HEART_RATE, R.drawable.ic_heart_rate, "98", "Enter Heart rate"));
        list.add(new HealthCard(HealthEvent.CHOLESTEROL, R.drawable.ic_cholesterol, "141", "Enter Cholesterol"));
        list.add(new HealthCard(HealthEvent.OXYGEN_SATURATION, R.drawable.ic_oxygen, "97", "Enter Oxygen Saturation Value"));
        return list;
    }

    public static List<HealthCard> getHealthEventsForEdit() {
        List<HealthCard> list = getHealthEvents();
        list.remove(0);
        return list;
    }
}
