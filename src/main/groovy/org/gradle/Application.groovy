package org.gradle

import org.gradle.dataaccess.Contact
import org.gradle.dataaccess.ContactRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@EnableAutoConfiguration
@Configuration
@ComponentScan("org.gradle.dataaccess")
class Application {

	static void main(String[] args) throws Throwable {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class)
		ContactRepository contactRepo = context.getBean(ContactRepository.class)
		List<Contact> contacts = contactRepo.findAllContacts()

		contacts.each{ contact -> println "$contact.name"}
	}
}
