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
        
        def response = new XmlSlurper().parse(url)
        double latitude = Double.parseDouble(response.result[0].geometry.location.lat.toString())
        double longitude = Double.parseDouble(response.result[0].geometry.location.lng.toString())
        
        new ImmutablePoint(x: latitude, y: longitude)
    }
}
