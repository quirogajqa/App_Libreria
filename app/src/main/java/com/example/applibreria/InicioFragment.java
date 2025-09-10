package com.example.applibreria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applibreria.databinding.FragmentInicioBinding;

import java.util.ArrayList;
import java.util.List;


public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    private final List<Libro> listaTopLibros = new ArrayList<>();

    public InicioFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatosTop();
        mostrarDatos();
    }

    private void cargarDatosTop() {
        listaTopLibros.clear();
        listaTopLibros.add(new Libro("La bailarina de Auschwitz", "Edith Eger", "2018", R.drawable.la_bailarina_de_auschwitz, R.string.la_bailarina_de_auschwitz, 0));
        listaTopLibros.add(new Libro("El psicoanalista", "John Katzenbach", "2002", R.drawable.el_psicoanalista, R.string.el_psicoanalista, 0));
        listaTopLibros.add(new Libro("La casa de los espíritus", "Isabel Allende", "1982", R.drawable.la_casa_de_los_espiritus, R.string.la_casa_de_los_espiritus, 0));
    }

    private void mostrarDatos() {
        // Mostrar los datos del libro 1
        binding.tvTitulo1.setText(listaTopLibros.get(0).getTitulo());
        binding.tvAutor1.setText(listaTopLibros.get(0).getAutor());
        binding.tvAnio1.setText(listaTopLibros.get(0).getAnio());
        binding.ivPortada1.setImageResource(listaTopLibros.get(0).getImagen());

        // Mostrar los datos del libro 2
        binding.tvTitulo2.setText(listaTopLibros.get(1).getTitulo());
        binding.tvAutor2.setText(listaTopLibros.get(1).getAutor());
        binding.tvAnio2.setText(listaTopLibros.get(1).getAnio());
        binding.ivPortada2.setImageResource(listaTopLibros.get(1).getImagen());

        // Mostrar los datos del libro 3
        binding.tvTitulo3.setText(listaTopLibros.get(2).getTitulo());
        binding.tvAutor3.setText(listaTopLibros.get(2).getAutor());
        binding.tvAnio3.setText(listaTopLibros.get(2).getAnio());
        binding.ivPortada3.setImageResource(listaTopLibros.get(2).getImagen());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // evita memory leaks
    }
}