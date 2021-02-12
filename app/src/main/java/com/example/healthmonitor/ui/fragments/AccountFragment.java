package com.example.healthmonitor.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthmonitor.R;
import com.example.healthmonitor.databinding.FragmentAccountBinding;
import com.example.healthmonitor.ui.activities.LoginActivity;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    private boolean isEditMode = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAccountBinding.bind(view);

        updateUI();
    }

    private void updateUI() {
        binding.emailEditText.setEnabled(isEditMode);
        binding.nameEditText.setEnabled(isEditMode);
        binding.btnEdit.setText(isEditMode ? "Save" : "Edit");
        binding.btnEdit.setOnClickListener(v -> {
            isEditMode = !isEditMode;
            updateUI();
        });

        binding.btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        binding.btnSend.setOnClickListener(v -> {
            uploadData();
        });
    }

    private void uploadData() {
    }


}