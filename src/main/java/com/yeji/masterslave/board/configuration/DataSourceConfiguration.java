package com.yeji.masterslave.board.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    private static final String MASTER_DATASOURCE = "masterDataSource";
    private static final String SLAVE_DATASOURCE1 = "slaveDataSource1";
    private static final String SLAVE_DATASOURCE2 = "slaveDataSource2";

    @Bean(MASTER_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.master.hikari")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(SLAVE_DATASOURCE1)
    @ConfigurationProperties(prefix = "spring.datasource.slave1.hikari")
    public DataSource slaveDataSource1() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(SLAVE_DATASOURCE2)
    @ConfigurationProperties(prefix = "spring.datasource.slave2.hikari")
    public DataSource slaveDataSource2() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    @DependsOn({MASTER_DATASOURCE, SLAVE_DATASOURCE1, SLAVE_DATASOURCE2})
    public DataSource routingDataSource(
        @Qualifier(MASTER_DATASOURCE) DataSource masterDataSource,
        @Qualifier(SLAVE_DATASOURCE1) DataSource slaveDataSource1,
        @Qualifier(SLAVE_DATASOURCE2) DataSource slaveDataSource2) {

        RoutingDataSource routingDataSource = new RoutingDataSource();

        Map<Object, Object> datasourceMap = new HashMap<>() {
            {
                put("master", masterDataSource);
                put("slave1", slaveDataSource1);
                put("slave2", slaveDataSource2);
            }
        };

        routingDataSource.setTargetDataSources(datasourceMap);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);

        return routingDataSource;
    }

}
