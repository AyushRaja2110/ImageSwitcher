package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    ImageButton btnprev,btnnext;
    int image[] = {R.drawable.alto,R.drawable.baleno,R.drawable.celerio,R.drawable.ciaz,R.drawable.eeco,R.drawable.dzire,R.drawable.ertiga};
    int counter = 0;
    int n = image.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageswitcher);
        btnprev = findViewById(R.id.btnbefore);
        btnnext = findViewById(R.id.btnafter);

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter<=0){
                    counter=n-1;
                }
                else {
                    counter--;
                }
                imageSwitcher.setImageResource(image[counter]);

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter>=n-1){
                    counter=0;
                }
                else {
                    counter++;
                }
                imageSwitcher.setImageResource(image[counter]);

            }
        });

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView i1 = new ImageView(MainActivity.this);
                i1.setImageResource(R.drawable.alto);
                return i1;
            }
        });

    }
}