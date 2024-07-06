package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Recipe_Rice_Activity extends AppCompatActivity {


    private Ingredient_Rice_Fragment ingridientFragment = new Ingredient_Rice_Fragment();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_rice);

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
                Recipe_Rice_Fragment recipeFragment = new Recipe_Rice_Fragment();
                setNewFragment(recipeFragment);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("nameOfDish");
            // Вы можете отобразить имя блюда в TextView или использовать его как угодно
        }
    }


    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout1, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goAddScreen(View view){
        Intent intent = new Intent(this, AddScreen.class);
        startActivity(intent);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void goFavourites(View view){
        Intent intent = new Intent(this, FavouritesScreen.class);
        startActivity(intent);
    }

}