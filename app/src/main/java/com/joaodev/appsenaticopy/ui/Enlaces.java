package com.joaodev.appsenaticopy.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.joaodev.appsenaticopy.databinding.FragmentEnlacesBinding;


public class Enlaces extends Fragment {

    FragmentEnlacesBinding binding;
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
        binding = FragmentEnlacesBinding.inflate(inflater, container, false);
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

        binding.btnWeb.setOnClickListener(v -> {
            String url = "https://www.senati.edu.pe/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        binding.btnAula.setOnClickListener(v -> {
            String url = "https://aulavirtual.senati.edu.pe/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        binding.btnBiblioteca.setOnClickListener(v -> {
            String url = "https://senatipe.sharepoint.com/sites/innovacion/bv/SitePages/Home.aspx";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}