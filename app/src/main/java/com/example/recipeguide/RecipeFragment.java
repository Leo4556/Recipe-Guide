package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileOutputStream;
import java.io.IOException;

public class RecipeFragment extends Fragment {

    private EditText editTextRecipe;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        editTextRecipe = view.findViewById(R.id.recipe);
        ImageButton saveButton = view.findViewById(R.id.button_save);

//        saveButton.setOnClickListener(v -> saveData());

        return view;}

        public boolean validateInputs() {
            String recipe = editTextRecipe.getText().toString().trim();
            return !recipe.isEmpty();
        }

        public String getRecipeData() {
            return editTextRecipe.getText().toString().trim();
        }



    }

    /*private void saveData() {
        String recipe = editTextRecipe.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = getActivity().openFileOutput("recipe.txt", getContext().MODE_PRIVATE);
            fos.write(recipe.getBytes());
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
