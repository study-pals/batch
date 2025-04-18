package com.batchPal.global.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
    public static final String META_DATASOURCE = "metaDataSource";
    public static final String DOMAIN_DATASOURCE = "domainDataSource";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.meta")
    public HikariConfig metaHikariConfig() {
        return new HikariConfig();
    }

    @Primary
    @Bean(META_DATASOURCE)
    public DataSource metaDataSource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(metaHikariConfig()));
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.domain")
    public HikariConfig domainHikariConfig() {
        return new HikariConfig();
    }

    @Bean(DOMAIN_DATASOURCE)
    public DataSource domainDataSource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(domainHikariConfig()));
    }
}
