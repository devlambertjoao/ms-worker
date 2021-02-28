package com.lambert.worker.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.lambert.worker.data.sql.entity")
@EnableJpaRepositories("com.lambert.worker.data.sql.repository")
@Configuration
public class SqlServerConfig {

}
