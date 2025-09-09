package com.example.applibreria;


import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Libro {

    private String titulo;
    private String autor;
    private String anio;
    private int imagen;

    public Libro (String titulo, String autor, String anio, int imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
