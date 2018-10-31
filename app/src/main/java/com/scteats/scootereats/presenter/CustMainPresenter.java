package com.scteats.scootereats.presenter;

import android.view.View;

import com.scteats.scootereats.model.store.Restaurant;

import java.util.ArrayList;


/**
 * Presenter that links model classes to CustMainActivity
 */
public class CustMainPresenter {

    private View view;

    public CustMainPresenter(View view) {
        this.view = view;
    }

    public void updateList() {

        ArrayList<Restaurant> stores = new ArrayList<>();

        //TODO grab restaurants from EatsDatabase
        for (int i = 0; i < 5; i++) {
            Restaurant r = new Restaurant("Scooter Eats");
            stores.add(r);
        }

        view.updateRestaurantList(stores);
    }

    /**
     * View interface for CustMainActivity
     */
    public interface View {

        /**
         * Grabs all restaurants from database for display.
         * @param stores List of restaurants
         */
        void updateRestaurantList(ArrayList<Restaurant> stores);

    }

}
