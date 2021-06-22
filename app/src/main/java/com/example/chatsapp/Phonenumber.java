package com.example.chatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatsapp.databinding.ActivityPhonenumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Phonenumber extends AppCompatActivity {

    ActivityPhonenumberBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhonenumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!= null){
            Intent intent = new Intent(Phonenumber.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        binding.phonbox.requestFocus();
        binding.continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Phonenumber.this, OTPActivity.class);
                intent.putExtra("PhoneNumber",binding.phonbox.getText().toString());
                startActivity(intent);
            }
        });
    }
}
