package org.tutoring.db.connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Select extends Query<ItemModel>{

    public Select(String query, ResultMapper mapper) {
        super(query);
        this.mapper = mapper;
    }

    ResultMapper mapper;

    @Override
    public List<ItemModel> doQuery(Statement stmt) throws SQLException {
        List<ItemModel> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            result.add(mapper.newItem(rs));
        }
        return result;
    }
}
