package com.example.btlthadr.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.btlthadr.R;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    public  String Tag=" uilover";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        database=FirebaseDatabase.getInstance();
        mAuth= FirebaseAuth.getInstance();
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}