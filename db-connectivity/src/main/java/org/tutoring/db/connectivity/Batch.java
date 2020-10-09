package org.tutoring.db.connectivity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class Batch extends Query<Void>{

    public Batch(String query) {
        super(query);
    }

    @Override
    public List<Void> doQuery(Statement stmt) throws SQLException {
        for(String q :  query.split(";")) {
            stmt.addBatch(q);
        }
        stmt.executeBatch();
        return Collections.emptyList();
    }
}
