package org.gradle

class RetrieveListPeople {

    List<Person> retrievePeople() {
        def person1 = new Person("Rahul Singh")
        def person2 = new Person("Mr T Bone")
        def list = [person1, person2]
        
        return list
    }
}
