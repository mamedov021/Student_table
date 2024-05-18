package com.example.Spring_demo.controller;

import java.sql.*;

public class StudentDbService {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public  String  getStudent() throws Exception{
        try {
            String url = "jdbc:postgresql://localhost:5432/myDb";
            String password = "password";
            String username = "postgres";

            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();
            String query = "Select *FROM student";
            resultSet = statement.executeQuery(query);

            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()) {
                  String id = resultSet.getString("id");
                 String name = resultSet.getString("name");
                 String surname = resultSet.getString("surname");
                String age = resultSet.getString("age");

                //System.out.println("ID : " + id + ", Name : " + name);

                 stringBuilder.append("Id : " + id);
                stringBuilder.append("  ");

                stringBuilder.append("Name : " + name);
                stringBuilder.append("  ");

                stringBuilder.append("Surname : " + surname);
                stringBuilder.append("  ");

                stringBuilder.append("Age : " + age);



            }
            return stringBuilder.toString();
            }
            finally{
                connection.close();
            }
    }
}

