package com.bugbinc.superstartrek.world;

import com.bugbinc.superstartrek.game.GameLength;
import com.bugbinc.superstartrek.game.GameSettings;

public class Universe {
    // Static variable reference of instance of the universe
    private static Universe instance = null;

    private final UniverseObject[][] map;

    /**
     * Private constructor to avoid object creation from outside the class.
     */
    private Universe(int xQuadrants, int yQuadrants) {
        // The universe is xQuadrants x yQuadrants and each quadrant is 10x10 sectors
        map = new UniverseObject[xQuadrants * 10][yQuadrants * 10];
    }

    /**
     * Initializes the universe with a custom number of quadrants
     *
     * @implNote To retrieve the universe instance after calling this method use Universe.getInstance()
     * @see Universe#getInstance()
     */
    public static void initializeUniverse(int xQuadrants, int yQuadrants) {
        instance = new Universe(xQuadrants, yQuadrants);
    }

    /**
     * Static method to get instance of the universe
     *
     * @return instance of the universe
     * @implNote If the universe has not been initialized, it will be initialized with 8x8 quadrants
     * @see Universe#initializeUniverse(int, int)
     */
    public static Universe getInstance() {
        if (instance == null)
            instance = new Universe(8, 8);

        return instance;
    }

    /**
     * Initializes the universe using the current Game Settings
     *
     * @throws IllegalArgumentException If the game settings length are not valid
     */
    public void initializeMapUsingGameSettings() throws IllegalArgumentException {
        GameSettings gameSettings = GameSettings.getInstance();
        GameLength gameLength = gameSettings.getGameLength();

        // Initialize the map with the game length
        // Since we control the board size we are sure that we can fit all elements in the universe
        // therefore we do not check for the initializeMap IllegalArgumentException
        switch (gameLength) {
            case SHORT:
                initializeUniverse(8, 8);
                initializeMap(100, 10, 2, 2);
                break;
            case MEDIUM:
                initializeUniverse(8, 8);
                initializeMap(150, 20, 3, 2);
                break;
            case LONG:
                initializeUniverse(8, 8);
                initializeMap(250, 40, 4, 2);
                break;
            default:
                throw new IllegalArgumentException("Invalid game length");
        }
    }

    /**
     * Initializes the map with randomized object locations
     *
     * @throws IllegalArgumentException if the number of objects exceeds the map size
     */
    public void initializeMap(int numberOfStars, int numberOfKlingons, int numberOfRomulans, int numberOfStarBases) throws IllegalArgumentException {
        // Check that the number of objects does not exceed the number of sectors in the universe
        if (numberOfStars + numberOfKlingons + numberOfRomulans + numberOfStarBases > map.length * map[0].length)
            throw new IllegalArgumentException("Number of objects exceeds map size");

        // Initialize the map with empty objects
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                map[x][y] = new UniverseObject();
                map[x][y].setType(UniverseObjectType.EMPTY);
            }
        }

        // Add Stars
        for (int i = 0; i < numberOfStars; i++) {
            // Generate a random location
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map[0].length);

            // Check if the location is empty if not pick another one
            if (map[x][y].getType() != UniverseObjectType.EMPTY) {
                i--;
                continue;
            }

            map[x][y].setType(UniverseObjectType.STAR);
        }

        // Add Klingons
        for (int i = 0; i < numberOfKlingons; i++) {
            // Generate a random location
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map[0].length);

            // Check if the location is empty if not pick another one
            if (map[x][y].getType() != UniverseObjectType.EMPTY) {
                i--;
                continue;
            }

            map[x][y].setType(UniverseObjectType.KLINGON);
        }

        // Add Romulans
        for (int i = 0; i < numberOfRomulans; i++) {
            // Generate a random location
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map[0].length);

            // Check if the location is empty if not pick another one
            if (map[x][y].getType() != UniverseObjectType.EMPTY) {
                i--;
                continue;
            }

            map[x][y].setType(UniverseObjectType.ROMULAN);
        }

        // Add Star Bases
        for (int i = 0; i < numberOfStarBases; i++) {
            // Generate a random location
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map[0].length);

            // Check if the location is empty if not pick another one
            if (map[x][y].getType() != UniverseObjectType.EMPTY) {
                i--;
                continue;
            }

            map[x][y].setType(UniverseObjectType.STAR_BASE);
        }
    }

    /**
     * Getter for the map
     *
     * @return map
     */
    public UniverseObject[][] getMap() {
        return map;
    }
}
