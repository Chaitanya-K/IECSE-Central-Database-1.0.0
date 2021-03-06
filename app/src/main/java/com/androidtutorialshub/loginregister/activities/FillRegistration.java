package com.androidtutorialshub.loginregister.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.helpers.InputValidation;
import com.androidtutorialshub.loginregister.model.Attendance;
import com.androidtutorialshub.loginregister.model.Member;
import com.androidtutorialshub.loginregister.model.Registration;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

/**
 * Created by mahe on 4/9/2017.
 */

public class FillRegistration extends AppCompatActivity implements View.OnClickListener{

    private DatabaseHelper databaseHelper;

    private final AppCompatActivity activity = FillRegistration.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutMID;
    private TextInputLayout textInputLayoutNID;
    private TextInputLayout textInputLayoutEID;





    private TextInputEditText textInputEditTextMID;
    private TextInputEditText textInputEditTextNID;
    private TextInputEditText textInputEditTextEID;


    private AppCompatButton appCompatButtonViewRegistration;
    private AppCompatTextView appCompatTextViewRegistrationLink;

    private InputValidation inputValidation;
    private Registration registration;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Enter","bef f");
        setContentView(R.layout.registration_fill);
        getSupportActionBar().hide();
        Log.d("Enter","afetr f");
        initViews();
        Log.d("Enter","view");
        initListeners();
        Log.d("Enter","liste");
        initObjects();
        Log.d("Enter","End");

    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView4);

        textInputLayoutMID = (TextInputLayout) findViewById(R.id.textInputLayoutMID4);
        textInputLayoutNID = (TextInputLayout) findViewById(R.id.textInputLayoutNID4);
        textInputLayoutEID = (TextInputLayout) findViewById(R.id.textInputLayoutEID4);



        textInputEditTextMID = (TextInputEditText) findViewById(R.id.textInputEditTextMID4);
        textInputEditTextNID = (TextInputEditText) findViewById(R.id.textInputEditTextNID4);
        textInputEditTextEID = (TextInputEditText) findViewById(R.id.textInputEditTextEID4);


        appCompatButtonViewRegistration = (AppCompatButton) findViewById(R.id.appCompatButtonViewRegistration);
        appCompatTextViewRegistrationLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewRegistration);


    }

    private void initListeners() {
        appCompatButtonViewRegistration.setOnClickListener(this);
        appCompatTextViewRegistrationLink.setOnClickListener(this);
    }
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        registration = new Registration();


    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.appCompatButtonViewRegistration:
                addMemberToSQLite();
                break;
            case R.id.appCompatTextViewRegistration:
                Intent accountsIntentAtte = new Intent(activity, ViewRegistration.class);
                startActivity(accountsIntentAtte);
                break;
        }
    }

    private void addMemberToSQLite() {


        if (!inputValidation.isInputEditTextFilled(textInputEditTextMID, textInputLayoutMID, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextNID, textInputLayoutNID, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEID, textInputLayoutEID, getString(R.string.error_message_email))) {
            return;
        }



        //databaseHelper.getWritableDatabase().execSQL("insert into event (name,venue,type) values ('Codemeets','AB5','Tech');");
        //databaseHelper.getWritableDatabase().execSQL("insert into non_member (name,email,mobile) values ('abc','ashbcs@gmail.com','12351235');");
        //databaseHelper.getWritableDatabase().execSQL("insert into event (name,venue,type) values ('abc','ashbcs@gmail.com','Dev');");

        // databaseHelper.getWritableDatabase().execSQL("insert into member (name,email,mobile,dept,access_level) values ('abc','ashbcs@gmail.com','12351235','Tech','2');");
        databaseHelper.getWritableDatabase().execSQL("insert into registration (memId,nmID,eventID) values ("+
                Integer.parseInt(textInputEditTextMID.getText().toString().trim())+","+
                Integer.parseInt(textInputEditTextNID.getText().toString().trim())+","+
                Integer.parseInt(textInputEditTextEID.getText().toString().trim())+ ");");

        // Snack Bar to show success message that record saved successfully
        Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();



    }

}
