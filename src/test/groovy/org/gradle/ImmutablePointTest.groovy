package org.gradle

import spock.lang.Specification

/**
 * Spock test which tests the immutability of {@code ImmutablePoint}.
 * @author rahulsingh
 *
 */
class ImmutablePointTest extends Specification {
    ImmutablePoint p;

    /**
     * Setup.
     * @return ImmutablePoint p
     */
    def setup() {
       p = new ImmutablePoint(x:3, y:4)
    }

    /**
     * We should be able to create a map using the two property
     * values of {@code ImmutablePoint}.
     * 
     * @return test failure or success
     */
    def "can use map creator for immutables"() {
        expect: [3, 4] == [p.x, p.y]
    }

    /**
     * We should not be able to change the value of
     * property x in the {@code ImmutablePoint}.
     *
     * @return test failure or success
     */
    def "can't change x"() {
       when: p.x = 5
       then: thrown(ReadOnlyPropertyException)
    }

    /**
     * We should not be able to change the value of
     * property y in the {@code ImmutablePoint}.
     *
     * @return test failure or success
     */
    def "can't change y"() {
        when: p.y = 9
        then: thrown(ReadOnlyPropertyException)
    }
}
