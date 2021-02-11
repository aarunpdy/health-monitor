package com.example.healthmonitor.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.healthmonitor.R;
import com.example.healthmonitor.databinding.FragmentChatBotBinding;
import com.example.healthmonitor.databinding.FragmentLoginBinding;
import com.example.healthmonitor.presenter.ChatContract;
import com.example.healthmonitor.presenter.ChatPresenter;
import com.example.healthmonitor.ui.adapter.ChatAdapter;

public class ChatBotFragment extends Fragment implements ChatContract.View {

    private FragmentChatBotBinding binding;
    private ChatAdapter chatAdapter;
    private ChatPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_bot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentChatBotBinding.bind(view);

        binding.chatEditText.setOnEditorActionListener(searchBoxListener);
        binding.chatSentButton.setOnClickListener(v -> addMessage());

        // Instantiate presenter and attach view
        this.presenter = new ChatPresenter();
        presenter.attachView(this);

        // Instantiate the adapter and give it the list of chat objects
        this.chatAdapter = new ChatAdapter(presenter.getChatObjects());

        // Set up the RecyclerView with adapter and layout manager
        binding.chatRecyclerView.setAdapter(chatAdapter);
        binding.chatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.chatRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void notifyAdapterObjectAdded(int position) {
        this.chatAdapter.notifyItemInserted(position);
    }

    @Override
    public void scrollChatDown() {
        binding.chatRecyclerView.scrollToPosition(presenter.getChatObjects().size() - 1);
    }

    private final EditText.OnEditorActionListener searchBoxListener = (tv, actionId, keyEvent) -> {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            if (!TextUtils.isEmpty(tv.getText())) {
                addMessage();
                return true;
            }
        }
        return false;
    };

    private void addMessage() {
        presenter.onEditTextActionDone(binding.chatEditText.getText().toString());
        binding.chatEditText.getText().clear();
    }
}