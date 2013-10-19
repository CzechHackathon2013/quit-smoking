package cz.czechhackathon.test;

import android.test.ActivityInstrumentationTestCase2;
import cz.czechhackathon.*;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testActivity() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}

