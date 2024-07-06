package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.jar.Attributes;


public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    private String[] dishesArr = {"ПЕЛЬМЕНИ С УКРОПОМ  ОБЫКНОВЕННЫЕ", "СОСИСКИ С КАРТОШКОЙ", "РИС С ОВОЩАМИ", "САЛАТ ОЛИВЬЕ","ТОРТ НАПОЛЕОН"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.search_field);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishesArr);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDish = parent.getItemAtPosition(position).toString();
                Toast.makeText(SearchActivity.this, "Вы выбрали: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                Intent intent;
                switch (selectedDish) {
                    case "РИС С ОВОЩАМИ":
                        intent = new Intent(SearchActivity.this, Recipe_Rice_Activity.class);
                        break;
                    case "ПЕЛЬМЕНИ С УКРОПОМ  ОБЫКНОВЕННЫЕ":
                        intent = new Intent(SearchActivity.this, recipe_dumplings_activity.class);
                        break;
                    case "СОСИСКИ С КАРТОШКОЙ":
                        intent = new Intent(SearchActivity.this, Recipe_Sausages_Activity.class);
                        break;
                    case "САЛАТ ОЛИВЬЕ":
                        intent = new Intent(SearchActivity.this, Recipe_Olivie_Activity.class);
                        break;
                    case "ТОРТ НАПОЛЕОН":
                        intent = new Intent(SearchActivity.this, Recipe_Napoleon_Activity.class);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + selectedDish);
                }



                intent.putExtra("nameOfDish", dishesArr[position]);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
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