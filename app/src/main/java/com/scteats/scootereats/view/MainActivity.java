package com.scteats.scootereats.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.scteats.scootereats.R;
import com.scteats.scootereats.presenter.MainPresenter;

//TODO implement this class.

/**
 * Registration screen for the user. User needs to pick account type, choose name, and set address.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, MainPresenter.View {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Attach textviews/


        presenter = new MainPresenter();



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.account_types_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Array = [ C ="Hungry Person", D = "Driver", O = "Restaurant Owner"]
        if (position == 0) {
            presenter.setUserType('C');
        } else if (position == 1) {
            presenter.setUserType('D');
        } else if (position == 2) {
            presenter.setUserType('O');
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
