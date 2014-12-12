package org.gradle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Integration test for the {@code GeoLocatorServiceTest}.
 *
 * @author rahulsingh
 *
 */
public class GeoLocatorServiceTest {
    GeoLocatorService geoLocatorService;

    /**
     * Set-up the {@code GeoLocatorService} class.
     */
    @Before
    public void setUp() {
        geoLocatorService = new GeoLocatorService();
    }

    /**
     * Let's test the (@code GeoLocatorService} class and
     * pass a real address to the service.
     */
    @Test
    public void testWithARealAddress() {
        ImmutablePoint ip = geoLocatorService.getLongLatForAddress("15 The Alders", "Hounslow", "TW5 0HP");
        double latitude = Double.parseDouble(ip.getX());
        assertEquals(latitude, 51.4895811, 0.00000000001);
        
        double longitude = Double.parseDouble(ip.getY());
        assertEquals(longitude, -0.3776838, 0.00000000001);
    }
}
