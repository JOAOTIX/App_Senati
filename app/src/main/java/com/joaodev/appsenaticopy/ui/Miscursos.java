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
import android.widget.LinearLayout;

import com.joaodev.appsenaticopy.R;
import com.joaodev.appsenaticopy.databinding.FragmentMiscursosBinding;

public class Miscursos extends Fragment {
    FragmentMiscursosBinding binding;
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
        binding = FragmentMiscursosBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);
        binding.btnArrow.setOnClickListener(v -> navController.popBackStack());
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
        View underlineEnProgreso = view.findViewById(R.id.underlineEnProgreso);
        View underlineHistorico = view.findViewById(R.id.underlineHistorico);

        LinearLayout btnEnProgreso = view.findViewById(R.id.btnEnProgreso);
        LinearLayout btnHistorico = view.findViewById(R.id.btnHistorico);

        btnEnProgreso.setOnClickListener(v -> {
            underlineEnProgreso.setVisibility(View.VISIBLE);
            underlineHistorico.setVisibility(View.GONE);

        });

        btnHistorico.setOnClickListener(v -> {
            underlineEnProgreso.setVisibility(View.GONE);
            underlineHistorico.setVisibility(View.VISIBLE);

        });

    }
}