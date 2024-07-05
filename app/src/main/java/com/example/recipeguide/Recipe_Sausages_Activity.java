package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Recipe_Sausages_Activity extends AppCompatActivity {

    private Ingredients_Sausages_Fragment ingridientFragment = new Ingredients_Sausages_Fragment();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_sausages);

        setNewFragment(ingridientFragment);

        findViewById(R.id.ingridient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(ingridientFragment);
            }
        });

        findViewById(R.id.recept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipe_Sausages_Fragment receptFragment= new Recipe_Sausages_Fragment();
                setNewFragment(receptFragment);
            }
        });

    }
    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout2,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }}