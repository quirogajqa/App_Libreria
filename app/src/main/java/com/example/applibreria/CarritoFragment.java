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

public class CarritoFragment extends Fragment {

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
        RecyclerView recyclerViewCarrito = view.findViewById(R.id.recyclerViewCarrito); // Asegúrate de que el ID coincida con tu fragment_Carrito.xml
        LibroCarritoAdapter adapter = new LibroCarritoAdapter(librosEnCarrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewCarrito.setAdapter(adapter);
    }
}