package com.example.applibreria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.List;


public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {
    // Lista de datos que se mostrará en el RecyclerView

    private final List<Libro> listaLibros;

    private final OnLibroSeleccionadoListener listener;
    // 2. Constructor actualizado
    public LibroAdapter(List<Libro> listaLibros, OnLibroSeleccionadoListener listener) {
        this.listaLibros = listaLibros;
        this.listener = listener;
    }

    // 1. Interfaz para manejar el clic del Checkbox
    public interface OnLibroSeleccionadoListener {
        void onLibroSeleccionado(Libro libro, boolean isSeleccionado);
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar (convertir de XML a View) el layout del item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_libro, parent, false);

        // Crear y retornar un nuevo ViewHolder con esta vista
        return new LibroViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        // Obtener el libro específico de esta posición
        Libro libro = listaLibros.get(position);

        // Llenar las vistas con los datos del libro
        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
        holder.tvAnio.setText(libro.getAnio());
        holder.ivPortada.setImageResource(libro.getImagen());


        holder.tvVerDetalle.setOnClickListener(v -> {

            Bundle args = new Bundle();
            args.putString("titulo", libro.getTitulo());
            args.putString("autor", libro.getAutor());
            args.putString("anio",  libro.getAnio());
            args.putInt("descripcion", libro.getDescripcion());
            args.putInt("imagenResId", libro.getImagen());
            args.putDouble("precio", libro.getPrecio());

            Navigation.findNavController(v).navigate(R.id.action_listaFragment_to_descripcionFragment, args);
        });

        // 3. Manejar el Checkbox
        holder.cbSeleccion.setOnCheckedChangeListener(null);
        holder.cbSeleccion.setChecked(libro.isSeleccionado());
        holder.cbSeleccion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            libro.setSeleccionado(isChecked);
            if (listener != null) {
                listener.onLibroSeleccionado(libro, isChecked);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listaLibros.size();
    }


    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        // Referencias a las vistas del layout item_estudiante.xml
        TextView tvTitulo, tvAutor, tvAnio, tvPrecio;
        ImageView ivPortada;
        TextView tvVerDetalle;

        final MaterialCheckBox cbSeleccion;

        /**
         * Constructor del ViewHolder: aquí es donde se hace findViewById
         * una sola vez por cada ViewHolder creado.
         *
         * @param itemView La vista completa del item (el LinearLayout completo)
         */
        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            // Buscar y guardar las referencias a cada TextView
            // Esto solo se hace una vez por ViewHolder, no por cada bind
            tvTitulo = itemView.findViewById(R.id.tv_titulo);
            tvAutor = itemView.findViewById(R.id.tv_autor);
            tvAnio = itemView.findViewById(R.id.tv_anio);
            ivPortada = itemView.findViewById(R.id.iv_portada);
            tvVerDetalle = itemView.findViewById(R.id.tv_ver_detalle);
            tvPrecio = itemView.findViewById(R.id.tv_precio_desc);
            cbSeleccion = itemView.findViewById(R.id.cbSeleccion);
        }
    }
}

/*
FLUJO RESUMIDO:
1. RecyclerView pregunta: "¿Cuántos elementos hay?" → getItemCount()
2. RecyclerView dice: "Necesito una vista nueva" → onCreateViewHolder()
3. RecyclerView dice: "Llena esta vista con datos" → onBindViewHolder()
4. Usuario hace scroll → RecyclerView reutiliza vistas existentes llamando onBindViewHolder()
*/