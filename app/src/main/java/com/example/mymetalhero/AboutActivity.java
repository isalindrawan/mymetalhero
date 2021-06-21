package com.example.mymetalhero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    private TextView about;
    private CircleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        about = findViewById(R.id.about_devel);
        imageView = findViewById(R.id.image_devel);
        about.setText("Lahir di Jakarta pada 7 juni 1991, developer merupakan anak pertama dari 3 bersaudara. selama hidupnya developer banyak sekali mengalami kegagalan, mulai dari kegagalan cinta, hidup, pendidikan dan keluarga. namun developer terus bangkit dengan semangat menguasai dunia untuk menjadi raja bajak sawah. setelah berkali kali mengalami kegagalan dalam dunia perkuliahan, akhirnya developer berhasil menjadi programmer, bukan pro-gamer. walaupun diusia yang menjelang senja dan belum melepas status bujang serta mempertahankan keperjakaan. cukup sekian. adios ...");
        imageView.setImageResource(R.drawable.about);
    }
}