package com.atypon.show_results.display;

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
