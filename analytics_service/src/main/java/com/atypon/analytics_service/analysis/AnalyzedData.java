package com.atypon.analytics_service.analysis;

import javax.persistence.*;

@Entity
@Table(name = "analyzed_data")
public class AnalyzedData {
    @Id
    String daytime;
    double lowestTemp;
    double avgTemp;
    double highestTemp;

    public AnalyzedData() {
    }

    public AnalyzedData(String daytime, double lowestTemp, double avgTemp, double highestTemp) {
        this.daytime = daytime;
        this.lowestTemp = lowestTemp;
        this.avgTemp = avgTemp;
        this.highestTemp = highestTemp;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public double getLowestTemp() {
        return lowestTemp;
    }

    public void setLowestTemp(double lowestTemp) {
        this.lowestTemp = lowestTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getHighestTemp() {
        return highestTemp;
    }

    public void setHighestTemp(double highestTemp) {
        this.highestTemp = highestTemp;
    }

    @Override
    public String toString() {
        return "AnalyzedData{" +
                "daytime='" + daytime + '\'' +
                ", lowestTemp=" + lowestTemp +
                ", avgTemp=" + avgTemp +
                ", highestTemp=" + highestTemp +
                '}';
    }
}
