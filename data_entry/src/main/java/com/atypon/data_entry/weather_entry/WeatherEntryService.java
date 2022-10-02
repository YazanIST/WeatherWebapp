package com.atypon.data_entry.weather_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WeatherEntryService {
    private JdbcTemplate jdbc;

    @Autowired
    public WeatherEntryService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<WeatherEntry> getWeatherEntries() {
        return jdbc.query("SELECT * FROM weather_entries", new WeatherEntryRowMapper());
    }

    public void addWeatherEntry(WeatherEntry weatherEntry) {
        try {
            jdbc.update(
                    "INSERT INTO weather_entries(date, morning_temp, night_temp) VALUES(?,?,?)",
                    weatherEntry.getDate(),
                    weatherEntry.getMorningTemp(),
                    weatherEntry.getNightTemp()
            );
        } catch (DataIntegrityViolationException e) {
            System.out.println("day already exist");
        }
    }
}
