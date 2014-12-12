package org.gradle

import spock.lang.Specification

/**
 * Spock test for {@code RetrieveListPeople}.
 *
 * @author rahulsingh
 */
class RetrieveListPeopleSpec extends Specification {

    RetrieveListPeople listOfPeople
    List<Person> persons

    /**
     * Initialise SUT
     * @return
     */
    def setup() {
        listOfPeople = new RetrieveListPeople()
    }

    /**
     * People in list should equal 2
     * @return 2
     */
    def "People in list of people should be 2"() {
        expect: 2 == listOfPeople.retrievePeople().size
    }

    /**
     * Accessing a person in the list where the list size is smaller
     * than the one we're trying to access, it should result in an error.
     *
     * @return thrown Exception
     */
    def "Accessing third person should result in exception throw"() {
        when: listOfPeople.retrievePeople().get(2)
        then: thrown(IndexOutOfBoundsException)
    }
}
