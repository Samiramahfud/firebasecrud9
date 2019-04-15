package org.jplas.android.basicui;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test201091 extends ViewTest {
    private MyActivity activity;
    ResourceTest rsc;

    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
        //packName = activity.getPackageName();
        rsc = new ResourceTest(activity.getResources());
    }

    @Test
    public void check_01_Image_Resources() {
        rsc.testImgResource("formula");
    }
}
