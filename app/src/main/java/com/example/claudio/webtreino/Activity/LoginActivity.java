package com.example.claudio.webtreino.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.claudio.webtreino.DAO.ConfiguracaoFirebase;
import com.example.claudio.webtreino.ENTIDADE.Usuarios;
import com.example.claudio.webtreino.MenuPrincipal;
import com.example.claudio.webtreino.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity  extends AppCompatActivity {




    private EditText edtEmail;
    private EditText edtSenha;
    private ValueEventListener valueEventListener;
    private DatabaseReference firebase;
    private TextView tvAbreCadastro;
    private Button btnLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;
    private String idenficadorUsuario;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




        setContentView(R.layout.activity_login);




////////////////////////////////////
            edtEmail = (EditText) findViewById(R.id.edtEmail);
            edtSenha = (EditText) findViewById(R.id.edtSenha);
            tvAbreCadastro = (TextView) findViewById(R.id.tvAbreCadastro);
            btnLogar = (Button) findViewById(R.id.btnLogar);


            ///////////////////

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference table_user = database.getReference("User");
            /////////////

            btnLogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo netInfo = cm.getActiveNetworkInfo();

                    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                        Toast.makeText(LoginActivity.this, "Dispositivo Conectado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Dispositivo não Conectado", Toast.LENGTH_SHORT).show();
                    }

                    if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {

                        usuarios = new Usuarios();
                        usuarios.setEmail(edtEmail.getText().toString().trim());
                        usuarios.setSenha(edtSenha.getText().toString().trim());

                        validarLogin();
                    } else {
                        Toast.makeText(LoginActivity.this, "Preencha os campos de e-mail e senha!", Toast.LENGTH_SHORT).show();
                    }


                    ////////////////////////

                    final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                    mDialog.setMessage("Por favor aguarde...Estamos conectando com o servidor");
                    mDialog.show();

                    table_user.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            //verificação de bd


                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            });


            tvAbreCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abreCadastroUsuario();
                }
            });


        }

        private void validarLogin() {

            autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        abrirTelaPrincipal();
                        Toast.makeText(LoginActivity.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void abrirTelaPrincipal() {
            Intent intentAbrirTelaPrincipal = new Intent(LoginActivity.this, MenuPrincipal.class);
            startActivity(intentAbrirTelaPrincipal);

        }


        public void abreCadastroUsuario() {
            Intent intent = new Intent(LoginActivity.this, Cadastro.class);
            startActivity(intent);


        }
    }







