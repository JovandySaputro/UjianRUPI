package com.example.ujianrupi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private Context mContext;
    private RecyclerView listOrder;
    private ArrayList<ListInfo> DataDummy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        mContext = getContext();
        listOrder = v.findViewById(R.id.list_dummy);
        listOrder.setHasFixedSize(true);
        listOrder.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        listOrder.setLayoutManager(staggeredGridLayoutManager);

        addData();
        showProducts();
        return v;
    }

    private void showProducts() {
        RecyclerView.Adapter mAdapterEtalase = new ListAdapter(mContext,DataDummy);
        listOrder.setAdapter(mAdapterEtalase);
    }

    private void addData(){
        DataDummy = new ArrayList<>();
        DataDummy.add(new ListInfo("INV/001", "22 Januari 2020","Jovandy Saputro", "23"));
        DataDummy.add(new ListInfo("INV/002", "25 Januari 2020","Farhan", "24"));
        DataDummy.add(new ListInfo("INV/003", "29 Januari 2020","Daniel", "25"));
        DataDummy.add(new ListInfo("INV/004", "22 Januari 2020","Haiqal", "23"));
        DataDummy.add(new ListInfo("INV/005", "25 Januari 2020","Sintiya", "24"));

    }
}