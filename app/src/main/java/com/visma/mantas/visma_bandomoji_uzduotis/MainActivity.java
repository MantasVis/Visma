package com.visma.mantas.visma_bandomoji_uzduotis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dog> dogURLS = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(MainActivity.this, dogURLS));
    }

    private void readFromFile() throws IOException
    {
        InputStream inputStream = getAssets().open("dog_urls.json");
        Scanner input = new Scanner(inputStream);

        String line;

        while(input.hasNextLine())
        {
            line = input.nextLine();
            if(line.contains("http"))
            {
                line = line.replaceAll("[\\s+|,|\"]","");
                dogURLS.add(new Dog(line));
            }
        }
    }
}