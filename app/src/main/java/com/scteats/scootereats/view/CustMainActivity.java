package com.scteats.scootereats.view;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.scteats.scootereats.R;
import com.scteats.scootereats.model.store.Restaurant;
import com.scteats.scootereats.presenter.CustMainPresenter;

import java.util.ArrayList;

public class CustMainActivity extends ListActivity implements CustMainPresenter.View{

    private CustMainPresenter presenter;
    private ArrayList<Restaurant> stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CustMainPresenter(this);
        presenter.updateList();
        setListAdapter(new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1, stores));
        //Autogen
//        setContentView(R.layout.activity_cust_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);




//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    @Override
    public void updateRestaurantList(ArrayList<Restaurant> theStores) {
        stores = theStores;
    }
}
