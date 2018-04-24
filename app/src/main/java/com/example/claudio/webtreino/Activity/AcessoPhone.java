package com.example.claudio.webtreino.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.claudio.webtreino.Common.Common;
import com.example.claudio.webtreino.MenuPrincipal;
import com.example.claudio.webtreino.R;
import com.example.claudio.webtreino.User.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class AcessoPhone extends AppCompatActivity {

    EditText edtPhone,edtPassword;
    Button btnSignIn, btnSignIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso_phone);


        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText) findViewById(R.id.edtPhone);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn2 = (Button) findViewById(R.id.btnSignIn2);






        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final ProgressDialog mDialog = new ProgressDialog(AcessoPhone.this);
                mDialog.setMessage("Por favor aguarde...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //verificação de bd

                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            mDialog.dismiss();


                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {

                                {
                                    Intent homeintent = new Intent(AcessoPhone.this,MenuPrincipal.class);
                                    Common.currentUser= user;
                                    startActivity(homeintent);
                                    finish();
                                }


                            } else {

                                mDialog.dismiss();
                                Toast.makeText(AcessoPhone.this, "Erro ao Efetuar o Login!", Toast.LENGTH_SHORT).show();


                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(AcessoPhone.this, "Usuario não Existente em nosso Bando de Dados!,", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

        });

        btnSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcessoPhone. this, LoginPhone.class);
                startActivity(i);

            }
        });
    }



}



