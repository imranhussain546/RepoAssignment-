package com.imran.anyhowinfoassignment.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.imran.anyhowinfoassignment.R;
import com.imran.anyhowinfoassignment.model.User;
import com.imran.anyhowinfoassignment.roomdb.Database;
import com.imran.anyhowinfoassignment.roomdb.MyDao;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDao db;
    Button btnRegister;
    EditText first, Last,email, pass, cnfrmpass;
    TextView linkLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initview();
        db = Room.databaseBuilder(this, Database.class, "userDB").allowMainThreadQueries()
                .build().getUserDao();

    }

    private void initview()
    {
        btnRegister=findViewById(R.id.btnRegister);
        first =findViewById(R.id.etFirstNameSUP);
        Last =findViewById(R.id.etLastNameSUP);
        email=findViewById(R.id.etEmailSUP);
        pass =findViewById(R.id.etpasswordSUP);
        cnfrmpass =findViewById(R.id.etCnfpasswordSUP);
        linkLog=findViewById(R.id.etLoginLink);

        btnRegister.setOnClickListener(this);
        linkLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.etLoginLink:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.btnRegister:
                validateData();
                break;
        }
    }

    private void validateData() {
        String First = first.getText().toString();
        String Last = this.Last.getText().toString();
        String Email = email.getText().toString();
        String Password = pass.getText().toString();
        String CnfrPass = cnfrmpass.getText().toString();

        if (First.isEmpty()) {
            first.requestFocus();
            first.setError("Enter First Name");
            return;
        }
        if (Last.isEmpty()) {
            this.Last.requestFocus();
            this.Last.setError("Enter Last Name");
            return;
        }
        if (Email.isEmpty()) {
            email.requestFocus();
            email.setError("Enter Email Id");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.requestFocus();
            email.setError("Enter Valid CnfrPass");
            return;
        }
        if (CnfrPass.isEmpty()) {
            pass.requestFocus();
            pass.setError("Enter CnfrPass");
            return;
        }


        if (CnfrPass.length() < 6) {
            pass.requestFocus();
            pass.setError("Enter minimum 6 character");
            return;
        }

        if (CnfrPass.isEmpty()) {
            cnfrmpass.requestFocus();
            cnfrmpass.setError("Enter Conform password");
            return;
        }
        if (CnfrPass.equals(CnfrPass)) {
            User user = new User(First, Last, Password, Email);
            db.insert(user);
            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
            Intent moveToLogin = new Intent(SignupActivity.this, LoginActivity.class);

            startActivity(moveToLogin);
        } else {
            cnfrmpass.requestFocus();
            cnfrmpass.setError("Enter Same CnfrPass");
            return;

        }
    }
}