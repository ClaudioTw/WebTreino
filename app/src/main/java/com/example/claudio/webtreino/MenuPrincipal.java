package com.example.claudio.webtreino;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.claudio.webtreino.Activity.LoginActivity;
import com.example.claudio.webtreino.CORRIDA.Corrida;
import com.example.claudio.webtreino.MODULOS.AvaliacaoFisica;
import com.example.claudio.webtreino.MODULOS.Fisioterapia;
import com.example.claudio.webtreino.MODULOS.Nutricao;
import com.example.claudio.webtreino.Qrcode.MainActivity;
import com.example.claudio.webtreino.Treinos.Top5;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class MenuPrincipal extends AppCompatActivity
               implements NavigationView.OnNavigationItemSelectedListener,
                 View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    Button b1,b2,b3,b4,b5,b6;
    TextToSpeech t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu_principal);

        b1 = (Button) findViewById(R.id.btnIniciar);



        //////////////////////////////


        ////////////////////////


        b2 = (Button) findViewById(R.id.button1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Toast.makeText(getApplication(), "Meu Treino", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuPrincipal.this, Top5.class);
                startActivity(intent);
            }
        });

        Button b3 = (Button) findViewById(R.id.button2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplication(), "Avaliações", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuPrincipal.this, Corrida.class);
                startActivity(intent);
            }
        });

        Button health = (Button) findViewById(R.id.button3);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplication(), "Nutrição", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuPrincipal.this, Top5.class);
                startActivity(intent);
            }
        });

        Button goals = (Button) findViewById(R.id.button4);
        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplication(), "Fisioterápia", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuPrincipal.this, Nutricao.class);
                startActivity(intent);
            }
        });

        ImageView top5 = (ImageView) findViewById(R.id.imgtrofeu);
        top5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplication(), "TOP 5", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuPrincipal.this, Top5.class);
                startActivity(intent);
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        btnLogout = (Button) findViewById(R.id.nav_manage);


        //////////

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnScan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                startActivity(intent);
                Snackbar.make(view, "Direcionado para Scan Qr-Code", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//entrada do nome usado no botao iniciar

    }


///

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MenuPrincipal.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.action_settings2) {
            findViewById(R.id.action_settings2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // We normally won't show the welcome slider again in real app
                    // but this is for testing
                    PrefManager prefManager = new PrefManager(getApplicationContext());

                    // make first time launch TRUE
                    prefManager.setFirstTimeLaunch(true);

                    startActivity(new Intent(MenuPrincipal.this, WelcomeActivity.class));
                    finish();
                }
            });


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MenuPrincipal.this, Top5.class);
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MenuPrincipal.this, AvaliacaoFisica.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MenuPrincipal.this, AvaliacaoFisica.class);
            startActivity(intent);

        } else if (id == R.id.nav_fisioterapia) {
            Intent intent = new Intent(MenuPrincipal.this, Fisioterapia.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(MenuPrincipal.this, "Logout Efetuado com Sucesso!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == btnLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(MenuPrincipal.this, "Logout Efetuado!", Toast.LENGTH_SHORT).show();
        }


        // Texto de fala
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String falar = "Iniciar\n" +
                        "Selecione a modalidade\n" +
                        "Musculação\n" +
                        "Natação\n" +
                        "Bicicleta\n " +
                        "Ou\n " +

                        "Corrida\n" +
                        ""
                                .toString();

                t1.speak(falar, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(MenuPrincipal.this, "Iniciar", Toast.LENGTH_SHORT).show();

            }
        });


    }

}











