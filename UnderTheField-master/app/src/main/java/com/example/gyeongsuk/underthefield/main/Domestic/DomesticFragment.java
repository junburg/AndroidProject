package com.example.gyeongsuk.underthefield.main.Domestic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;
import com.example.gyeongsuk.underthefield.main.History.CardAdapterHdomestic;
import com.example.gyeongsuk.underthefield.main.History.CardDataHdomestic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DomesticFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView DomesticRecycler;
    private FirebaseDatabase database;
    private DatabaseReference DomesticRef;
    public static ArrayList<CardDataDomestic> cdd = new ArrayList<>();
    private CardAdapterDomestic<CardDataDomestic> adapter;

    private TextView domesticIntro;

    public DomesticFragment() {
        // Required empty public constructor
    }


    public static DomesticFragment newInstance(String param1, String param2) {
        DomesticFragment fragment = new DomesticFragment();
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

        View view = inflater.inflate(R.layout.fragment_domestic, container, false);

        domesticIntro=(TextView)view.findViewById(R.id.domesticIntro);
        DomesticRecycler = (RecyclerView) view.findViewById(R.id.DomesticRecycler);
        adapter = new CardAdapterDomestic(cdd, R.layout.fragment_domestic_global_item, getActivity());
        DomesticRecycler.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DomesticRecycler.setLayoutManager(manager);

        database = FirebaseDatabase.getInstance();
        DomesticRef = database.getReference("domestic");
        DomesticRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("check","data= "+dataSnapshot);
                cdd.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    CardDataDomestic cardDataDomestic = snapshot.getValue(CardDataDomestic.class);
                    cdd.add(cardDataDomestic);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
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
