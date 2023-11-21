package com.avinash.promptstore.commons.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoPropertiesConfig {
    public String host;
    public int port;
    public String database;
    public String username;
    public String password;
}
