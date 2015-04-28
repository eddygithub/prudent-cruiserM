package com.prudent.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.prudent.persistence.customerDB.config.PersistenceConfig;

@Configuration
@Import(value={PersistenceConfig.class})
public class RootConfig {
}
