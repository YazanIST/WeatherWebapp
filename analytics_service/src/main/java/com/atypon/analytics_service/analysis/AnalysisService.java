package com.atypon.analytics_service.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class AnalysisService {
    private final JdbcTemplate jdbc;

    @Autowired
    public AnalysisService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AnalyzedData> getAll() {
        return jdbc.query("SELECT * FROM analyzed_data", new AnalyzedDataRowMapper());
    }

    public void update() {
        clear();
        addAnalyzedData(
                new AnalyzedData(
                        "morning",
                        getMinMorning(),
                        getAvgMorning(),
                        getMaxMorning()
                )
        );
        addAnalyzedData(
                new AnalyzedData(
                        "night",
                        getMinNight(),
                        getAvgNight(),
                        getMaxNight()
                )
        );
    }

    private void clear() {
        String DB_URL = "jdbc:mysql://mysqldb:3306/weatherdb?";
        String USER = "root";
        String PASS = "root";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM analyzed_data";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAnalyzedData(AnalyzedData analyzedData) {
        try {
            jdbc.update(
                    "INSERT INTO analyzed_data(daytime, lowest_temp, avg_temp, highest_temp) VALUES(?,?,?,?)",
                    analyzedData.getDaytime(),
                    analyzedData.getLowestTemp(),
                    analyzedData.getAvgTemp(),
                    analyzedData.getHighestTemp()
            );
        } catch (DataIntegrityViolationException e) {
            System.out.println("day_time already exist");
        }
    }

    private double getMinMorning() {
        return jdbc.queryForObject(
                "SELECT MIN(morning_temp) FROM weather_entries",
                double.class
        );
    }

    private double getMaxMorning() {
        return jdbc.queryForObject(
                "SELECT MAX(morning_temp) FROM weather_entries",
                double.class
        );
    }

    private double getAvgMorning() {
        return jdbc.queryForObject(
                "SELECT AVG(morning_temp) FROM weather_entries",
                double.class
        );
    }

    private double getMinNight() {
        return jdbc.queryForObject(
                "SELECT MIN(night_temp) FROM weather_entries",
                double.class
        );
    }

    private double getMaxNight() {
        return jdbc.queryForObject(
                "SELECT MAX(night_temp) FROM weather_entries",
                double.class
        );
    }

    private double getAvgNight() {
        return jdbc.queryForObject(
                "SELECT AVG(night_temp) FROM weather_entries",
                double.class
        );
    }
}
