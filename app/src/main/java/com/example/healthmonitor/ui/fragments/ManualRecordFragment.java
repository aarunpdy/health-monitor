package com.example.healthmonitor.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthmonitor.R;
import com.example.healthmonitor.databinding.FragmentHomeBinding;
import com.example.healthmonitor.databinding.FragmentManualRecordBinding;
import com.example.healthmonitor.databinding.HealthcardViewBinding;
import com.example.healthmonitor.model.event.HealthCard;
import com.example.healthmonitor.model.utils.HealthUtils;

import java.util.List;

public class ManualRecordFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_manual_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManualRecordBinding binding = FragmentManualRecordBinding.bind(view);

        binding.eventCardContainer.removeAllViews();
        List<HealthCard> cardList = HealthUtils.getHealthEventsForEdit();
        for (HealthCard card : cardList) {
            View cardView = getActivity().getLayoutInflater().inflate(R.layout.healthcard_view, null, false);
            HealthcardViewBinding binder = HealthcardViewBinding.bind(cardView);
            binder.eventImage.setImageResource(card.icon);
            binder.eventName.setText(card.getName());
            binder.eventValue.setVisibility(View.GONE);
            binder.eventEditText.setVisibility(View.VISIBLE);
            binder.eventEditText.setHint(card.hint);
            binder.eventEditText.setText(null);

            binding.eventCardContainer.addView(cardView);
        }
    }
}