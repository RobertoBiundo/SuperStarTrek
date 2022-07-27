package com.bugbinc.superstartrek.world;

public class UniverseObject {

    // TYPE
    private UniverseObjectType type = UniverseObjectType.EMPTY;


    /**
     * Getter for the type
     *
     * @return type
     */
    public UniverseObjectType getType() {
        return type;
    }

    /**
     * Setter for the type
     *
     * @param type
     */
    public void setType(UniverseObjectType type) {
        this.type = type;
    }
}
