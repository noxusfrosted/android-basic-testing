package cc.somkiat.basicunittesting;

import android.os.SystemClock;
import android.support.test.espresso.Root;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveCorrectInput(){

        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(click());
        onView(withId(R.id.userNameInput)).perform(replaceText("Nathapath"));
        onView(withId(R.id.emailInput)).perform(replaceText("ntpm96@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(click());
        clearData();
        SystemClock.sleep(1000);

    }

    @Test
    public void saveWithEmptyName(){

        closeSoftKeyboard();
        onView(withId(R.id.emailInput)).perform(replaceText("ntpm96@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("Name is empty")).inRoot(getToastView()).check(matches(isDisplayed()));
        clearData();
        SystemClock.sleep(1000);
    }

    @Test
    public void saveWithInvalidName() {

        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Nathapath Mang Korn"));
        onView(withId(R.id.emailInput)).perform(replaceText("ntpm96@hotmail.com"));
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("Name Pattern is incorrect")).inRoot(getToastView()).check(matches(isDisplayed()));
        clearData();
        SystemClock.sleep(1000);
    }

    @Test
    public void saveWithEmptyEmail(){

        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Nathapath"));
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("Email is empty")).inRoot(getToastView()).check(matches(isDisplayed()));
        clearData();
        SystemClock.sleep(1000);
    }



    @Test
    public void saveWithInvalidEmail() {

        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(replaceText("Nathapath"));
        onView(withId(R.id.emailInput)).perform(replaceText("ntpm96"));
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("Email Pattern is incorrect")).inRoot(getToastView()).check(matches(isDisplayed()));
        clearData();
        SystemClock.sleep(1000);

    }

    @Test
    public void clearData() {

        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
        SystemClock.sleep(1000);

    }

    private Matcher<Root> getToastView() {
        return withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())));
    }

}
