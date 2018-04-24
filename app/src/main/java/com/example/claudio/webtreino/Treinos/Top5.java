package com.example.claudio.webtreino.Treinos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.claudio.webtreino.R;

public class Top5 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);


    }

    public void treino_1(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Top5.this, Treino_A.class);
        startActivity(intent);
    }

    public void treino_2(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Top5.this, Treino_B.class);
        startActivity(intent);
    }

    public void treino_3(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Top5.this, Treino_C.class);
        startActivity(intent);
    }

    public void treino_4(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Top5.this, Treino_D.class);
        startActivity(intent);
    }

    public void treino_5(View view) {
        Toast.makeText(getApplication(), "TREINO A", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Top5.this, Treino_E.class);
        startActivity(intent);
    }
}


