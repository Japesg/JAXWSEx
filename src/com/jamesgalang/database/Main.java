package com.jamesgalang.database;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "jaxws.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_PEOPLE = "people";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_LOCATION = "location";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_PEOPLE);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PEOPLE +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_NUMBER + " integer, " +
                    COLUMN_LOCATION + " text" +
                    ")");

            insertPerson(statement,"Anil", 35343, "Aldie");
            insertPerson(statement,"Shiva", 64567, "Woodbridge");
            insertPerson(statement,"James", 43456, "Ashburn");
            insertPerson(statement,"Rishith", 34657, "Fairfax");

            statement.execute("UPDATE " + TABLE_PEOPLE + " SET " +
                    COLUMN_NUMBER + "=5566789" +
                    " WHERE " + COLUMN_NAME + "='Jane'");

            statement.execute("DELETE FROM " +TABLE_PEOPLE +
                    " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PEOPLE);
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_NUMBER) + " " +
                        results.getString(COLUMN_LOCATION));
            }

            results.close();

            statement.close();
            conn.close();

//            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");
//            Class.forName("org.sql.JDBC");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertPerson(Statement statement, String name, int number, String location) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_PEOPLE +
                " (" + COLUMN_NAME + ", " +
                COLUMN_NUMBER + ", " +
                COLUMN_LOCATION +
                " ) " +
                "VALUES('" + name + "', " + number + ", '" + location + "')");
    }
}