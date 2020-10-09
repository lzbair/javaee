package org.tutoring.db.connectivity;


import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.function.Supplier;

public class Database {
    Supplier<Connection> jdbcDriver;
    DataSource dataSource;

    public Database(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Database(String user, String password, String location) throws SQLException {
        this.dataSource = createDS(location, user, password);
        this.jdbcDriver = () -> {
            try {
                Connection connection = DriverManager.getConnection(location, user, password);
                connection.setAutoCommit(false);
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException("Can not establish connection ..", e);
            }
        };
    }

    private OracleConnectionPoolDataSource createDS(String location, String user, String password) throws SQLException {
        OracleConnectionPoolDataSource dataSource = new OracleConnectionPoolDataSource();
        dataSource.setURL(location);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    <RESULT> List<RESULT> execute(Query<RESULT> query) throws SQLException {
        // final Connection conn = jdbcDriver.get();
        final Connection conn = dataSource.getConnection();
         conn.setAutoCommit(false);
        try (Statement stmt = conn.createStatement()) {
            List<RESULT> results = query.doQuery(stmt);
            conn.commit();
            return results;
        } catch (SQLException e) {
           conn.rollback();
            throw new RuntimeException("Can not execute  db queries ..", e);
        }finally {
            conn.close();
        }
    }
}
