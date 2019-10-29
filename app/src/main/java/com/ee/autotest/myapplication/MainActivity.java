package com.ee.autotest.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 点击1、2
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doclick(View view) {
        if (view.getId() == R.id.test001) {
            MainUtil.do001();
        } else if (view.getId() == R.id.test002) {
            MainUtil.do002();
        } else if (view.getId() == R.id.test003) {
            MainUtil.do003();
        } else if (view.getId() == R.id.test005) {
            startActivity(new Intent(this, TwoActivity.class));
        } else if (view.getId() == R.id.test006) {
            generateCoverageFile();
        } else if (view.getId() == R.id.test007) {
            String i = null;
            String[] s =i.split("2");
//            reset();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
