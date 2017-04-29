package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.adapters.MembersRecyclerAdapter;
import com.androidtutorialshub.loginregister.adapters.UsersRecyclerAdapter;
import com.androidtutorialshub.loginregister.model.Member;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 10/10/2016.
 */

public class ViewMember extends AppCompatActivity {

    private AppCompatActivity activity = ViewMember.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewMembers;
    private List<Member> listMembers;
    private MembersRecyclerAdapter membersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    public String s="";





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_view);
        getSupportActionBar().setTitle("IECSE Central Database");
        Log.d("Enter","init");

        final Button getMemBt = (Button) findViewById(R.id.buttonGetByMemID);
        final EditText getMemEt = (EditText) findViewById(R.id.textGetByMemID);

        getMemBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=getMemEt.getText().toString().trim();
                getDataFromSQLite(s);
            }
        });
        initViews();
        initObjects();

    }


    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewMembers = (RecyclerView) findViewById(R.id.recyclerViewMembers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listMembers = new ArrayList<>();
        membersRecyclerAdapter = new MembersRecyclerAdapter(listMembers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewMembers.setLayoutManager(mLayoutManager);
        recyclerViewMembers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMembers.setHasFixedSize(true);
        recyclerViewMembers.setAdapter(membersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);
        Log.d("Enter","init");
        //String emailFromIntent = getIntent().getStringExtra("EMAIL");
        //textViewName.setText(emailFromIntent);

        getDataFromSQLite(s);
    }

    /**
     * This method is to fetch all member records from SQLite
     */
    private void getDataFromSQLite(String t) {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        final String s=t;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Log.d("Blah","b4 clear");
                listMembers.clear();
                Log.d("Blah","b4 add");
                if (s.equals(""))
                    listMembers.addAll(databaseHelper.getAllMember());
                else
                    listMembers.addAll(databaseHelper.getByMemID(s));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                membersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
