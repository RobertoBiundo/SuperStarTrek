package com.bugbinc.sst.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bugbinc.sst.common.Commands;
import com.bugbinc.sst.ui.fragments.CommandsFragment;

import java.util.ArrayList;
import java.util.List;

public class CommandsAdapter extends FragmentStateAdapter {

    private GameContentRenderer gameContentRenderer;

    public CommandsAdapter(@NonNull FragmentActivity fragmentActivity, GameContentRenderer gameContentRenderer) {
        super(fragmentActivity);
        this.gameContentRenderer = gameContentRenderer;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int startCommand = position * 4;
        int endCommand = startCommand + 4;

        if (endCommand > Commands.COMMAND_LIST.length)
            endCommand = Commands.COMMAND_LIST.length;

        List<String> fragmentCommands = new ArrayList<>();

        for (int i = 0; i < endCommand - startCommand ; i++)
            fragmentCommands.add(Commands.COMMAND_LIST[startCommand + i]);

        return new CommandsFragment(fragmentCommands, gameContentRenderer);
    }

    @Override
    public int getItemCount() {
        if (Commands.COMMAND_LIST.length % 4 > 0)
            return Commands.COMMAND_LIST.length / 4 + 1;
        return Commands.COMMAND_LIST.length;
    }
}
