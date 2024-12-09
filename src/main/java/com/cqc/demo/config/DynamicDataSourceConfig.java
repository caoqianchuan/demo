package com.cqc.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                 @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {

        // 创建一个动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        // 设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource);

        // 设置目标数据源映射，主库和从库
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("primary", primaryDataSource);  // 主库
        targetDataSources.put("secondary", secondaryDataSource);  // 从库

        dynamicDataSource.setTargetDataSources(targetDataSources);  // 设置所有数据源
        return dynamicDataSource;
    }

    // 配置事务管理器
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}

