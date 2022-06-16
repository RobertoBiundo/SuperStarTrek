package com.bugbinc.sst;

import com.bugbinc.sst.common.EntityType;
import com.bugbinc.sst.models.Enemy;
import com.bugbinc.sst.models.Enterprise;
import com.bugbinc.sst.models.Quadrant;
import com.bugbinc.sst.models.Sector;

public class GameEngine {

    public Quadrant[][] quadrants;
    public Enterprise enterprise;

    private int initialStarCount;
    private int initialKlingonCount;
    private int initialRomulanCount;
    private int initialPlanetCount;
    private int initialBaseCount;

    public GameEngine(int initialStarCount, int initialKlingonCount, int initialRomulanCount, int initialPlanetCount, int initialBaseCount) {
        this.initialStarCount = initialStarCount;
        this.initialKlingonCount = initialKlingonCount;
        this.initialRomulanCount = initialRomulanCount;
        this.initialPlanetCount = initialPlanetCount;
        this.initialBaseCount = initialBaseCount;
    }

    /**
     * Initializes the game world to empty quadrants
     * Sets randomized stars, planets, enemies, bases and the enterprise
     */
    public void initWorld() {
        quadrants = new Quadrant[8][8];

        for (int quadX = 0; quadX < 8; quadX++) {
            for (int quadY = 0; quadY < 8; quadY++) {
                Quadrant quadrant = new Quadrant();
                for (int sectX = 0; sectX < 10; sectX++) {
                    for (int sectY = 0; sectY < 10; sectY++) {
                        Sector sector = new Sector();
                        quadrant.sectors[sectX][sectY] = sector;
                    }
                }
                quadrants[quadX][quadY] = quadrant;
            }
        }

        // Add Enterprise
        initRandomSector(EntityType.ENTERPRISE);

        // Add Stars
        for (int i = 0; i < initialStarCount; i ++)
            initRandomSector(EntityType.STAR);

        // Add Klingons
        for (int i = 0; i < initialKlingonCount; i ++)
            initRandomSector(EntityType.KLINGON);

        // Add Romulans
        for (int i = 0; i < initialRomulanCount; i ++)
            initRandomSector(EntityType.ROMULAN);

        // Add Bases
        for (int i = 0; i < initialBaseCount; i ++)
            initRandomSector(EntityType.BASE);

        // Add Bases
        for (int i = 0; i < initialPlanetCount; i ++)
            initRandomSector(EntityType.PLANET);
    }

    /**
     * Marks a range of quadrants around the enterprise as revealed in a square pattern
     * Avoids setting invalid quadrants if they are out of bounds
     */
    public void revealQuadrantsAroundEnterprise() {
        for (int quadX = enterprise.currentQuadrantX - 1; quadX <= enterprise.currentQuadrantX + 1; quadX++) {
            for (int quadY = enterprise.currentQuadrantY - 1; quadY <= enterprise.currentQuadrantY + 1; quadY++) {
                if (quadX > -1 && quadY > -1 && quadX < 8 && quadY < 8) {
                    Quadrant quadrant = quadrants[quadX][quadY];
                    quadrant.isRevealed = true;
                }
            }
        }
    }

    /**
     * Initializes a random sector to the given type and updates the quadrant object counts
     * It will avoid setting more than 9 objects in a sector or reassigning a sector that is not empty
     * @param type The type to initialize the sector to
     */
    private void initRandomSector(EntityType type) {
        int quadX = (int)Math.floor(Math.random()*(8));
        int quadY = (int)Math.floor(Math.random()*(8));
        int sectorX = (int)Math.floor(Math.random()*(10));
        int sectorY = (int)Math.floor(Math.random()*(10));

        if (quadrants[quadX][quadY].sectors[sectorX][sectorY].type != EntityType.EMPTY)
            initRandomSector(type);

        switch (type){
            case EMPTY:
                break;
            case ENTERPRISE:
                enterprise = new Enterprise(quadX, quadY, sectorX, sectorY);
                quadrants[quadX][quadY].sectors[sectorX][sectorY] = enterprise;
                quadrants[quadX][quadY].isRevealed = true;
                break;
            case STAR:
                quadrants[quadX][quadY].sectors[sectorX][sectorY].type = EntityType.STAR;
                if (quadrants[quadX][quadY].starsCount == 9) {
                    initRandomSector(type);
                    return;
                }
                quadrants[quadX][quadY].starsCount++;
                break;
            case PLANET:
                quadrants[quadX][quadY].sectors[sectorX][sectorY].type = EntityType.PLANET;
                break;
            case BASE:
                quadrants[quadX][quadY].sectors[sectorX][sectorY].type = EntityType.BASE;
                if (quadrants[quadX][quadY].basesCount == 9) {
                    initRandomSector(type);
                    return;
                }
                quadrants[quadX][quadY].basesCount++;
                break;
            case KLINGON:
                quadrants[quadX][quadY].sectors[sectorX][sectorY] = new Enemy(EntityType.KLINGON);
                if (quadrants[quadX][quadY].enemyCount == 9) {
                    initRandomSector(type);
                    return;
                }
                quadrants[quadX][quadY].enemyCount++;
                break;
            case ROMULAN:
                quadrants[quadX][quadY].sectors[sectorX][sectorY] = new Enemy(EntityType.ROMULAN);
                if (quadrants[quadX][quadY].enemyCount == 9) {
                    initRandomSector(type);
                    return;
                }
                quadrants[quadX][quadY].enemyCount++;
                break;
        }
    }
}
