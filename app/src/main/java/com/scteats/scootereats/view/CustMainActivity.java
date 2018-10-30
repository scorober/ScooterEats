package com.scteats.scootereats.view;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;

import com.scteats.scootereats.R;
import com.scteats.scootereats.model.store.Restaurant;
import com.scteats.scootereats.presenter.CustMainPresenter;

import java.util.ArrayList;

//https://developer.android.com/guide/topics/ui/layout/listview#java
//TODO switch to card based layout


public class CustMainActivity extends ListActivity implements CustMainPresenter.View, LoaderManager.LoaderCallbacks<Cursor> {

    //Adapter used to display the lists data.
    SimpleCursorAdapter mAdapter;

    private CustMainPresenter presenter;
    private ArrayList<Restaurant> stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pass reference of activity to presenter
        presenter = new CustMainPresenter(this);

        //Presenter updates list of restaurants.
        presenter.updateList();
        setListAdapter(new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1, stores));



    }

    @Override
    public void updateRestaurantList(ArrayList<Restaurant> theStores) {
        stores = theStores;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
