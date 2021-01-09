package com.example.certificacion20.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.certificacion20.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class DetallesFagment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) inflater.inflate(R.layout.fragment_detalles,container,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(" ", "info@novaera.cl", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, " ");
                startActivity(Intent.createChooser(emailIntent, getActivity().getString(R.string.enviar_correo)));
            }
        });
    }

}