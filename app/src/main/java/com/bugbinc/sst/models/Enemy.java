package com.bugbinc.sst.models;

import com.bugbinc.sst.common.EntityType;

public class Enemy extends Sector {

    public Enemy(EntityType type) {
        this.type = type;
    }

    // TODO: This needs to be random
    public float maxEnergy = 5000.0f;

    // TODO: This needs to be random
    public float energy = 5000.0f;

    // TODO: This needs to be random
    public float maxShieldStrength = 2500.0f;

    // TODO: This needs to be random
    public float shieldStrength = 2500.0f;

    // TODO: This needs to be random
    public boolean shieldState = false;
}
