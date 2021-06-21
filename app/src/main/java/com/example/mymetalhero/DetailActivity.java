package com.example.mymetalhero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.fontawesome.FontTextView;

public class DetailActivity extends AppCompatActivity {

    private BandData bandData;
    private Intent intent;
    private TextView origin, status, year, label, genre, about;
    private ImageView band_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.band_info);

        // initialize components
        init();

        // initialize intent
        intent = getIntent();
        this.bandData = intent.getParcelableExtra("band");

        // set Title
        setActionBarTitle(this.bandData.getBand());
        
        showData();

    }

    private void showData() {

        origin.setText(bandData.getOrigin());
        status.setText(bandData.getStatus());
        year.setText(bandData.getYear());
        label.setText(bandData.getLabel());
        genre.setText(bandData.getGenre());
        about.setText(bandData.getAbout());
        band_image.setImageResource(bandData.getImage());
    }

    private void init() {

        origin = findViewById(R.id.origin);
        status = findViewById(R.id.status);
        year = findViewById(R.id.year);
        label = findViewById(R.id.label);
        genre = findViewById(R.id.genre);
        about = findViewById(R.id.about);
        band_image = findViewById(R.id.band_image);
    }

    private void setActionBarTitle(String title) {

        if(getSupportActionBar() != null) {

            getSupportActionBar().setTitle(title);
        }
    }
}