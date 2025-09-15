package com.joaodev.appsenaticopy.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaodev.appsenaticopy.R;
import com.joaodev.appsenaticopy.databinding.FragmentMicuentaBinding;


public class Micuenta extends Fragment {
    FragmentMicuentaBinding binding;
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
        binding = FragmentMicuentaBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);
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
        binding.btnArrow.setOnClickListener(v -> navController.popBackStack());
        binding.cerrarSesion.setOnClickListener(v -> navController.navigate(R.id.navigation_login));
    }
}