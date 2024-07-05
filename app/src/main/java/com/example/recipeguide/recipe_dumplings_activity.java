package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class recipe_dumplings_activity extends AppCompatActivity {


    private Ingredient_Dumplings_Fragment ingridientFragment = new Ingredient_Dumplings_Fragment();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_dumplings);


        setNewFragment(ingridientFragment);

        findViewById(R.id.ingredient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(ingridientFragment);
            }
        });

        findViewById(R.id.recipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipe_Dumplings_Fragment receptFragment = new Recipe_Dumplings_Fragment();
                setNewFragment(receptFragment);
            }
        });

    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}