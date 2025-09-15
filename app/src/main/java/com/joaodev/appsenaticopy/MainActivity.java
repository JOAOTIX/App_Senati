package com.joaodev.appsenaticopy;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.joaodev.appsenaticopy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Require navigation fragments -> no muestra tabs en esas pantallas
        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> {
            int id = navDestination.getId();
            if (id == R.id.navigation_splash || id == R.id.navigation_login
                    || id == R.id.navigation_cronograma || id== R.id.navigation_birthday
                    || id==R.id.navigation_horario || id==R.id.navigation_fotocheck
                    || id==R.id.navigation_listadosedes || id==R.id.navigation_mapa) {
                navView.setVisibility(View.INVISIBLE);
            } else {
                navView.setVisibility(View.VISIBLE);
            }
        });
    }

}