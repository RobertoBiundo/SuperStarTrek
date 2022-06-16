package com.bugbinc.sst.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bugbinc.sst.MainActivity;
import com.bugbinc.sst.R;
import com.bugbinc.sst.common.Commands;
import com.bugbinc.sst.ui.GameContentRenderer;

import java.util.ArrayList;
import java.util.List;

public class CommandsFragment extends Fragment {

    private List<String> fragmentCommands;
    private GameContentRenderer gameContentRenderer;

    public CommandsFragment(List<String> commands, GameContentRenderer gameContentRenderer) {
        fragmentCommands = commands;
        this.gameContentRenderer = gameContentRenderer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commands, container, false);

        List<Button> commandButtons = new ArrayList<>();
        commandButtons.add(rootView.findViewById(R.id.bt_Command1));
        commandButtons.add(rootView.findViewById(R.id.bt_Command2));
        commandButtons.add(rootView.findViewById(R.id.bt_Command3));
        commandButtons.add(rootView.findViewById(R.id.bt_Command4));

        for (int i = 0; i < fragmentCommands.size(); i++) {
            String command = fragmentCommands.get(i);
            Button commandButton = commandButtons.get(i);
            commandButton.setText(command);

            if (command == Commands.CHART) {
                commandButton.setOnClickListener(v -> gameContentRenderer.RenderChart());
            }
            if (command == Commands.SHORT_RANGE_SCAN) {
                commandButton.setOnClickListener(v -> gameContentRenderer.RenderShortRangeScan());
            }
            if (command == Commands.LONG_RANGE_SCAN) {
                commandButton.setOnClickListener(v -> {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.gameEngine.revealQuadrantsAroundEnterprise();
                    gameContentRenderer.RenderLongRangeScan();
                });
            }
        }


        return rootView;
    }
}
