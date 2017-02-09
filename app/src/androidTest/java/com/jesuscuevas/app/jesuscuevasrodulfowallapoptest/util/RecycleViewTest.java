package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.activities.MainActivity;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.mockServer.helpers.RestServiceTestHelper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(AndroidJUnit4.class)
public class RecycleViewTest extends InstrumentationTestCase {


    private static final int FINAL_ITEM = Constants.API_RESULT_LIMIT;
    private String baseUrl;

    @Rule
    private MockWebServer server;
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        baseUrl = server.url("/").toString();
    }

    @Test
    public void scrollToAndCheckItsText() throws Exception {

        String filename = "marvel.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper
                        .getStringFromFile(getInstrumentation().getContext(), filename)));
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
    }

}
