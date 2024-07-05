package com.example.recipeguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import androidx.core.app.ActivityCompat;
import androidx.annotation.NonNull;



public class AddScreen extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_WRITE = 123; // Replace 123 with your desired integer value
    private static final int REQUEST_PERMISSION = 100;
    private static final int PICK_IMAGE_REQUEST = 1;
    public ImageView imageView;
    private ImageButton ingredients_button, recipe_button;
    private IngredientsFragment ingredientsFragment = new IngredientsFragment();
    private EditText recipeNameEditText;
    private EditText preparationTimeEditText;
    private RecipeFragment recipeFragment;
    private ImageButton button_save;

    private EditText ingredients;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }

        ImageButton btnAddImage = findViewById(R.id.button_add_photo);

        ((View) btnAddImage).setOnClickListener(v -> openImageChooser());

        // Request permission if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
            }
        }


        findViewById(R.id.ingredients_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(ingredientsFragment);

            }
        });

        findViewById(R.id.recipe_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecipeFragment recipeFragment = new RecipeFragment();
                setNewFragment(recipeFragment);

            }
        });

        ingredients = findViewById(R.id.ingredients);

        recipeNameEditText = findViewById(R.id.recipe_name);
        preparationTimeEditText = findViewById(R.id.preparation_time);
        button_save = findViewById(R.id.button_save);

        ingredientsFragment = new IngredientsFragment();
        recipeFragment = new RecipeFragment();

        button_save.setOnClickListener(v -> {
            if (validateInputs()) {
                saveData();
            } else {
                // Show an error message to the user
                Toast.makeText(AddScreen.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
            }
        }




    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_ingredients, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private boolean validateInputs() {
        String recipeName = recipeNameEditText.getText().toString().trim();
        String preparationTime = preparationTimeEditText.getText().toString().trim();

        boolean isActivityDataValid = !recipeName.isEmpty() && !preparationTime.isEmpty();
        boolean isIngredientsDataValid = ingredientsFragment != null && ingredientsFragment.validateInputs();
        boolean isRecipeDataValid = recipeFragment != null && recipeFragment.validateInputs();

        return isActivityDataValid && isIngredientsDataValid && isRecipeDataValid;
    }


    private void saveData() {
        String recipeName = recipeNameEditText.getText().toString().trim();
        String preparationTime = preparationTimeEditText.getText().toString().trim();
        String ingredientsData = ingredientsFragment != null ? ingredientsFragment.getIngredientsData() : "";
        String recipeData = recipeFragment != null ? recipeFragment.getRecipeData() : "";

        File path = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (path == null) {
            Toast.makeText(this, "Не удалось получить путь к файлу", Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(path, "recipe_data.txt");

        if (!path.exists() && !path.mkdirs()) {
            Toast.makeText(this, "Не удалось создать директорию", Toast.LENGTH_SHORT).show();
            return;
        }


        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(("Recipe Name: " + recipeName + "\n").getBytes());
            fos.write(("Preparation Time: " + preparationTime + "\n").getBytes());
            fos.write(("Ingredients: " + ingredientsData + "\n").getBytes());
            fos.write(("Recipe: " + recipeData + "\n").getBytes());
            Toast.makeText(this, "Данные сохранены в " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка сохранения данных", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestWritePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_WRITE);
        } else {
            boolean permissionGranted = true;
        }
    }



    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout_ingredients, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    public void goMainScreen(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }










    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Выберите изображение"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            } else {
                // Permission denied
            }
        }
    }


}
