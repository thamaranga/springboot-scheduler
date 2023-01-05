package com.hasithat.springbootscheduler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
/*
* We can put @EnableScheduling annotation inside any class of our project. But it is a
* good practice to put it inside a config class.
*
* */
@EnableScheduling
public class JobConfig {
}
