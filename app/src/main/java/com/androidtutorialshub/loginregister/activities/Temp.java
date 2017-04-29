package com.androidtutorialshub.loginregister.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.adapters.MembersRecyclerAdapter;
import com.androidtutorialshub.loginregister.model.Member;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 10/10/2016.
 */

public class Temp extends AppCompatActivity {

    private AppCompatActivity activity = Temp.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewMembers;
    private List<Member> listMembers;
    private MembersRecyclerAdapter membersRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    Button submitBtn = (Button)findViewById(R.id.submitButton);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Enter", "OC");
        setContentView(R.layout.finder);
        getSupportActionBar().setTitle("IECSE Central Database");

        Log.d("Enter", "init");
        initViews();
        Log.d("Enter", "Objects");
        initObjects();
        Log.d("Enter", "Exit");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            Log.d("In","Bf");
            String levelClause="";
            String deptClause="";
            AppCompatCheckBox cbBoard = (AppCompatCheckBox) findViewById(R.id.board_cb);
            AppCompatCheckBox cbMC = (AppCompatCheckBox) findViewById(R.id.mc_cb);
            AppCompatCheckBox cbWC = (AppCompatCheckBox) findViewById(R.id.wc_cb);
            AppCompatCheckBox cbMember = (AppCompatCheckBox) findViewById(R.id.member_cb);

            AppCompatCheckBox cbWeb = (AppCompatCheckBox) findViewById(R.id.web_cb);
            AppCompatCheckBox cbDev = (AppCompatCheckBox) findViewById(R.id.dev_cb);
            AppCompatCheckBox cbDesign = (AppCompatCheckBox) findViewById(R.id.design_cb);
            AppCompatCheckBox cbTech = (AppCompatCheckBox) findViewById(R.id.tech_cb);

            if (cbBoard.isChecked()){
                if (levelClause.equals("")){
                    levelClause+="\'3\'";
                }
            }

            if (cbMC.isChecked()){
                if (levelClause.equals(""))
                    levelClause += "\'2\'";
                else
                    levelClause+="\',2\'";
            }

            if (cbWC.isChecked()){
                if (levelClause.equals(""))
                    levelClause+="\'1\'";
                else
                    levelClause+="\',1\'";
            }
            if (cbMember.isChecked()){
                if (levelClause.equals(""))
                    levelClause+="\'0\'";
                else
                    levelClause+="\',0\'";
            }


            if (cbWeb.isChecked()){
                if (deptClause.equals(""))
                    deptClause+="\'Web\'";

            }
            if (cbDev.isChecked()){
                if (deptClause.equals(""))
                    deptClause+="\'Dev\'";
                else
                    deptClause+="\',Dev\'";

            }
            if (cbDesign.isChecked()){
                if (deptClause.equals(""))
                    deptClause+="\'Design\'";
                else
                    deptClause+="\',Design\'";


            }
            if (cbTech.isChecked()){
                if (deptClause.equals(""))
                    deptClause+="\'Tech\'";
                else
                    deptClause+="\',Tech\'";
            }
            String whereClause="dept IN ("+deptClause+") AND access_level IN ("+levelClause+")";
            getDataFromSQLite(whereClause);


        }
    });
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
    }

    /**
     * This method is to fetch all member records from SQLite
     */
    private void getDataFromSQLite(String s) {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Log.d("Blah","b4 clear");
                listMembers.clear();
                Log.d("Blah","b4 add");
                listMembers.addAll(databaseHelper.getAllMember());
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
