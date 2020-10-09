package org.tutoring.db.connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {
    ItemModel newItem(ResultSet rs) throws SQLException;
}
