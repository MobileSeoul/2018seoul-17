package org.techtown.woorim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);


        Button cafe = (Button) findViewById(R.id.cafe);
        Button food = (Button) findViewById(R.id.food);
        Button hotel = (Button) findViewById(R.id.hotel);
        Button park = (Button) findViewById(R.id.park);
        Button hospital = (Button) findViewById(R.id.hospital);
        Button phar = (Button) findViewById(R.id.phar);


        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "카페");
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "음식점");
                startActivity(intent);
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "숙박");
                startActivity(intent);
            }
        });
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "야외");
                startActivity(intent);
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "병원");
                startActivity(intent);
            }
        });
        phar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceActivity.this, ListActivity.class);
                intent.putExtra("localstring", "약국");
                startActivity(intent);
            }
        });
    }
}
