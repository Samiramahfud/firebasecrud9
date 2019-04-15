package org.jplas.android.basicui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test201061 extends ViewTest {
    private MyActivity activity;
    ResourceTest rsc;

    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MyActivity.class).create().get();
        rsc = new ResourceTest(activity.getResources());
    }

    @Test
    public void check_01_StringArray_Distance() {
        String[] expected = "Mtr,Inc,Mil,Ft".split("\\,");
        rsc.testStringArrayResource("distList",expected);
    }

    @Test
    public void check_02_StringArray_Weight() {
        String[] expected = "Grm,Onc,Pnd".split("\\,");
        rsc.testStringArrayResource("weightList",expected);
    }

    @Test
    public void check_03_Image_Resources() {
        rsc.testImgResource("distance");
        rsc.testImgResource("weight");
    }
}
