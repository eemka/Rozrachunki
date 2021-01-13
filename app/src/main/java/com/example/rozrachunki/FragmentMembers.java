package com.example.rozrachunki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMembers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMembers extends Fragment {

    Button addMember;
    public static Activity thisActivity;
    final String[] items = new String[] { "Jarek Kaczmarek", "Angelika Kalika", "Kacper Kaca",
            "Kamila Idylla", "Marek Parek", "Iza Ibiza", "Emilia Cecylia" };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMembers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMembers.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMembers newInstance(String param1, String param2) {
        FragmentMembers fragment = new FragmentMembers();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int count = 1;
        //Jeśli nie ma członków to wyświetl tego TextView
        if (count == 0)
        {
            RelativeLayout llMain = view.findViewById(R.id.relative1);
            TextView textView = new TextView(view.getContext());
            textView.setText("Jesteś tu sam! Dodaj nowego członka, aby móc tworzyć rozliczenia!");
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
            );
            textView.setLayoutParams(params);
            textView.setTextSize(15);
            textView.setPadding(50,50,50,50);
            textView.setGravity(Gravity.CENTER);
            llMain.addView(textView);
        }
        //Jeśli są członkowie to wyświetl listview
        else if (count == 1)
        {
         // nie wiem czy może zostać listview ale jego po prostu łatwiej mi było oprogramować
            ListView list = (ListView)view.findViewById(R.id.listviewFragment1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
            list.setAdapter(adapter);
        }




        addMember = view.findViewById(R.id.add_memberBTN);
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), AddFriendsActivity.class);
                //view.getContext().startActivity(intent);
            }
        });

    }

}