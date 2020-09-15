package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    int first = new Random().nextInt(4);

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
                for (int a = 0; a <= 4; a++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textWord.setText(words[a]);
                }
                int randomInt = random.nextInt(4);
                while (first == randomInt) {
                    randomInt = random.nextInt(4);
                }
                first = randomInt;
                textWord.setText(words[first]);
                Log.d("Random Int", Integer.toString(first));
            }
        });
    }
}