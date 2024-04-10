package com.example.btlthadr.Activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;

import com.example.btlthadr.databinding.ActivitySignupBinding;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.userEdit.getText().toString();
            String password = binding.passEdit.getText().toString();

            if (password.length() < 6) {
                Toast.makeText(SignupActivity.this, "Your password must be 6 character", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(suc -> {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    })
                    .addOnFailureListener(f -> {
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    });
        });

        binding.signinLabel.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}