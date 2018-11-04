package com.scteats.scootereats.view;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.scteats.scootereats.R;
import com.scteats.scootereats.presenter.MainPresenter;

/**
 * Registration screen for the user. User needs to pick account type, choose name, and set address.
 * TODO No input validation is implemented, email stored case sensitive.
 *
 * @version Sprint 1
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, MainPresenter.View {

    private RegisterLoginTask mRegisterTask = null;

    private MainPresenter mPresenter;
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordConfirmView;
    private EditText mNameView;
    private char mAccountType;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mNameView = (EditText) findViewById(R.id.name);
        mPasswordConfirmView = (EditText) findViewById(R.id.passwordConfirm);

        mPresenter = new MainPresenter(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.account_types_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Button registerButton = (Button) findViewById(R.id.button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmailView.getText().toString();
                final String password = mPasswordView.getText().toString();
                final String passwordConfirm = mPasswordConfirmView.getText().toString();
                final String name = mNameView.getText().toString();
                View focusView = null;

                if (checkPassword(password, passwordConfirm)) {
                    mRegisterTask = new RegisterLoginTask(email, password, name,
                            mAccountType, mContext);
                    mRegisterTask.execute((Void) null);
                } else {
                    mPasswordView.setError("Passwords don't match");
                    focusView = mPasswordView;
                    focusView.requestFocus();
                }
            }
        });

    }

    private boolean checkPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Array = [ C ="Hungry Person", D = "Driver", O = "Restaurant Owner"]
        if (position == 0) {
            mAccountType = 'C';
        } else if (position == 1) {
            mAccountType = 'D';
        } else if (position == 2) {
            mAccountType = 'O';
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Async task to perform database operation in background.
     * No input validation is done. Presenter methods only called in this class.
     */
    public class RegisterLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;
        private final String mName;
        private final Context mContext;
        private final char mAccountType;


        RegisterLoginTask(String email, String password, String name,
                                char accountType, Context context) {
            mEmail = email;
            mPassword = password;
            mName = name;
            mContext = context;
            mAccountType = accountType;

        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            mPresenter.registerUser(mEmail, mPassword, mName, mAccountType, mContext);
            return null;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            //No input validation, launches the next screen
            //TODO get account type and launch the appropriate activity
            finish();
            Intent myIntent = new Intent(MainActivity.this, CustMainActivity.class);
            MainActivity.this.startActivity(myIntent);

        }
    }

}

