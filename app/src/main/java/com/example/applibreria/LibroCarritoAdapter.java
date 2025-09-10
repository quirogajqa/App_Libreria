package com.example.applibreria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class LibroCarritoAdapter extends RecyclerView.Adapter<LibroCarritoAdapter.CarritoViewHolder> {

    // Interfaz para el evento de eliminar
    public interface OnItemEliminadoListener {
        void onLibroEliminado(Libro libro);
    }

    private final List<Libro> listaLibros;
    private final OnItemEliminadoListener listener;

    public LibroCarritoAdapter(List<Libro> listaLibros, OnItemEliminadoListener listener) {
        this.listaLibros = listaLibros;
        this.listener = listener;
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
        holder.ivPortada.setImageResource(libro.getImagen());
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        holder.tvPrecio.setText(formatoMoneda.format(libro.getPrecio()));
        // Manejar el clic del botón de eliminar
        holder.btnEliminar.setOnClickListener(v -> {
            if (listener != null) listener.onLibroEliminado(libro);
        });
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    static class CarritoViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitulo;
        final TextView tvAutor;
        TextView tvPrecio;
        final ImageView ivPortada;
        final ImageButton btnEliminar;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tv_titulo_carrito);
            tvAutor = itemView.findViewById(R.id.tv_autor_carrito);
            btnEliminar = itemView.findViewById(R.id.btn_eliminar_carrito);
            ivPortada = itemView.findViewById(R.id.iv_portada_carrito);
            tvPrecio = itemView.findViewById(R.id.tv_precio_carrito);
        }
    }
}