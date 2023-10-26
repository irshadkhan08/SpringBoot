package org.com.LearningSpringBoot;


import org.com.LearningSpringBoot.repository.IPerson;
import org.com.LearningSpringBoot.repository.SpringJdbcDemo;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfiguration {
    @Bean
    public Connection methodConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Bean
    public DataSource getDataSource(){
            DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/db");
            dataSourceBuilder.username("user");
            dataSourceBuilder.password("user");
            return dataSourceBuilder.build();
    }
    @Bean
    public IPerson getP(){
        return new SpringJdbcDemo();
    }

}
