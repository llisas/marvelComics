package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.f2prateek.dart.Dart;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(getFragmentLayout(), container,false);
        unbinder  = ButterKnife.bind(this,view);
        Dart.inject(getActivity());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter();
        getExtras();
        init();
    }

    protected abstract int getFragmentLayout();
    protected abstract void getPresenter();
    protected abstract void getExtras();
    protected abstract void init();


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
