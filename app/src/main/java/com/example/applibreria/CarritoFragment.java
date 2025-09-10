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
import androidx.navigation.Navigation;

import com.example.applibreria.databinding.FragmentCarritoBinding;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CarritoFragment extends Fragment implements LibroCarritoAdapter.OnItemEliminadoListener{

    private FragmentCarritoBinding binding;
    private LibroCarritoAdapter adapter;
    private List<Libro> librosEnCarrito;

    public CarritoFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del carrito
        binding = FragmentCarritoBinding.inflate(inflater, container, false);
        // 3. Devolver la vista raíz de tu layout
        return binding.getRoot();}

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

        binding.btnPagar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_carritoFragment_to_pagarFragment);
        });
        actualizarTotales();
    }

    // 4. Implementar el método de la interfaz
    @Override
    public void onLibroEliminado(Libro libro) {
        // 1. Llama directamente al método de eliminación del CarritoManager
        CarritoManager.getInstance().getItemsCarrito().remove(libro);

        // Notificar al adaptador que los datos han cambiado para refrescar la vista
        adapter.notifyDataSetChanged();

        actualizarTotales(); // Vuelve a llamar para actualizar los totales
    }

    private void actualizarTotales() {
        double subtotal = 0.0;
        // 1. Obtener los libros del CarritoManager
        List<Libro> librosEnCarrito = CarritoManager.getInstance().getItemsCarrito();

        // 2. Sumar los precios para el subtotal
        for (Libro libro : librosEnCarrito) {
            subtotal += libro.getPrecio();
        }

        // 3. Calcular el IVA (19%)
        double iva = subtotal * 0.19;

        // 4. Calcular el total
        double total = subtotal + iva;

        // 5. Formatear y mostrar los valores
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        binding.tvSubtotal.setText(formatoMoneda.format(subtotal));
        binding.tvIva.setText(formatoMoneda.format(iva));
        binding.tvTotal.setText(formatoMoneda.format(total));
    }
}