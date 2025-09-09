package com.example.applibreria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {
    // Lista de datos que se mostrará en el RecyclerView
    private final List<Libro> listaLibros;


    public LibroAdapter(List<Libro> listaLibros) {
        this.listaLibros = this.listaLibros;
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
        // Obtener el estudiante específico de esta posición
        Libro libro = listaLibros.get(position);

        // Llenar las vistas con los datos del libro
        holder.tvNombreCompleto.setText(libro.getTitulo());

        // Lógica condicional: Si no tiene app asignada, mostrar "Pendiente"
        if (libro.getApp().equals("pendiente")) {
            holder.tvApp.setText("App: Pendiente");
        } else {
            holder.tvApp.setText("App: " + libro.getApp());
        }

        // Lógica condicional: Si no tiene fecha, mostrar "Sin fecha"
        if (libro.getFechaInscripcion().equals("pendiente")) {
            holder.tvFechaInscripcion.setText("Fecha: Sin inscribir");
        } else {
            holder.tvFechaInscripcion.setText("Inscrito: " + libro.getFechaInscripcion());
        }
    }


    @Override
    public int getItemCount() {
        return listaLibros.size();
    }


    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        // Referencias a las vistas del layout item_estudiante.xml
        TextView tvNombreCompleto, tvApp, tvFechaInscripcion;

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
            tvNombreCompleto = itemView.findViewById(R.id.tvNombreCompleto);
            tvApp = itemView.findViewById(R.id.tvApp);
            tvFechaInscripcion = itemView.findViewById(R.id.tvFechaInscripcion);
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