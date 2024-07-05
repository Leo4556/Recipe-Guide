package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileOutputStream;
import java.io.IOException;

public class IngredientsFragment extends Fragment {



    private EditText editTextIngredients;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        editTextIngredients = view.findViewById(R.id.ingredients);
        ImageButton saveButton = view.findViewById(R.id.button_save);
        return view;}

//        saveButton.setOnClickListener(v -> saveData());


        public boolean validateInputs() {
            String ingredients = editTextIngredients.getText().toString().trim();
            return !ingredients.isEmpty();
        }

        public String getIngredientsData() {
            return editTextIngredients.getText().toString().trim();
        }




    }

    /*private void saveData() {
        String ingredients = editTextIngredients.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = getActivity().openFileOutput("ingredients.txt", getContext().MODE_PRIVATE);
            fos.write(ingredients.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
