package com.example.root.gmailexample.FragmentsClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.gmailexample.POJO.FragmentVisibility;
import com.example.root.gmailexample.R;

public class ListItemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentVisibility fragmentVisibility;

    public ListItemFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static ListItemFragment newInstance(String param1, String param2) {
        ListItemFragment fragment = new ListItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentVisibility = new FragmentVisibility();
        fragmentVisibility.setOpen(true);
        Log.e("Tag","--------"+fragmentVisibility.isOpen());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppCompatActivity activity= (AppCompatActivity) this.getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Inflate the layout for this fragment
        View rView=inflater.inflate(R.layout.fragment_list_item, container, false);
        TextView textView= (TextView) rView.findViewById(R.id.listViewItemFragment);
        if (textView!=null)
        textView.setText(mParam1);

        return rView;
    }

    @Override
    public void onStop() {
        super.onStop();
        fragmentVisibility.setOpen(false);
        Log.e("Tag","--------"+fragmentVisibility.isOpen());
    }
}

