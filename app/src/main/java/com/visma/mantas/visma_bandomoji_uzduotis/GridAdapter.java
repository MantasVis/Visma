package com.visma.mantas.visma_bandomoji_uzduotis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter implements Serializable{

    private Context c;
    private ArrayList<Dog> dogs;


    public GridAdapter(Context c, ArrayList<Dog> dogs)
    {
        this.c = c;
        this.dogs = dogs;
    }

    @Override
    public int getCount() {
        return dogs.size();
    }

    @Override
    public Object getItem(int i) {
        return dogs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(c).inflate(R.layout.grid_item, viewGroup, false);
        }

        final Dog dog = (Dog) this.getItem(i);
        ImageView img = view.findViewById(R.id.dogImg);
        Picasso.get().load(dog.getUrl()).placeholder(R.drawable.placeholder).into(img);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c, ItemView.class);
                intent.putExtra("dogURL", dog.getUrl());
                c.startActivity(intent);
            }
        });
        return view;
    }
}