package com.example.applibreria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.applibreria.R;
import java.util.List;

public class LibroCarritoAdapter extends RecyclerView.Adapter<LibroCarritoAdapter.CarritoViewHolder> {

    private final List<Libro> listaLibros;

    public LibroCarritoAdapter(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Libro libro = listaLibros.get(position);
        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
        // Aquí podrías agregar más detalles del libro o un botón de eliminar.
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    static class CarritoViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitulo;
        final TextView tvAutor;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tv_titulo_carrito); // Asegúrate de que los IDs coincidan con tu item_libro_carrito.xml
            tvAutor = itemView.findViewById(R.id.tv_autor_carrito);
        }
    }
}