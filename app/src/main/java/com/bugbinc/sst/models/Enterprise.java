package com.bugbinc.sst.models;

import com.bugbinc.sst.common.EntityType;

public class Enterprise extends Sector {

    public Enterprise(int currentQuadrantX, int currentQuadrantY, int currentSectorX, int currentSectorY) {
        this.currentQuadrantX = currentQuadrantX;
        this.currentQuadrantY = currentQuadrantY;
        this.currentSectorX = currentSectorX;
        this.currentSectorY = currentSectorY;
        type = EntityType.ENTERPRISE;
    }

    public int currentQuadrantX;

    public int currentQuadrantY;

    public int currentSectorX;

    public int currentSectorY;

    public float maxEnergy = 5000.0f;

    public float energy = 5000.0f;

    public float maxShieldStrength = 2500.0f;

    public float shieldStrength = 2500.0f;

    public boolean shieldState = false;

    public float lifeSupport = 4.0f;

    public float lifeSupportReserves = 4.0f;

    public int photonTorpedos = 10;

    //TODO: This needs to be random 2-4
    public int probes = 3;

    public float warpFactor = 5.0f;
}
