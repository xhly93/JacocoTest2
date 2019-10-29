package com.ee.autotest.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class TwoActivity extends BaseActivity {
    private static final String TAG = "TwoActivity";
    ThreeUtil threeUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        threeUtil = new ThreeUtil();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void doclick(View view) {
        if (view.getId() == R.id.qqq) {
            TwoUtils.do001();
        } else if (view.getId() == R.id.www) {
            TwoUtils.do002();
        }else if (view.getId() == R.id.eee) {
            TwoUtils.do003();
        }else if (view.getId() == R.id.rrr) {
            threeUtil.doHaha();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
