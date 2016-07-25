package ru.my.quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by maksim on 5/1/2016.
 */

@Component
public class TestClass{
        @Autowired
        private DriverManagerDataSource driverManagerDataSource;


    DriverManagerDataSource  dataSource() {
        final DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.jdbc.Driver");
        dm.setUrl("jdbc:mysql://localhost:3306/world");
        dm.setUsername("root");
        dm.setPassword("root");
        return dm;
    }


    public void getinfo() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =dataSource().getConnection();

        connection.createStatement();

        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery("SELECT * FROM city ");
        while( resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        statement.close();
        connection.close();
    }

}
