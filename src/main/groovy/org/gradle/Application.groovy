package org.gradle

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.gradle.dataaccess.*")
@EnableAutoConfiguration
class Application {

    static void main(String[] args) throws Throwable {
        SpringApplication app = new SpringApplication(Application.class)
        app.setShowBanner(false)
        app.run(args)
    }
}
