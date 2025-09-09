package com.example.applibreria;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applibreria.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private NavController navController;
    private LibroAdapter adapter;
    private List<Libro> listaLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar RecyclerView
        initRecyclerView();

        // Cargar datos
        cargarDatos();

        setupNavigation();
    }

    private void setupNavigation() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(binding.navHostFragment.getId());

        if (navHostFragment instanceof NavHostFragment) {
            navController = ((NavHostFragment) navHostFragment).getNavController();
            NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewLibros);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaLibros = new ArrayList<>();
        adapter = new LibroAdapter(listaLibros);
        recyclerView.setAdapter(adapter);
    }

    private void cargarDatos() {
        listaLibros.add(new Libro("La bailarina de Auschwitz", "Edith Eger", "2018", "@drawable/la_bailarina_de_auschwitz"));
        listaLibros.add(new Libro("El psicoanalista", "John Katzenbach", "2002", "@drawable/el_psicoanalista"));
        listaLibros.add(new Libro("La casa de los espíritus", "Isabel Allende", "1982", "@drawable/la_casa_de_los_espiritus"));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "1967", "@drawable/cien_anios_de_soledad"));
        listaLibros.add(new Libro("El hobbit", "J. R. R. Tolkien", "1937", "@drawable/el_hobbit"));
        listaLibros.add(new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling", "1997", "@drawable/harry_potter_y_la_piedra_filosofal"));
        listaLibros.add(new Libro("Fuego y sangre", "George R. R. Martin", "2018", "@drawable/fuego_y_sangre"));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "1605", "@drawable/don_quijote"));
        listaLibros.add(new Libro("Alas de sangre", "Rebecca Yarros", "2023", "@drawable/alas_de_sangre"));

// Notificar al adaptador que los datos han cambiado
        adapter.notifyDataSetChanged();
    }

}