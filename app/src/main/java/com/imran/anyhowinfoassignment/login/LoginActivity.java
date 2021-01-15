package com.imran.anyhowinfoassignment.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.imran.anyhowinfoassignment.MainActivity;
import com.imran.anyhowinfoassignment.R;
import com.imran.anyhowinfoassignment.SharedPrefManager;
import com.imran.anyhowinfoassignment.model.User;
import com.imran.anyhowinfoassignment.roomdb.Database;
import com.imran.anyhowinfoassignment.roomdb.MyDao;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    MyDao db;
    Database dataBase;
    EditText emailEt,passwordEt;
    Button buttonLogin;
    TextView linkLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();
        dataBase = Room.databaseBuilder(this, Database.class, "userDB")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
    }

    private void initview()
    {
        emailEt=findViewById(R.id.etEmailLogin);
        passwordEt=findViewById(R.id.etpasswordLogin);
        buttonLogin=findViewById(R.id.btnLogin);
        linkLogin=findViewById(R.id.etRegisterLink);

        buttonLogin.setOnClickListener(this);
        linkLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.etLoginLink:
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
                break;

            case R.id.btnLogin:
                loginValidate();
                break;
        }
    }

    private void loginValidate() {
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();

        if (email.isEmpty())
        {
            emailEt.requestFocus();
            emailEt.setError("Please enter Email ID");
            return;
        }
        if (password.isEmpty())
        {
            passwordEt.requestFocus();
            passwordEt.setError("Enter Password");
            return;
        }
        validateUserAndLogin(email,password);

    }


    private void validateUserAndLogin(String email, String password)
    {
        User user =dataBase.getUserDao().getUser(email,password);



        if (user != null) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            SharedPrefManager sf=new SharedPrefManager(this);
            sf.saveUser(user);
            startActivity(i);
            finish();
        }else{
            //Log.e("savedata",user.getEmail().toString());
            Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
       startActivity(intent);

    }
}