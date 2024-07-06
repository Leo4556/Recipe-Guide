package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Recipe_Tea_Activity extends AppCompatActivity {

    private Ingredients_Tea_Fragment ingridientFragment = new Ingredients_Tea_Fragment();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_tea);

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
                Recipe_Tea_Fragment receptFragment = new Recipe_Tea_Fragment();
                setNewFragment(receptFragment);
            }
        });

    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout1, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goAddScreen(View view) {
        Intent intent = new Intent(this, AddScreen.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void goFavourites(View view) {
        Intent intent = new Intent(this, FavouritesScreen.class);
        startActivity(intent);
    }
}