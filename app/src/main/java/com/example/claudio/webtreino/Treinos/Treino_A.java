package com.example.claudio.webtreino.Treinos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.claudio.webtreino.R;

public class Treino_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_a);
    }

    public void falar_prof(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Treino_A.this, Treino_A.class);
        startActivity(intent);
    }
}
