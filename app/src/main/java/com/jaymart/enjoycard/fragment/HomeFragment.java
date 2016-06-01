package com.jaymart.enjoycard.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jaymart.enjoycard.R;

import butterknife.ButterKnife;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.util.TypefaceManager;


/**
 * Created by kongmono on 6/30/15.
 */

public class HomeFragment extends Fragment {

    TypefaceManager fontManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontManager = new TypefaceManager(getActivity().getAssets());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        //for crate home butt
        View toolbar = ((MaterialNavigationDrawer) getActivity()).getToolbar().findViewById(R.id.toolbar);

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setTypeface(fontManager.getTBold());
        title.setText("Header");


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
