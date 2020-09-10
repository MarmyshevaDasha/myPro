package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] words = getResources().getStringArray(R.array.crocodile);
        final Random random = new Random();
        final TextView textWord = view.findViewById(R.id.textWord);
        Button button = view.findViewById(R.id.buttonWord);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomInt = random.nextInt(4);
                textWord.setText(words[randomInt]);
                Log.d("Random Int", Integer.toString(randomInt));
            }
        });
    }
}