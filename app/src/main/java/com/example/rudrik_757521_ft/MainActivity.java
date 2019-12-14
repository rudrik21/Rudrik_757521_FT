package com.example.rudrik_757521_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rudrik_757521_ft.fragments.FragUserDetails;
import com.example.rudrik_757521_ft.fragments.FragUserList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";
    private FragUserList fragUserList;
    private FragUserDetails fragUserDetails;
    private FloatingActionButton fabAdd;

    public boolean isFragUserDetailsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Utils(this);
        Log.e(TAG, "userImages: " + Utils.userImages.size());
        Log.e(TAG, "lightImages: " + Utils.lightImages.size());

        fragUserList = (FragUserList) getSupportFragmentManager().findFragmentById(R.id.frag_UserList);
        fragUserDetails = (FragUserDetails) getSupportFragmentManager().findFragmentById(R.id.frag_UserDetails);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        View v = findViewById(R.id.frag_UserDetails);
        if (v != null) {
            isFragUserDetailsVisible = (v.getVisibility() == View.VISIBLE);
        }
        fragUserList.update();
    }

    public FragUserList getFragUserList() {
        return fragUserList;
    }

    public FragUserDetails getFragUserDetails() {
        return fragUserDetails;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAdd){
            startActivity(new Intent(this, AddUserActivity.class));
        }
    }
}
