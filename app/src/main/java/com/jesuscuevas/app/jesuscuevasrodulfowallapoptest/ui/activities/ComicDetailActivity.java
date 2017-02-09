package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.activities;

import android.os.Bundle;
import com.f2prateek.dart.InjectExtra;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.R;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.base.BaseActivity;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.fragments.ComicDetailFragment;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util.Constants;

public class ComicDetailActivity extends BaseActivity {

    @InjectExtra
    String detailPictureUrl;
    @InjectExtra
    String detailPictureExtension;
    @InjectExtra
    String detailComicTitle;
    @InjectExtra
    String detailComicDescription;

    @Override
    protected int getLayout() {
        return R.layout.activity_comic_detail;
    }

    @Override
    protected void init() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRAS_URL, detailPictureUrl);
        bundle.putString(Constants.EXTRAS_EXTENSION, detailPictureExtension);
        bundle.putString(Constants.EXTRAS_TITTLE, detailComicTitle);
        bundle.putString(Constants.EXTRAS_DESCRIPTION, detailComicDescription);
        initFragment(bundle);
    }

    private void initFragment(Bundle bundle) {
        ComicDetailFragment detailFragment = new ComicDetailFragment();
        detailFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_detail_container, detailFragment)
                .commit();
    }

}
