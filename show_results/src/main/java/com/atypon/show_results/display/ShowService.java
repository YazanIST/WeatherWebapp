package com.atypon.show_results.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private final JdbcTemplate jdbc;

    @Autowired
    public ShowService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AnalyzedData> getAllAnalyzed() {
        return jdbc.query("SELECT * FROM analyzed_data", new AnalyzedDataRowMapper());
    }

    public List<WeatherEntry> getAll() {
        return jdbc.query("SELECT * FROM weather_entries", new WeatherEntryRowMapper());
    }
}
