package com.example.applibreria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarritoFragment extends Fragment implements LibroCarritoAdapter.OnItemEliminadoListener{

    private LibroCarritoAdapter adapter;
    private List<Libro> librosEnCarrito;

    public CarritoFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del carrito
        return inflater.inflate(R.layout.fragment_carrito, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener la lista de libros desde el CarritoManager
        List<Libro> librosEnCarrito = CarritoManager.getInstance().getItemsCarrito();

        // Configurar el RecyclerView
        RecyclerView recyclerViewCarrito = view.findViewById(R.id.recyclerViewCarrito);
        adapter = new LibroCarritoAdapter(librosEnCarrito, this);
        //LibroCarritoAdapter adapter = new LibroCarritoAdapter(librosEnCarrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewCarrito.setAdapter(adapter);
    }

    // 4. Implementar el método de la interfaz
    @Override
    public void onLibroEliminado(Libro libro) {
        // 1. Llama directamente al método de eliminación del CarritoManager
        CarritoManager.getInstance().getItemsCarrito().remove(libro);

        // Notificar al adaptador que los datos han cambiado para refrescar la vista
        adapter.notifyDataSetChanged();
    }
}