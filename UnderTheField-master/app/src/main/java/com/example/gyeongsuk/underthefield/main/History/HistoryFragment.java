package com.example.gyeongsuk.underthefield.main.History;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;
import com.example.gyeongsuk.underthefield.main.MainActivity;

public class HistoryFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private ViewPager hPager;
    private TabLayout hTab;
    private android.support.v4.app.FragmentManager hfManager;
    private hPagerAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        hPager = (ViewPager) view.findViewById(R.id.hPager);
        hTab = (TabLayout) view.findViewById(R.id.hTab);
        hTab.addTab(hTab.newTab().setText("국내"));
        hTab.addTab(hTab.newTab().setText("국외"));


        hfManager = getChildFragmentManager();

        adapter = new hPagerAdapter(getChildFragmentManager());
        hPager.setAdapter(adapter);
        hPager.setOffscreenPageLimit(2);


        hTab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(hPager));
        hPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(hTab));



        return view;
    }

    public static class hPagerAdapter extends FragmentPagerAdapter {


        public hPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    HdomesticFragment hdf = new HdomesticFragment();
                    return hdf;
                case 1:
                    HglobalFragment hgf = new HglobalFragment();
                    return hgf;
            }
            return null;

        }

        @Override
        public int getCount() {
            return 2;
        }
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
