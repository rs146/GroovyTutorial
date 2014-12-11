package org.gradle

class Main {

    static main(args) {
        Person person = new Person("Rahul Singh");
        println("Name is: $person.name");
        
        RetrieveListPeople initialiser = new RetrieveListPeople()
        List<Person> people = initialiser.retrievePeople();
        
        people.each() { println "$it, " }
    }
}
