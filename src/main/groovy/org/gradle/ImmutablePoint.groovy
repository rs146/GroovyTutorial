package org.gradle

import groovy.transform.Immutable

/**
 * An example of an immutable Groovy class.
 * The properties of this class can be set initially, but after that
 * they can no longer be modified.
 *
 * @author rahulsingh
 */
@Immutable
class ImmutablePoint {

    double x;
    double y;

    /**
     * Override the toString().
     */
    String toString() {
        "($x, $y)"
    }
    
    String getX() {
        "$x"
    }
    
    String getY() {
        "$y"
    }
}
