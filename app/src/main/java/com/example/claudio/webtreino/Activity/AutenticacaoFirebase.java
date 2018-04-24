package com.example.claudio.webtreino.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.claudio.webtreino.R;

public class AutenticacaoFirebase extends AppCompatActivity {

    TextToSpeech t1;
    ImageView b1;


    Button btnAbrirActivityLogin;
    Button tvAbreCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacao_firebase);

        b1 = (ImageView) findViewById(R.id.btnaudio);

        btnAbrirActivityLogin = (Button) findViewById(R.id.btnFazerLogin);

        btnAbrirActivityLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrirTelaLogin = new Intent(AutenticacaoFirebase.this, LoginActivity.class);
                startActivity(intentAbrirTelaLogin);
            }
        });

        tvAbreCadastro = (Button) findViewById(R.id.tvAbreCadastro);
        tvAbreCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreCadastroUsuario();
            }
        });
    }

        public void abreCadastroUsuario() {
            Intent intent = new Intent(AutenticacaoFirebase.this, Cadastro.class);
            startActivity(intent);




    }



}


