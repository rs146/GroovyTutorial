package org.gradle

import java.lang.Double.*
/**
 * Service class to obtain the longitude and latitude
 * of a particular address.
 *
 * @author rahulsingh
 */
class GeoLocatorService {

    /**
     * Get the Longitude and latitude for a particular location
     * given the street, city and postcode.
     *
     * @param street the street
     * @param city the city
     * @param postcode the postcode
     * @return ImmutablePoint with x and y values
     */
    ImmutablePoint getLongLatForAddress(String street, String city, String postcode) {
        String base = 'https://maps.googleapis.com/maps/api/geocode/xml?'
        def url = base + [sensor: false,
            address: [street, city, postcode].collect{
                v -> URLEncoder.encode(v, 'UTF-8')
            }.join(',')
        ].collect { k,v -> "$k=$v"}.join('&')
        
        println url
        def response = new XmlSlurper().parse(url)
        String latitude = response.result[0].geometry.location.lat ?: "0.0"
        String longitude = response.result[0].geometry.location.lng ?: "0.0"
        
        double lat = latitude.toDouble()
        double lng = longitude.toDouble()
        new ImmutablePoint(x: lat, y: lng)
    }
}
