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
            statement.execute("insert into address_book_service.address_book values('Vihan','Dabhade','Kon','Pen','Kerala','vih@gmail.com','625321','451245','2019-10-03','Man','Profession')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address_book_service.address_book");
            System.out.println("\nRetrieve address Book contact from database :");
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
                        + " " + resultSet.getDate(9)
                        + " " + resultSet.getString(10)
                        + " " + resultSet.getString(11));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}
