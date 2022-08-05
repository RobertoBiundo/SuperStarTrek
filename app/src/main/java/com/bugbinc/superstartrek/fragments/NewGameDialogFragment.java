package com.bugbinc.superstartrek.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bugbinc.superstartrek.R;
import com.bugbinc.superstartrek.game.GameLength;
import com.bugbinc.superstartrek.game.GameSettings;
import com.bugbinc.superstartrek.world.Universe;

public class NewGameDialogFragment extends DialogFragment {

    NewGameDialogFragmentListener listener;

    /**
     * Create a new instance of the dialog fragment
     *
     * @return The new instance of the dialog fragment
     * @implNote On affirmative click, a new universe will be created, the game settings will be updated and the listener will be called
     * @implNote On negative click, the dialog will be dismissed
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_new_game, null);

        builder.setView(dialogView);
        builder.setPositiveButton(R.string.new_game_dialog_start, (dialog, id) -> {
            GameLength gameLength = ((RadioButton) dialogView.findViewById(R.id.rb_GameLengthLong)).isChecked() ? GameLength.LONG :
                    ((RadioButton) dialogView.findViewById(R.id.rb_GameLengthMedium)).isChecked() ? GameLength.MEDIUM : GameLength.SHORT;

            GameSettings gameSettings = GameSettings.getInstance();
            gameSettings.setGameLength(gameLength);

            Universe universe = Universe.getInstance();
            universe.initializeMapUsingGameSettings();

            listener.onNewGameStarted(this);
        });

        builder.setNegativeButton(R.string.new_game_dialog_cancel, null);

        return builder.create();
    }

    /**
     * Called when the fragment is attached to its context (activity)
     * Here we save an instance of the activity's implementation of the listener interface
     * The activity must implement the NewGameDialogFragmentListener interface
     *
     * @param context The context of the activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (NewGameDialogFragmentListener) context;
    }
}
