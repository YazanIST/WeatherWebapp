package com.atypon.analytics_service.analysis;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalyzedDataRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AnalyzedData(
                rs.getString("daytime"),
                rs.getDouble("lowest_temp"),
                rs.getDouble("avg_temp"),
                rs.getDouble("highest_temp")
        );
    }
}
