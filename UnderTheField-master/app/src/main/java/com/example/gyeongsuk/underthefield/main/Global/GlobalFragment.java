package com.example.gyeongsuk.underthefield.main.Global;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;
import com.example.gyeongsuk.underthefield.main.Domestic.CardAdapterDomestic;
import com.example.gyeongsuk.underthefield.main.Domestic.CardDataDomestic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GlobalFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private RecyclerView GlobalRecycler;
    private FirebaseDatabase database;
    private DatabaseReference GlobalRef;
    public static ArrayList<CardDataGlobal> cdg = new ArrayList<>();
    private CardAdapterGlobal<CardDataGlobal> adapter;

    private TextView globalIntro;
    public GlobalFragment() {
        // Required empty public constructor
    }

    public static GlobalFragment newInstance(String param1, String param2) {
        GlobalFragment fragment = new GlobalFragment();
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
        View view = inflater.inflate(R.layout.fragment_global, container, false);

        globalIntro=(TextView)view.findViewById(R.id.globalIntro);

        GlobalRecycler = (RecyclerView) view.findViewById(R.id.GlobalRecycler);
        adapter = new CardAdapterGlobal(cdg, R.layout.fragment_domestic_global_item, getActivity());
        GlobalRecycler.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        GlobalRecycler.setLayoutManager(manager);

        database = FirebaseDatabase.getInstance();
        GlobalRef = database.getReference("global");
        GlobalRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("check","data= "+dataSnapshot);
                cdg.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    CardDataGlobal cardDataGlobal = snapshot.getValue(CardDataGlobal.class);
                    cdg.add(cardDataGlobal);
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
