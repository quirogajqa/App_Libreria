package com.example.applibreria;



public class Libro {

    private String titulo;
    private String autor;
    private String anio;
    private int imagen;

    private int descripcion;

    public Libro (String titulo, String autor, String anio, int imagen, int descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.imagen = imagen;
        this.descripcion = descripcion;
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

    public int getDescripcion() {
        return descripcion;
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

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }
}
