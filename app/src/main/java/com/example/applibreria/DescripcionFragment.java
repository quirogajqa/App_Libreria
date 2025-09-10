package com.example.applibreria;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applibreria.databinding.FragmentDescripcionBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class DescripcionFragment extends Fragment {

    private FragmentDescripcionBinding binding;

    public DescripcionFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDescripcionBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Usar boton atras del dispositivo para volver al fragment anterior
        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        NavController nav = Navigation.findNavController(requireView());
                        // Vuelve al anterior si hay algo en el back stack
                        if (!nav.popBackStack()) {
                            // Si no hay a dónde volver, cierra la Activity
                            requireActivity().finish();
                        }
                    }
                }
        );

        // Recibir argumentos enviados desde el adapter
        Bundle args = requireArguments();
        String titulo = args.getString("titulo", "");
        String autor = args.getString("autor", "");
        String anio = args.getString("anio", "");
        int descripcion = args.getInt("descripcion", 0);
        int imagen = args.getInt("imagenResId", 0);
        double precio = args.getDouble("precio", 0);

        binding.tvTitulo.setText(titulo);
        binding.tvAutor.setText(autor);
        binding.tvAnio.setText(anio);
        binding.tvDetalle.setText(descripcion);
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        binding.tvPrecioDesc.setText(formatoMoneda.format(precio));

        if (imagen != 0) {
            binding.ivPortada.setImageResource(imagen);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // evita memory leaks
    }

}