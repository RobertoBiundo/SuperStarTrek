package com.bugbinc.sst.ui;

import android.widget.ScrollView;
import android.widget.TextView;

import com.bugbinc.sst.MainActivity;
import com.bugbinc.sst.models.Enterprise;
import com.bugbinc.sst.models.Quadrant;
import com.bugbinc.sst.models.Sector;

public class GameContentRenderer {

    private String gameContent;
    private TextView tvGameContent;
    private MainActivity mainActivity;
    private ScrollView svGameContentScroll;

    public GameContentRenderer(MainActivity mainActivity, TextView gameContent, ScrollView gameContentScroll) {
        this.tvGameContent = gameContent;
        this.gameContent = "";
        this.mainActivity = mainActivity;
        this.svGameContentScroll = gameContentScroll;
    }

    /**
     * Renders the current known state of the world
     */
    public void RenderChart() {
        addEmptyLine();
        addLine("STAR CHART FOR THE KNOWN GALAXY");
        addEmptyLine();
        addLine("      1    2    3    4    5    6    7    8");
        addLine("    ---------------------------------------");
        addLine("  -");
        for(int quadY = 0; quadY < 8; quadY++) {
            String line = String.format("%d -", quadY + 1);
            for (int quadX = 0; quadX < 8; quadX++) {
                Quadrant quadrant = mainActivity.gameEngine.quadrants[quadX][quadY];
                if (quadrant.isRevealed)
                    line += String.format("  %d%d%d", quadrant.enemyCount, quadrant.basesCount, quadrant.starsCount);
                else if(quadrant.basesCount > 0)
                    line += String.format("  .%d.", quadrant.basesCount);
                else
                    line += "  ...";
            }
            addLine(line);
        }
    }

    /**
     * Renders the current known state of the sector enterprise is at
     */
    public void RenderShortRangeScan() {
        Enterprise enterprise = mainActivity.gameEngine.enterprise;
        addEmptyLine();
        addLine(String.format("SHORT-RANGE SCAN OF QUADRANT %d - %d", enterprise.currentQuadrantY + 1, enterprise.currentQuadrantX + 1));
        addEmptyLine();
        addLine("   1  2  3  4  5  6  7  8  9 10");
        Quadrant quadrant = mainActivity.gameEngine.quadrants[enterprise.currentQuadrantX][enterprise.currentQuadrantY];

        for (int sectorY = 0; sectorY < 10; sectorY++) {
            String line;
            if (sectorY < 9)
                line = String.format("%d ",sectorY + 1);
            else
                line = String.format("%d",sectorY + 1);
            for (int sectorX = 0; sectorX < 10; sectorX++) {
                Sector sector = quadrant.sectors[sectorX][sectorY];
                switch (sector.type) {
                    case EMPTY:
                        line += " . ";
                        break;
                    case ENTERPRISE:
                        line += " E ";
                        break;
                    case STAR:
                        line += " * ";
                        break;
                    case PLANET:
                        line += " P ";
                        break;
                    case BASE:
                        line += " B ";
                        break;
                    case KLINGON:
                        line += " K ";
                        break;
                    case ROMULAN:
                        line += " R ";
                        break;
                }
            }
            addLine(line);
        }
    }

    /**
     * Renders the current known state of the quadrants around the enterprise
     */
    public void RenderLongRangeScan() {
        addEmptyLine();
        Enterprise enterprise = mainActivity.gameEngine.enterprise;
        addLine(String.format("LONG-RANGE SCAN FOR QUADRANT %d - %d", enterprise.currentQuadrantY + 1, enterprise.currentQuadrantX + 1));
        addEmptyLine();

        for(int quadY = enterprise.currentQuadrantY - 1; quadY <= enterprise.currentQuadrantY + 1; quadY++) {
            String line = "";
            for(int quadX = enterprise.currentQuadrantX - 1; quadX <= enterprise.currentQuadrantX + 1; quadX++) {
                if(quadX > -1 && quadY > -1 && quadX < 8 && quadY < 8) {
                    Quadrant quadrant = mainActivity.gameEngine.quadrants[quadX][quadY];
                    line += String.format("  %d%d%d", quadrant.enemyCount, quadrant.basesCount, quadrant.starsCount);
                }
                else
                    line +="   -1";
            }
            addLine(line);
        }

    }

    /**
     * Adds a line of text to the game content and scroll the view to the bottom
     * @param string The line of text to add
     */
    private void addLine(String string) {
        gameContent += "\n" + string;
        tvGameContent.setText(gameContent);
        svGameContentScroll.post(() -> svGameContentScroll.fullScroll(ScrollView.FOCUS_DOWN));
    }

    /**
     * Adds an empty line to the game content and scroll the view to the bottom
     */
    private void addEmptyLine() {
        addLine("\n");
    }
}
