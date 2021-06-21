package com.example.mymetalhero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<BandData> bandData = new ArrayList<>();
    private BandAdapter bandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view_item);
        recyclerView.hasFixedSize();

        bandData.addAll(GenerateBandData.getBandData());

        setActionBarTitle("My Death Metal Hero");

        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // initiate option menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // handle selection on option menu
        switch (item.getItemId()) {

            case R.id.about_app: {

                Intent intent = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.exit_app:

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //initiate recycler list component
    private void showRecyclerList() {

        // set linear layout to recycler view layout
        // instantiate contact adapter to handle contacts data
        // add on click action to all contact adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bandAdapter = new BandAdapter(bandData);
        recyclerView.setAdapter(bandAdapter);

        bandAdapter.setOnItemClickCallback(new BandAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(BandData data) {

                showDetail(data);
            }
        });
    }

    private void showDetail(BandData band) {
        Intent intent = new Intent(getBaseContext(), DetailActivity.class);
        intent.putExtra("band", band);
        startActivity(intent);
    }

    private void setActionBarTitle(String my_death_metal_hero) {
    }
}