package com.joaodev.appsenaticopy.ui;

import android.content.Context;
<<<<<<< HEAD
=======
import android.content.Intent;
import android.net.Uri;
>>>>>>> c1c659f (añadiendo las vistas trabajadas)
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
<<<<<<< HEAD
=======
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
>>>>>>> c1c659f (añadiendo las vistas trabajadas)
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaodev.appsenaticopy.R;
import com.joaodev.appsenaticopy.databinding.FragmentHomeBinding;


public class Home extends Fragment {
    FragmentHomeBinding binding;
    View view;
    Context context;
    NavController navController;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);
<<<<<<< HEAD
=======
        ViewCompat.setOnApplyWindowInsetsListener(binding.header, (v, insets) -> {
            int statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top;

            v.setPadding(
                    v.getPaddingLeft(),
                    statusBarHeight + v.getPaddingTop(),
                    v.getPaddingRight(),
                    v.getPaddingBottom()
            );

            return insets;
        });


        //Redireccionando a las vistas correspondientes
        binding.btnSinfo.setOnClickListener(v -> {
            String url = "https://login.senati.edu.pe/authenticationendpoint/login.do?RelayState=eyJ0ZW5hbnRJZCI6ImZiOGNkZjlmLWQ5NDctNDVmNi1iYmMzLWU2YWQwNDk0ZGYwYSIsImFjY291bnRJZCI6IjAwMUcwMDAwMDBvU2h6S0lBUyIsImp3dENhbGxiYWNrVXJsIjoiaHR0cHM6Ly9leHBlcmllbmNlLmVsbHVjaWFuY2xvdWQuY29tL3NuZGFldGlzL2F1dGgvY2FsbGJhY2siLCJpZHBMb2dvdXRVcmwiOiJodHRwczovL2V4cGVyaWVuY2UuZWxsdWNpYW5jbG91ZC5jb20vaWRwLWxvZ291dCIsInRva2VuVmVyc2lvbiI6IjEuMS4wIn0%3D&commonAuthCallerPath=%2Fsamlsso&forceAuth=false&passiveAuth=false&tenantDomain=carbon.super&sessionDataKey=5b5f568d-11d5-4abe-aac2-979f30d225a5&relyingParty=Ellucian+Experience&type=samlsso&sp=Ellucian+Experience&isSaaSApp=false&authenticators=BasicAuthenticator%3ALOCAL";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        binding.btnMiscursos.setOnClickListener(v -> navController.navigate(R.id.navigation_miscursos));
        binding.btnMicuenta.setOnClickListener(v -> navController.navigate(R.id.navigation_micuenta));
        binding.btnCumple.setOnClickListener(v -> navController.navigate(R.id.navigation_birthday));
        binding.btnEnlaces.setOnClickListener(v -> navController.navigate(R.id.navigation_enlaces));
>>>>>>> c1c659f (añadiendo las vistas trabajadas)
    }
}