package com.example.rudrik_757521_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rudrik_757521_ft.models.User;

public class AddUserActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPhone;
    private Button btnSaveUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        getSupportActionBar().setTitle("Registration");

        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnSaveUser = (Button) findViewById(R.id.btnSaveUser);

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()){
                    User user = new User(name, email, phone);

                    Intent i = new Intent(getApplicationContext(), RobotActivity.class);
                    i.putExtra("USER", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(AddUserActivity.this, "Empty fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
