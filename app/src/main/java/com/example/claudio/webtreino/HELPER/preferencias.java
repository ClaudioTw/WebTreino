package com.example.claudio.webtreino.HELPER;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by claudio on 12/04/18.
 */

public class preferencias {
    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "projetoFirebase.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);

        editor = preferences.edit();
    }

    public void salvarUsuarioPrefencias(String idenficadorUsuario, String nomeUsuario) {
        editor.putString(CHAVE_IDENTIFICADOR, idenficadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdenficador() {

        return preferences.getString(CHAVE_IDENTIFICADOR, null);
    }

    public String getNome() {

        return preferences.getString(CHAVE_NOME, null);
    }

}