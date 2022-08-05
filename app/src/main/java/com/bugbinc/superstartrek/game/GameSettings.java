package com.bugbinc.superstartrek.game;

public class GameSettings {

    // Static variable reference of instance of the game
    private static GameSettings instance = null;

    private GameLength gameLength = GameLength.SHORT;

    /**
     * Private constructor to prevent instantiation
     */
    private GameSettings() {
    }

    /**
     * Static method to get instance of the game settings
     *
     * @return instance of the game settings
     * @implNote If the game settings have not been initialized, it will be initialized with default values
     */
    public static GameSettings getInstance() {
        if (instance == null)
            instance = new GameSettings();

        return instance;
    }

    /**
     * Get the game length
     *
     * @return The game length
     */
    public GameLength getGameLength() {
        return gameLength;
    }

    /**
     * Set the game length
     *
     * @param gameLength The game length
     */
    public void setGameLength(GameLength gameLength) {
        // Set the game length
        instance.gameLength = gameLength;
    }

}
