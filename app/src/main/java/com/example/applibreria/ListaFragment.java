package com.example.applibreria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.applibreria.databinding.FragmentListaBinding;

import java.util.ArrayList;
import java.util.List;


public class ListaFragment extends Fragment implements LibroAdapter.OnLibroSeleccionadoListener {

    private FragmentListaBinding binding;
    private LibroAdapter adapter;
    private final List<Libro> listaLibros = new ArrayList<>();

    private CarritoFragment carritoFragment;

    // 1. Lista para guardar los libros seleccionados
    private final List<Libro> librosSeleccionados = new ArrayList<>();

    public ListaFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar RecyclerView
        adapter = new LibroAdapter(listaLibros, this);
        binding.recyclerViewLibros.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewLibros.setAdapter(adapter);

        // Cargar datos
        cargarDatos();

        carritoFragment = new CarritoFragment();

        // 3. Manejar el clic del botón general
        binding.btnAgregarCarro.setOnClickListener(v -> {
            // Recorrer la lista de seleccionados y agregarlos al carro
            for (Libro libro : librosSeleccionados) {
                CarritoManager.getInstance().agregarLibro(libro);
                Toast.makeText(requireContext(), libro.getTitulo() + " agregado al carro", Toast.LENGTH_SHORT).show();
            }
            // Opcional: limpiar la selección
            librosSeleccionados.clear();
            for (Libro libro : listaLibros) {
                libro.setSeleccionado(false);
            }
            adapter.notifyDataSetChanged();
        });
    }

    // 4. Implementación de la interfaz

    public void onLibroSeleccionado(Libro libro, boolean isSeleccionado) {
        if (isSeleccionado) {
            librosSeleccionados.add(libro);
        } else {
            librosSeleccionados.remove(libro);
        }
    }
    private void cargarDatos() {
        listaLibros.clear();
        listaLibros.add(new Libro("La bailarina de Auschwitz", "Edith Eger", "2018", R.drawable.la_bailarina_de_auschwitz, R.string.la_bailarina_de_auschwitz, 19900));
        listaLibros.add(new Libro("El psicoanalista", "John Katzenbach", "2002", R.drawable.el_psicoanalista, R.string.el_psicoanalista, 24900));
        listaLibros.add(new Libro("La casa de los espíritus", "Isabel Allende", "1982", R.drawable.la_casa_de_los_espiritus, R.string.la_casa_de_los_espiritus, 15900));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "1967", R.drawable.cien_anios_de_soledad, R.string.cien_anios_de_soledad, 12900));
        listaLibros.add(new Libro("El hobbit", "J. R. R. Tolkien", "1937", R.drawable.el_hobbit, R.string.el_hobbit, 14500));
        listaLibros.add(new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling", "1997", R.drawable.harry_potter_y_la_piedra_filosofal, R.string.harry_potter_y_la_piedra_filosofal, 17900));
        listaLibros.add(new Libro("Fuego y sangre", "George R. R. Martin", "2018", R.drawable.fuego_y_sangre, R.string.fuego_y_sangre, 22500));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "1605", R.drawable.don_quijote, R.string.don_quijote, 17900));
        listaLibros.add(new Libro("Alas de sangre", "Rebecca Yarros", "2023", R.drawable.alas_de_sangre, R.string.alas_de_sangre, 32900));

        // Notificar al adaptador que los datos han cambiado
        adapter.notifyDataSetChanged();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // evitar memory leak
    }
}