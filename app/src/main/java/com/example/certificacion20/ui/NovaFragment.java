package com.example.certificacion20.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.certificacion20.R;
import com.example.certificacion20.adapter.NovaAdapter;
import com.example.certificacion20.databinding.FragmentNovaBinding;
import com.example.certificacion20.model.Nova;
import com.example.certificacion20.viewmodel.NovaViewModel;
import androidx.lifecycle.Observer;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NovaFragment extends Fragment {

    private static final String TAG = "Home";
    private FragmentNovaBinding binding;
    private NovaViewModel viewModel;
    private NovaAdapter adapter;
    private ArrayList<Nova> novaList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNovaBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(NovaViewModel.class);

        initRecyclerView();
        observeData();
        viewModel.getNova();
    }

    private void observeData() {
        viewModel.getNovaList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Nova>>() {
            @Override
            public void onChanged(ArrayList<Nova> nova) {
                Log.e(TAG, "onChanged: " + nova.size() );
                adapter.updateList(nova);
            }
        });
    }
    private void initRecyclerView() {
        binding.novaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NovaAdapter(getContext(),novaList);
        binding.novaRecycler.setAdapter(adapter);
    }
}