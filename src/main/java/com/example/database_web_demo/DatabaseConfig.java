package com.example.database_web_demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private final Environment env;

    public DatabaseConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        String dbUrl = env.getProperty("spring.datasource.url");
        config.setJdbcUrl(dbUrl);

        String dbUsername = env.getProperty("spring.datasource.username");
        config.setUsername(dbUsername);

        String dbPassword = env.getProperty("spring.datasource.password");
        config.setPassword(dbPassword);

        return new HikariDataSource(config);
    }
}