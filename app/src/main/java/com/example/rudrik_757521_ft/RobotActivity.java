package com.example.rudrik_757521_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rudrik_757521_ft.adapters.AdptLights;
import com.example.rudrik_757521_ft.models.User;

public class RobotActivity extends AppCompatActivity {
    private static String TAG = "RobotActivity";

    private User user;

    private GridView gridView;
    private CheckBox chkRobot;
    private ImageButton btnRefresh;
    private Button btnVerify;

    private AdptLights adpt;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);

        getSupportActionBar().setTitle("Verification");

        user = (User) getIntent().getSerializableExtra("USER");
        Log.e(TAG, "onCreate: "+ user);

        gridView = (GridView) findViewById(R.id.gridView);
        chkRobot = (CheckBox) findViewById(R.id.chkRobot);
        btnRefresh = (ImageButton) findViewById(R.id.btnRefresh);
        btnVerify = (Button) findViewById(R.id.btnVerify);

        adpt = new AdptLights(this);
        gridView.setAdapter(adpt);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView v = view.findViewById(R.id.imgLight);
                if (v.getTag().toString().equals("TRAFFIC_LIGHT")){
                    counter = counter + 1;
                }else{
                    counter = counter - 1;
                }
                v.setEnabled(false);
                v.setForeground(getDrawable(R.drawable.checked));
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 4 && chkRobot.isChecked()){
                    User.listUsers.add(user);
                    new AlertDialog.Builder(RobotActivity.this)
                            .setTitle("Success")
                            .setMessage("User has been Registered.")
                            .setPositiveButton("Alright 🤟😁", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();

                }else{
                    new AlertDialog.Builder(RobotActivity.this)
                            .setTitle("Error")
                            .setMessage("wrong selection!")
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                gridView.setAdapter(null);
                adpt = new AdptLights(getApplicationContext());
                gridView.setAdapter(adpt);
                adpt.notifyDataSetChanged();
            }
        });
    }

}
