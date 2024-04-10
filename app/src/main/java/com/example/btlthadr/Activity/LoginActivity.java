package com.example.btlthadr.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;

import com.example.btlthadr.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        setVariable();
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.userEdit.getText().toString();
            String password = binding.passEdit.getText().toString();
            binding.loadingPanel.setVisibility(View.VISIBLE);
            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(s -> {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        })
                        .addOnCompleteListener(f -> {
                            binding.loadingPanel.setVisibility(View.GONE);
                        });
            } else {
                Toast.makeText(LoginActivity.this, "Please fill username and password ", Toast.LENGTH_SHORT).show();
            }
        });

        binding.signupLabel.setOnClickListener(v -> {
            startActivity(new Intent(this, SignupActivity.class));
        });
    }
}