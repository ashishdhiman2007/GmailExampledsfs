package com.example.root.gmailexample.FragmentsClass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.root.gmailexample.ListAdapter.CustomListAdapter;
import com.example.root.gmailexample.POJO.ItemObject;
import com.example.root.gmailexample.R;

import java.util.ArrayList;

/**
 * Created by root on 22/8/16.
 */

public class ListWithinFragment extends Fragment {

    public ListWithinFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_list, container, false);
        ArrayList<ItemObject> objectArrayList = getData();
        ListView lv = (ListView)rootView.findViewById(R.id.textViewListItemFragment);
        AppCompatActivity activity= (AppCompatActivity) this.getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        activity.getSupportActionBar().setHomeButtonEnabled(true);



        lv.setAdapter(new CustomListAdapter(getActivity(), objectArrayList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.flContent,ListItemFragment.newInstance(String.valueOf(i),null), "fragment_screen");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootView;
    }






    private ArrayList<ItemObject> getData() {
        ArrayList<ItemObject> list = new ArrayList<>();

        ItemObject movies1 = new ItemObject();
        movies1.setTitle("Kingsman: The Secret Service ");
        movies1.setImageIcon(R.drawable.gmail_logo);
        list.add(movies1);

        ItemObject movies2 = new ItemObject();
        movies2.setTitle("Birdman: Or (The Unexpected Virtue of Ignorance)");
        movies2.setImageIcon(R.drawable.gmail_logo);
        list.add(movies2);

        ItemObject movies3 = new ItemObject();
        movies3.setTitle("American Sniper");
        movies3.setImageIcon(R.drawable.gmail_logo);
        list.add(movies3);

        ItemObject movies4 = new ItemObject();
        movies4.setTitle("Whiplash");
        movies4.setImageIcon(R.drawable.gmail_logo);
        list.add(movies4);

        ItemObject movies5 = new ItemObject();
        movies5.setTitle("Big Hero");
        movies5.setImageIcon(R.drawable.gmail_logo);
        list.add(movies5);

        ItemObject movies6 = new ItemObject();
        movies6.setTitle("The Imitation Game");
        movies6.setImageIcon(R.drawable.gmail_logo);
        list.add(movies6);

        ItemObject movies7 = new ItemObject();
        movies7.setTitle("John Wick");
        movies7.setImageIcon(R.drawable.gmail_logo);
        list.add(movies7);

        return list;

    }


}
