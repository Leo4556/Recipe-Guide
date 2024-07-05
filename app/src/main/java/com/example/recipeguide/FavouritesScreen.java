package com.example.recipeguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.recipeguide.R;
import java.util.List;
import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.recipeguide.R;

import java.util.ArrayList;
import java.util.List;


public class FavouritesScreen extends AppCompatActivity {

    private String[] dishesArr = new String[]{"Пельмени", "Рис", "Мясо"};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favourites_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Recipe> recipeList = new ArrayList<>();
        // Добавьте ваши элементы в recipeList
        recipeList.add(new Recipe(R.drawable.dumplings, "Пельмени"));
        recipeList.add(new Recipe(R.drawable.rice, "Рис"));
//        recipeList.add(new Recipe(R.drawable.salad1, "Какой-то салат"));
//        recipeList.add(new Recipe(R.drawable.salad2, "Вообще непонятно какой салат"));
        // Добавьте больше элементов при необходимости

        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);


    }



    public void goMainScreen(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void goAddScreen(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

}