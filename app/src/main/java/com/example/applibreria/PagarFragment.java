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

import com.example.applibreria.databinding.FragmentPagarBinding;


public class PagarFragment extends Fragment {


    private FragmentPagarBinding binding;

    public PagarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Usar boton atras del dispositivo para volver al fragment anterior
        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override public void handleOnBackPressed() {
                        NavController nav = Navigation.findNavController(requireView());
                        // Vuelve al anterior si hay algo en el back stack
                        if (!nav.popBackStack()) {
                            // Si no hay a dónde volver, cierra la Activity
                            requireActivity().finish();
                        }
                    }
                }
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // evita memory leaks
    }
}