package com.joaodev.appsenaticopy.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
<<<<<<< HEAD
=======
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
>>>>>>> c1c659f (añadiendo las vistas trabajadas)
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaodev.appsenaticopy.R;
import com.joaodev.appsenaticopy.databinding.FragmentListadosedesBinding;


public class Listadosedes extends Fragment {

    FragmentListadosedesBinding binding;
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
        binding = FragmentListadosedesBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
<<<<<<< HEAD
=======

>>>>>>> c1c659f (añadiendo las vistas trabajadas)
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


        binding.containerSede.setOnClickListener(v -> navController.navigate(R.id.navigation_mapa));
        binding.btnArrow.setOnClickListener(v -> navController.popBackStack());
>>>>>>> c1c659f (añadiendo las vistas trabajadas)
    }
}