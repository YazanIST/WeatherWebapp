package com.atypon.data_entry.weather_entry;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather_entries")
public class WeatherEntry {
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column("morning_temp")
    private double morningTemp;
    @Column("night_temp")
    private double nightTemp;

    public WeatherEntry() {

    }

    public WeatherEntry(LocalDate date, double morningTemp, double nightTemp) {
        this.date = date;
        this.morningTemp = morningTemp;
        this.nightTemp = nightTemp;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMorningTemp() {
        return morningTemp;
    }

    public void setMorningTemp(double morningTemp) {
        this.morningTemp = morningTemp;
    }

    public double getNightTemp() {
        return nightTemp;
    }

    public void setNightTemp(double nightTemp) {
        this.nightTemp = nightTemp;
    }

    @Override
    public String toString() {
        return "WeatherEntry{" +
                "date=" + date +
                ", morningTemp=" + morningTemp +
                ", nightTemp=" + nightTemp +
                '}';
    }
}
