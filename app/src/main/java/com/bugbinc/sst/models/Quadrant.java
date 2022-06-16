package com.bugbinc.sst.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Quadrant {

    public boolean isRevealed = false;

    public Sector[][] sectors = new Sector[10][10];

    public int starsCount;

    public int enemyCount;

    public int basesCount;
}
