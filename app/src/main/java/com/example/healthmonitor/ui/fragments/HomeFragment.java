package com.example.healthmonitor.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthmonitor.R;
import com.example.healthmonitor.databinding.FragmentHomeBinding;
import com.example.healthmonitor.databinding.HealthcardViewBinding;
import com.example.healthmonitor.model.event.HealthCard;
import com.example.healthmonitor.model.event.HealthEvent;
import com.example.healthmonitor.model.utils.HealthUtils;
import com.example.healthmonitor.proxy.APIService;
import com.example.healthmonitor.proxy.ApiUtils;
import com.example.healthmonitor.ui.adapter.ChatAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private APIService mAPIService = ApiUtils.getAPIService();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);

            binding.eventCardContainer.removeAllViews();
        List<HealthCard> cardList = HealthUtils.getHealthEvents();
        for (HealthCard card : cardList) {
            View cardView = getActivity().getLayoutInflater().inflate(R.layout.healthcard_view, null, false);
            HealthcardViewBinding binder = HealthcardViewBinding.bind(cardView);
            binder.getRoot().setBackgroundResource(R.drawable.health_event_bg);
            binder.eventImage.setImageResource(card.icon);
            binder.eventName.setText(card.getName());
            binder.eventValue.setText(card.value);
            binder.eventValue.setVisibility(View.VISIBLE);
            binder.eventEditText.setVisibility(View.GONE);

            binding.eventCardContainer.addView(cardView);
            binding.eventCardContainer.addView(new View(getActivity()), new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 24));
        }

       // getAllData();
    }

    public void getAllData() {
        mAPIService.getAllData().enqueue(new Callback<HealthCard>() {
            @Override
            public void onResponse(Call<HealthCard> call, Response<HealthCard> response) {

                if (response.isSuccessful()) {
                    Log.i("TAG", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<HealthCard> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API.");
            }
        });
    }
}