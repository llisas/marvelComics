package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.f2prateek.dart.Dart;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        Dart.inject(this);
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayout();
    protected abstract void init();
}
