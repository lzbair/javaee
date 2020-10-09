package org.tutoring.db.connectivity;


import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.SQLException;

public class JNDI {

    static String TUTORING_DS_NAME = "jdbc/tutoring";

    static String DB_URL = "jdbc:oracle:thin:@localhost:49161:XE";
    static String DB_USER = "tutoring";
    static String DB_PASSWORD = "tutoring";
    static InitialContext context;

    static void bind(String contextName, Object contextValue) throws NamingException {
        context.bind(contextName, contextValue);
    }

    static <T> T lookup(String contextName) throws NamingException {
        return (T) context.lookup(contextName);
    }

    static private OracleConnectionPoolDataSource createDS(String location, String user, String password) throws SQLException {
        OracleConnectionPoolDataSource dataSource = new OracleConnectionPoolDataSource();
        dataSource.setURL(location);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    static {
        try {
            SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
            builder.activate();
            context = new InitialContext();
            context.createSubcontext("java:comp/env/jdbc");
            context.bind(TUTORING_DS_NAME, createDS(DB_URL, DB_USER, DB_PASSWORD));
        } catch (NamingException | SQLException e) {
            throw new IllegalStateException("Can not initialize  JNDI context", e);
        }
    }
}
