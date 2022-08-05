package com.bugbinc.superstartrek.fragments;

import androidx.fragment.app.DialogFragment;

/**
 * This interface is used to communicate with the activity that created the dialog fragment.
 * The activity must implement this interface.
 */
public interface NewGameDialogFragmentListener {

    /**
     * This method is called when the user clicks the "Start Game" button in the dialog.
     * At this point the new universe has been created and the activity can start/restart the game.
     *
     * @param dialog The dialog that was shown.
     */
    void onNewGameStarted(DialogFragment dialog);
}
