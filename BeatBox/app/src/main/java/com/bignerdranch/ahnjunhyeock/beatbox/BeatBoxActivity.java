package com.bignerdranch.ahnjunhyeock.beatbox;

import android.os.Bundle;

public class BeatBoxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        return BeatBoxFragment.newInstance();
    }
}
