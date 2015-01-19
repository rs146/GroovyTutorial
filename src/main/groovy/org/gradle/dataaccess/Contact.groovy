package org.gradle.dataaccess

/**
 * POGO for the Contact in the database.
 *
 * @author rahulsingh
 */
class Contact {

    Integer id;
    String name;
	
	public Contact(Integer id, String name) {
		this.id = id
		this.name = name
	}
}
