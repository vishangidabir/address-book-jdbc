package com.bridgelabz;

import java.sql.*;

public class AddressBookJDBC {
    public static void main(String[] args) throws SQLException {
        System.out.println("~~~Welcome to Address Book Program on JDBC~~~");
        String jdbcURL = "jdbc:mysql://localhost:3307/address_book_service?useSSL=false";
        String userName = "root";
        String passWord = "1234";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            System.out.println("Connecting to database :" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connection is successful!!!!" + connection);
            Statement statement = connection.createStatement();
            statement.execute("update address_book_service.address_book set firstName = 'Priyanka' where  firstName = 'Madhu'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address_book_service.address_book");
            System.out.println("Update address Book contact from database :");
            System.out.println();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3)
                        + " " + resultSet.getString(4)
                        + " " + resultSet.getString(5)
                        + " " + resultSet.getString(6)
                        + " " + resultSet.getInt(7)
                        + " " + resultSet.getInt(8)
                        + " " + resultSet.getString(9)
                        + " " + resultSet.getString(10));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}
