package com.jamesgalang.database;

import java.sql.*;

public class ResultsOnly{
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

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PEOPLE);
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_NUMBER) + " " +
                        results.getString(COLUMN_LOCATION));
            }

            results.close();

            statement.close();
            conn.close();

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

