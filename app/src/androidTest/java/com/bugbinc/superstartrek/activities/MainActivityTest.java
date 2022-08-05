package com.bugbinc.superstartrek.activities;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.bugbinc.superstartrek.R;
import com.bugbinc.superstartrek.game.GameLength;
import com.bugbinc.superstartrek.game.GameSettings;
import com.bugbinc.superstartrek.world.Universe;
import com.bugbinc.superstartrek.world.UniverseObject;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test for the MainActivity
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test that the application launches with an action bar
     */
    @Test
    public void appNameIsDisplayed() {
        ViewInteraction title = onView(
                allOf(withText(R.string.app_name),
                        withParent(allOf(withId(androidx.appcompat.R.id.action_bar),
                                withParent(withId(androidx.appcompat.R.id.action_bar_container)))),
                        isDisplayed()));
        title.check(matches(withText(R.string.app_name)));
    }


    /**
     * Test that the game button is displayed in the action bar
     */
    @Test
    public void newGameButtonIsDisplayed() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.action_new_game), withContentDescription(R.string.menu_action_new_game),
                        withParent(withParent(withId(androidx.appcompat.R.id.action_bar))),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
    }

    /**
     * Test that the new game dialog is displayed when the user clicks the new game button
     */
    @Test
    public void newGameAlertDialogIsDisplayedWhenNewGameButtonIsClicked() {
        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_game), withContentDescription("New Game")));
        actionMenuItemView.perform(click());

        ViewInteraction linearLayoutCompat = onView(
                allOf(withId(androidx.appcompat.R.id.parentPanel),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(androidx.appcompat.R.id.action_bar_root)))),
                        isDisplayed()));
        linearLayoutCompat.check(matches(isDisplayed()));

        ViewInteraction radioGroup = onView(
                allOf(withId(R.id.rg_GameLengthGroup),
                        withParent(withParent(withId(androidx.appcompat.R.id.custom))),
                        isDisplayed()));
        radioGroup.check(matches(isDisplayed()));

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.rb_GameLengthShort), withText("Short"),
                        withParent(allOf(withId(R.id.rg_GameLengthGroup),
                                withParent(IsInstanceOf.instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));
    }

    /**
     * Test that a user can create a new long game
     */
    @Test
    public void newGameAlertDialogStartANewLongGameIfLongGameIsSelected() {
        Universe currentUniverse = Universe.getInstance();
        UniverseObject[][] currentMap = currentUniverse.getMap();

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_game), withContentDescription("New Game")));
        actionMenuItemView.perform(click());

        ViewInteraction materialRadioButton = onView(allOf(withId(R.id.rb_GameLengthLong), withText("Long")));
        materialRadioButton.perform(click());

        ViewInteraction materialButton = onView(allOf(withId(android.R.id.button1), withText("Start")));
        materialButton.perform(scrollTo(), click());

        GameSettings gameSettings = GameSettings.getInstance();
        assert (gameSettings.getGameLength() == GameLength.LONG);

        Universe newUniverse = Universe.getInstance();
        UniverseObject[][] newMap = newUniverse.getMap();

        assert (newMap != currentMap);

    }

    /**
     * Test that a user can create a new medium game
     */
    @Test
    public void newGameAlertDialogStartANewLongGameIfMediumGameIsSelected() {
        Universe currentUniverse = Universe.getInstance();
        UniverseObject[][] currentMap = currentUniverse.getMap();

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_game), withContentDescription("New Game")));
        actionMenuItemView.perform(click());

        ViewInteraction materialRadioButton = onView(allOf(withId(R.id.rb_GameLengthMedium), withText("Medium")));
        materialRadioButton.perform(click());

        ViewInteraction materialButton = onView(allOf(withId(android.R.id.button1), withText("Start")));
        materialButton.perform(scrollTo(), click());

        GameSettings gameSettings = GameSettings.getInstance();
        assert (gameSettings.getGameLength() == GameLength.MEDIUM);

        Universe newUniverse = Universe.getInstance();
        UniverseObject[][] newMap = newUniverse.getMap();

        assert (newMap != currentMap);

    }

    /**
     * Test that a user can create a new short game
     */
    @Test
    public void newGameAlertDialogStartANewLongGameIfShortGameIsSelected() {
        Universe currentUniverse = Universe.getInstance();
        UniverseObject[][] currentMap = currentUniverse.getMap();

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_game), withContentDescription("New Game")));
        actionMenuItemView.perform(click());

        ViewInteraction materialRadioButton = onView(allOf(withId(R.id.rb_GameLengthShort), withText("Short")));
        materialRadioButton.perform(click());

        ViewInteraction materialButton = onView(allOf(withId(android.R.id.button1), withText("Start")));
        materialButton.perform(scrollTo(), click());

        GameSettings gameSettings = GameSettings.getInstance();
        assert (gameSettings.getGameLength() == GameLength.SHORT);

        Universe newUniverse = Universe.getInstance();
        UniverseObject[][] newMap = newUniverse.getMap();

        assert (newMap != currentMap);

    }
}