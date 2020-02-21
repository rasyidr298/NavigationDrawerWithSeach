package com.rrdev.navigationdrawer.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rrdev.navigationdrawer.R;
import com.rrdev.navigationdrawer.adapter.RecyclerViewAdapter;
import com.rrdev.navigationdrawer.model.DataModel;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    private RecyclerViewAdapter adapter;
    private ArrayList<DataModel> mItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_recycler,container,false);
        setHasOptionsMenu(true);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        //Menggunakan Layout Manager dan Membuat List Secara Vertikal
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //Membuat Underline pada setiap item didalam list
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.ic_line));
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Grid Layout
        recyclerView.setLayoutManager(new GridLayoutManager(FragmentTwo.this.getActivity(),2));
        addData();

        //set adapter
        adapter = new RecyclerViewAdapter(FragmentTwo.this.getActivity(),mItems,null);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void addData() {
        mItems = new ArrayList<>();
        mItems.add(new DataModel(R.drawable.ic_account,
                "aaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        mItems.add(new DataModel(R.drawable.ic_person,
                "bbb",
                "bbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        mItems.add(new DataModel(R.drawable.ic_sentiment,
                "ccc",
                "cccccccccccccccccccc"));
        mItems.add(new DataModel(R.drawable.ic_smile,
                "ddd",
                "ddddddddddddddddddddddddddd"));
        mItems.add(new DataModel(R.drawable.ic_account,
                "fff",
                "eeeeeeeeeeeeeeeeeeeeeee"));
        mItems.add(new DataModel(R.drawable.ic_person,
                "ggg",
                "fffffffffffffffffffff"));
        mItems.add(new DataModel(R.drawable.ic_sentiment,
                "hhh",
                "ggggggggggggggggggggggggggggggg"));
        mItems.add(new DataModel(R.drawable.ic_smile,
                "iii",
                "ddddddddddddddddddddddddddddd"));
    }

    //Code Program pada Method dibawah ini akan Berjalan saat Option Menu Dibuat
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView  = new SearchView(getActivity());
        searchView.setQueryHint("Cari Sesuatu..");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                //Data akan berubah saat user menginputkan text/kata kunci pada SearchView
                nextText = nextText.toLowerCase();
                ArrayList<DataModel> dataFilter = new ArrayList<>();
                for(DataModel data : mItems){
                    String nama = data.getName().toLowerCase();
                    if(nama.contains(nextText)){
                        dataFilter.add(data);
                    }
                }
                adapter.setFilter(dataFilter);
                return true;
            }
        });
        searchItem.setActionView(searchView);
    }
}
