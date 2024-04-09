package com.example.btlthadr.Activity;

import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import com.example.btlthadr.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        setVariable();
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            String email =binding.userEdit.getText().toString();
            String password =binding.passEdit.getText().toString();
            if(!email.isEmpty() && ! password.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, task -> {
                    if(task.isSuccessful()){
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();

                    }
                });

            }else {
                Toast.makeText(LoginActivity.this,"Please fill username and password ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}