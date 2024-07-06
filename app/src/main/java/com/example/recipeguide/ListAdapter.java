package com.example.recipeguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class ListAdapter extends ArrayAdapter<NameOfDish> {
    public ListAdapter(Context context, ArrayList<NameOfDish> nameOfDishArrayList){
        super(context, R.layout.layout_search_list, nameOfDishArrayList);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NameOfDish nameOfDish = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_search_list, parent, false);
        }

        TextView NameOfDish = convertView.findViewById(R.id.recipe_name);

        NameOfDish.setText(nameOfDish.nameOfdish);

        return convertView;
    }
}
