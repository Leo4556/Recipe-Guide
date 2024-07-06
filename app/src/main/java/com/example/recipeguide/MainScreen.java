package com.example.recipeguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }



    public void goAddScreen(View view){
        Intent intent = new Intent(this, AddScreen.class);
        startActivity(intent);
    }

    public void goFavourites(View view){
        Intent intent = new Intent(this, FavouritesScreen.class);
        startActivity(intent);
    }

    public void goRecipeDumplings(View view){
        Intent intent = new Intent(this, recipe_dumplings_activity.class);
        startActivity(intent);
    }


    public void goRecipeRice(View view){
        Intent intent = new Intent(this, Recipe_Rice_Activity.class);
        startActivity(intent);
    }


    public void goRecipeSausages(View view){
        Intent intent = new Intent(this, Recipe_Sausages_Activity.class);
        startActivity(intent);
    }

    public void goToSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void goTea(View view) {
        Intent intent = new Intent(this, Recipe_Tea_Activity.class);
        startActivity(intent);
    }



}