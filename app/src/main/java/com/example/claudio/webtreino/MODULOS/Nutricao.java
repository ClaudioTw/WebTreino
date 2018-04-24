package com.example.claudio.webtreino.MODULOS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.claudio.webtreino.Activity.LoginActivity;
import com.example.claudio.webtreino.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Nutricao extends AppCompatActivity {

    private TextView edtEmail;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricao);

        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        edtEmail = (TextView) findViewById(R.id.edtEmail);
        edtEmail.setText("Welcome " + user.getEmail());

    }

}