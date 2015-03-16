package com.kaceykaso.bestbox;

import android.support.v4.app.Fragment;


public class BestBoxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BestBoxFragment.newInstance();
    }
}
