package com.bugbinc.superstartrek;

import org.junit.Test;

import static org.junit.Assert.*;

import com.bugbinc.superstartrek.world.Universe;
import com.bugbinc.superstartrek.world.UniverseObjectType;

/**
 * Tests for the Universe class including map generation
 */
public class UniverseUnitTests {

    /**
     * Tests the Universe singleton
     */
    @Test
    public void universe_singletonInstance_canBeRetrieved() {
        Universe universe = Universe.getInstance();
        assertNotEquals(null, universe);
    }

    /**
     * Tests that the universe is initialized with default number of sectors
     */
    @Test
    public void universe_getInstanceInitializesUniverseWithDefaultNumberOfSectors() {
        Universe universe = Universe.getInstance();
        assertEquals(80, universe.getMap().length);
        assertEquals(80, universe.getMap()[0].length);
    }

    /**
     * Tests that the universe is initialized with a custom number of sectors
     */
    @Test
    public void universe_canBeInitializedWithCustomNumberOfQuadrants() {
        Universe.initializeUniverse(10, 10);
        Universe universe = Universe.getInstance();
        assertEquals(100, universe.getMap().length);
        assertEquals(100, universe.getMap()[0].length);
    }

    /**
     * Tests that the map can be initialized
     */
    @Test
    public void map_initializes() {
        Universe universe = Universe.getInstance();
        universe.initializeMap(0, 0, 0, 0);
        assertEquals(UniverseObjectType.EMPTY, universe.getMap()[0][0].getType());
    }

    /**
     * Tests that the map initializes with all EMPTY fields
     */
    @Test
    public void map_initializesWithEmptyFields() {
        Universe universe = Universe.getInstance();
        universe.initializeMap(0, 0, 0, 0);
        for (int i = 0; i < universe.getMap().length; i++) {
            for (int j = 0; j < universe.getMap()[0].length; j++) {
                assertEquals(UniverseObjectType.EMPTY, universe.getMap()[i][j].getType());
            }
        }
    }

    /**
     * Tests that the map can be initialized with any number of stars
     */
    @Test
    public void map_initializesCorrectNumberOfStars() {
        Universe universe = Universe.getInstance();

        for (int x = 0; x < universe.getMap().length * universe.getMap()[0].length; x++) {
            universe.initializeMap(x, 0, 0, 0);
            int stars = 0;
            for (int i = 0; i < universe.getMap().length; i++) {
                for (int j = 0; j < universe.getMap()[0].length; j++) {
                    if (universe.getMap()[i][j].getType() == UniverseObjectType.STAR) {
                        stars++;
                    }
                }
            }
            assertEquals(x, stars);
        }
    }

    /**
     * Tests that the map can be initialized with any number of klingons
     */
    @Test
    public void map_initializesCorrectNumberOfKlingons() {
        Universe universe = Universe.getInstance();

        for (int x = 0; x < universe.getMap().length * universe.getMap()[0].length; x++) {
            universe.initializeMap( 0, x, 0, 0);
            int klingons = 0;
            for (int i = 0; i < universe.getMap().length; i++) {
                for (int j = 0; j < universe.getMap()[0].length; j++) {
                    if (universe.getMap()[i][j].getType() == UniverseObjectType.KLINGON) {
                        klingons++;
                    }
                }
            }
            assertEquals(x, klingons);
        }
    }

    /**
     * Tests that the map can be initialized with any number of romulans
     */
    @Test
    public void map_initializesCorrectNumberOfRomulans() {
        Universe universe = Universe.getInstance();

        for (int x = 0; x < universe.getMap().length * universe.getMap()[0].length; x++) {
            universe.initializeMap( 0, 0, x, 0);
            int romulans = 0;
            for (int i = 0; i < universe.getMap().length; i++) {
                for (int j = 0; j < universe.getMap()[0].length; j++) {
                    if (universe.getMap()[i][j].getType() == UniverseObjectType.ROMULAN) {
                        romulans++;
                    }
                }
            }
            assertEquals(x, romulans);
        }
    }

    /**
     * Tests that the map can be initialized with any number of star bases
     */
    @Test
    public void map_initializesCorrectNumberOfStarBases() {
        Universe universe = Universe.getInstance();

        for (int x = 0; x < universe.getMap().length * universe.getMap()[0].length; x++) {
            universe.initializeMap( 0, 0, 0, x);
            int starBases = 0;
            for (int i = 0; i < universe.getMap().length; i++) {
                for (int j = 0; j < universe.getMap()[0].length; j++) {
                    if (universe.getMap()[i][j].getType() == UniverseObjectType.STAR_BASE) {
                        starBases++;
                    }
                }
            }
            assertEquals(x, starBases);
        }
    }

    /**
     * Tests that the map cannot be initialized with more objects than supported
     */
    @Test
    public void map_throwsIfTooManyObjects() {
        Universe universe = Universe.getInstance();
        Exception illegalArgumentException = null;

        try {
            universe.initializeMap(universe.getMap().length * universe.getMap()[0].length + 1, 0, 0, 0);
            fail("Expected IllegalArgumentException");
        } catch (Exception ex) {
            illegalArgumentException = ex;
        }
        assertEquals(IllegalArgumentException.class, illegalArgumentException.getClass());

        illegalArgumentException = null;

        try {
            universe.initializeMap(0, universe.getMap().length * universe.getMap()[0].length + 1, 0, 0);
            fail("Expected IllegalArgumentException");
        } catch (Exception ex) {
            illegalArgumentException = ex;
        }
        assertEquals(IllegalArgumentException.class, illegalArgumentException.getClass());

        illegalArgumentException = null;

        try {
            universe.initializeMap(0, 0, universe.getMap().length * universe.getMap()[0].length + 1, 0);
            fail("Expected IllegalArgumentException");
        } catch (Exception ex) {
            illegalArgumentException = ex;
        }
        assertEquals(IllegalArgumentException.class, illegalArgumentException.getClass());

        illegalArgumentException = null;

        try {
            universe.initializeMap(0, 0, 0, universe.getMap().length * universe.getMap()[0].length + 1);
            fail("Expected IllegalArgumentException");
        } catch (Exception ex) {
            illegalArgumentException = ex;
        }
        assertEquals(IllegalArgumentException.class, illegalArgumentException.getClass());
    }
}