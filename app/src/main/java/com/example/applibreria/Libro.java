package com.example.applibreria;


import android.widget.ImageView;

public class Libro {

    private String titulo;
    private String autor;
    private String anio;
    private ImageView imagen;

    public Libro (String titulo, String autor, String anio, ImageView imagen) {
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

    public ImageView getImagen() {
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

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}
