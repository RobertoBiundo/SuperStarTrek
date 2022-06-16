package com.bugbinc.sst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bugbinc.sst.common.EntityType;
import com.bugbinc.sst.models.Enemy;
import com.bugbinc.sst.models.Enterprise;
import com.bugbinc.sst.models.Quadrant;
import com.bugbinc.sst.models.Sector;
import com.bugbinc.sst.ui.CommandsAdapter;
import com.bugbinc.sst.ui.GameContentRenderer;

public class MainActivity extends AppCompatActivity {

    public GameEngine gameEngine;
    public GameContentRenderer gameContentRenderer;

    /**
     * On activity creation, create the game engine and the game content renderer as well as setup the UI
     * @param savedInstanceState The saved instance state bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the world
        gameEngine = new GameEngine(200, 16, 3, 3, 2);
        gameEngine.initWorld();

        // Initialize the game content renderer
        gameContentRenderer = new GameContentRenderer(
                this,
                (TextView) findViewById(R.id.tv_GameContent),
                (ScrollView) findViewById(R.id.sv_GameContentScroll));

        // Initialize the commands adapter
        ViewPager2 vpCommandsContainer = findViewById(R.id.vp_CommandsContainer);
        CommandsAdapter commandsAdapter = new CommandsAdapter(this, gameContentRenderer);
        vpCommandsContainer.setAdapter(commandsAdapter);
    }


}