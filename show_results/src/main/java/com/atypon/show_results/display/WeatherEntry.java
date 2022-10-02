package com.atypon.show_results.display;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @Transient
    private String username;
    @Transient
    private String password;

    public WeatherEntry() {

    }

    public WeatherEntry(LocalDate date, double morningTemp, double nightTemp) {
        this.date = date;
        this.morningTemp = morningTemp;
        this.nightTemp = nightTemp;
    }

    public WeatherEntry(LocalDate date, double morningTemp, double nightTemp, String username, String password) {
        this.date = date;
        this.morningTemp = morningTemp;
        this.nightTemp = nightTemp;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
