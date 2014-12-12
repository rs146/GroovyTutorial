package org.gradle

class Main {

    static main(args) {
        Person person = new Person("Rahul Singh");
        println("Name is: $person.name");
        
        RetrieveListPeople initialiser = new RetrieveListPeople()
        List<Person> people = initialiser.retrievePeople();
        
        people.each() { println "$it, " }
        
        GeoLocatorService geoLocSvc = new GeoLocatorService()
        geoLocSvc.getLongLatForAddress("15 The Alders", "Hounslow", "TW5 0HP")
    }
}
