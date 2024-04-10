package com.example.btlthadr.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.btlthadr.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        binding.signupBtn.setOnClickListener(v -> startActivity(new Intent(this, SignupActivity.class)));
    }
}