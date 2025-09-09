package com.example.applibreria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applibreria.databinding.ActivityMainBinding;
import com.example.applibreria.databinding.FragmentListaBinding;

import java.util.ArrayList;
import java.util.List;


public class ListaFragment extends Fragment {

    private FragmentListaBinding binding;
    private LibroAdapter adapter;
    private final List<Libro> listaLibros = new ArrayList<>();

    public ListaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar RecyclerView
        adapter = new LibroAdapter(listaLibros);
        binding.recyclerViewLibros.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewLibros.setAdapter(adapter);

        // Cargar datos
        cargarDatos();
    }
    private void cargarDatos() {
        listaLibros.add(new Libro("La bailarina de Auschwitz", "Edith Eger", "2018", R.drawable.la_bailarina_de_auschwitz));
        listaLibros.add(new Libro("El psicoanalista", "John Katzenbach", "2002", R.drawable.el_psicoanalista));
        listaLibros.add(new Libro("La casa de los espíritus", "Isabel Allende", "1982", R.drawable.la_casa_de_los_espiritus));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "1967", R.drawable.cien_anios_de_soledad));
        listaLibros.add(new Libro("El hobbit", "J. R. R. Tolkien", "1937", R.drawable.el_hobbit));
        listaLibros.add(new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling", "1997", R.drawable.harry_potter_y_la_piedra_filosofal));
        listaLibros.add(new Libro("Fuego y sangre", "George R. R. Martin", "2018", R.drawable.fuego_y_sangre));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "1605", R.drawable.don_quijote));
        listaLibros.add(new Libro("Alas de sangre", "Rebecca Yarros", "2023", R.drawable.alas_de_sangre));

// Notificar al adaptador que los datos han cambiado
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // evitar memory leak
    }
}