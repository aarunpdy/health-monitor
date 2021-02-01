package com.example.healthmonitor.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.example.healthmonitor.R;
import com.example.healthmonitor.databinding.FragmentLoginBinding;
import com.example.healthmonitor.ui.activities.HomeActivity;


public class LoginFragment extends Fragment {

    enum LoginState {
        LOG_IN,
        SIGN_UP;
    }

    private LoginState loginState = LoginState.LOG_IN;
    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentLoginBinding.bind(view);

        prepareView();
    }

    private void prepareView() {
        binding.loading.setVisibility(View.GONE);
        if (loginState == LoginState.LOG_IN) {
            binding.username.setVisibility(View.GONE);
            binding.usernameText.setVisibility(View.GONE);

            binding.titleText.setText(R.string.login);
            binding.loginButton.setText(R.string.action_sign_in);
            binding.signUpButton.setText(R.string.action_sign_up);
            binding.signUpText.setText(R.string.create_account_desc);
        } else {
            binding.username.setVisibility(View.VISIBLE);
            binding.usernameText.setVisibility(View.VISIBLE);

            binding.titleText.setText(R.string.action_sign_up);
            binding.loginButton.setText(R.string.action_sign_up);
            binding.signUpButton.setText(R.string.action_sign_in);
            binding.signUpText.setText(R.string.login_account_desc);
        }

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: validate input data
            }
        };

        binding.username.addTextChangedListener(afterTextChangedListener);
        binding.passwordEditText.addTextChangedListener(afterTextChangedListener);
        binding.passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                doFormAction();
            }
            return false;
        });

        binding.loginButton.setOnClickListener(v -> {
            doFormAction();
        });

        binding.signUpButton.setOnClickListener(v -> {
            if (loginState == LoginState.SIGN_UP) {
                loginState = LoginState.LOG_IN;
            } else {
                loginState = LoginState.SIGN_UP;
            }

            prepareView();
        });
    }

    private void doFormAction() {
        binding.loading.setVisibility(View.VISIBLE);
        if (loginState == LoginState.SIGN_UP) {
            // TODO: make sign up call
        } else {
            // TODO: make login call
        }
        // on success operation
    }

    private void onLoginSuccess() {
        startActivity(new Intent(getActivity(), HomeActivity.class));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(
                    getContext().getApplicationContext(),
                    errorString,
                    Toast.LENGTH_LONG).show();
        }
    }
}