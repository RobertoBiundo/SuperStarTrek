package com.bugbinc.superstartrek.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.bugbinc.superstartrek.R;
import com.bugbinc.superstartrek.fragments.NewGameDialogFragment;
import com.bugbinc.superstartrek.fragments.NewGameDialogFragmentListener;

public class MainActivity extends AppCompatActivity implements NewGameDialogFragmentListener {

    /**
     * This method is called when the activity is first created.
     *
     * @param savedInstanceState the saved instance if this activity is being recreated.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * This method is called when the user clicks the menu button.
     *
     * @param item The menu item that was clicked.
     * @return True if the menu item was handled, false otherwise.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_game:
                NewGameDialogFragment dialog = new NewGameDialogFragment();
                dialog.show(getSupportFragmentManager(), "NewGameDialogFragment");
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * This method is called when the user clicks the "Start Game" button in the "new game" dialog.
     *
     * @param dialog The dialog that was shown.
     */
    @Override
    public void onNewGameStarted(DialogFragment dialog) {

    }
}