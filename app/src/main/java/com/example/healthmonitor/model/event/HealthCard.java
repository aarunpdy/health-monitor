package com.example.healthmonitor.model.event;

import androidx.annotation.DrawableRes;

public class HealthCard {
    public HealthCard() {
    }

    public HealthCard(HealthEvent event, @DrawableRes int icon, String value, String hint) {
        this.event = event;
        this.icon = icon;
        this.value = value;
        this.hint = hint;
    }

    public HealthEvent event;
    @DrawableRes
    public int icon;
    public String value;
    public String hint;
    public boolean isEditable;

    public String getName() {
        return event != null ? event.getName() : null;
    }
}
