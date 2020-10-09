package org.tutoring.db.connectivity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Query<RESULT> {

    String query;

    public Query(String query) {
        this.query = query;
    }

    public abstract List<RESULT> doQuery(Statement statement) throws SQLException;
}
