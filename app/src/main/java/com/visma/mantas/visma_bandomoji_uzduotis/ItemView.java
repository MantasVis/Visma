package com.visma.mantas.visma_bandomoji_uzduotis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ItemView extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        Intent intent = getIntent();
        String url = intent.getExtras().getString("dogURL");

        imageView = findViewById(R.id.imageView);
        Picasso.get().load(url).placeholder(R.drawable.placeholder).into(imageView);
    }
}
