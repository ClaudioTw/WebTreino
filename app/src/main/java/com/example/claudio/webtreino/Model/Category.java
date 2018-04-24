package com.example.claudio.webtreino.Model;

/**
 * Created by claudio on 12/04/18.
 */

public class Category {

    private String Nome;
    private String Image;

    public Category(){
    }

    public Category(String nome, String image) {
        Nome = nome;
        Image = image;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
