package org.tutoring.db.connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements ResultMapper{
    @Override
    public Book newItem(ResultSet rs) throws SQLException {
        return new Book(rs.getString("Title"));
    }
}
