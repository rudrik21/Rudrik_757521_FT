package com.example.rudrik_757521_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.rudrik_757521_ft.fragments.FragUserDetails;

public class UserDetailsActivity extends AppCompatActivity {

    private static String TAG = "UserDetailsActivity";

    private FragUserDetails frag_UserDetails;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        getSupportActionBar().setTitle("User Details");

        frag_UserDetails = (FragUserDetails) getSupportFragmentManager().findFragmentById(R.id.frag_UserDetails);
        position = getIntent().getIntExtra("SELECTED_POSITION", -1);
        Log.e(TAG, "onCreate: "+ position);

        frag_UserDetails.setDetails(position);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
