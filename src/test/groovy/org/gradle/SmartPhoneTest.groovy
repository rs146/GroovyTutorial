package org.gradle

import org.junit.Test

/**
 * Simple Groovy Test for the Smart Phone class using JUnit.
 *
 * @author rahulsingh
 *
 */
class SmartPhoneTest {

    SmartPhone sp = new SmartPhone()

    /**
     * We should be able to call the dial method defined
     * in the Phone class.
     */
    @Test
    void shouldCallDialFromSmartPhone() {
        assert 'dialing 555-1234' == sp.dial('555-1234')
    }
    
    @Test
    void shouldCallTakePictureFromSmartPhone() {
        assert 'taking picture' == sp.takePicture()
    }
    
    @Test
    void testDialFailureOnDifferentArg() {
        assert 'dialing 555-1234' != sp.dial('655-1234')
    }
}
