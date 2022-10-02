package com.atypon.data_entry.weather_entry;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherEntryRowMapper implements RowMapper {
    public WeatherEntry mapRow(ResultSet resultSet, int i) throws SQLException {
        return new WeatherEntry(
                resultSet.getDate("date").toLocalDate(),
                resultSet.getDouble("morning_temp"),
                resultSet.getDouble("night_temp")
        );
    }
}
