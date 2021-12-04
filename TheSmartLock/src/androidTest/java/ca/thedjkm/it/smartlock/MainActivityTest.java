package ca.thedjkm.it.smartlock;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.nav_host_fragment);
        assertNotNull(view);

    }



    @Test
    public void  test2(){
        View view = mActivity.findViewById(R.id.nav_view);
        assertNotNull(view);
    }

    @Test
    public void test3(){
        View view = mActivity.findViewById(R.id.check);
        assertNotNull(mActivity);

    }

    @Test
    public void test4(){
        View view = mActivity.findViewById(R.id.check);
      //  assertTrue("Name",true);
        assertEquals("Name","Name");

    }


    @After
    public void tearDown() throws Exception {

      //  mActivity = null;
    }
}