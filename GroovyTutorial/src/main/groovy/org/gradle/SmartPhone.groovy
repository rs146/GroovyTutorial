package org.gradle

class SmartPhone {

    @Delegate Camera camera = new Camera()
    @Delegate Phone phone = new Phone()
}
