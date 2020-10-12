package org.tutoring.db.connectivity;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DBClient {


    public static void main(String[] args) throws Exception {
        DataSource ds = JNDI.lookup(JNDI.TUTORING_DS_NAME);
        standard(ds);
        spring(ds);
    }

    private static void standard(DataSource ds) throws java.sql.SQLException {
        Database db = new Database(ds);
        String bookTable = "CREATE TABLE Books (" +
                "BookID int, " +
                "Title varchar(100), " +
                "Author varchar(100), " +
                "Description varchar(255)" +
                ")";


        String insertBooks = "INSERT INTO Books " +
                "(BookID, Title, Author, Description) VALUES " +
                "('102', 'SICP', 'MIS', 'Structures and interpretations of CS')";

        //execute once : db.execute(new Batch(insertBooks));

        db.execute(new Select("SELECT * from Books", new BookMapper())).stream().forEach(System.out::println);
    }


    private static void spring(DataSource ds) {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        String query = "SELECT * from Books";
        jdbcTemplate.query(query, new BookMapper()).stream().forEach(System.out::println);
    }
}
