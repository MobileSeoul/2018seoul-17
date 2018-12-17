package org.techtown.woorim;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PlaceDetail extends AppCompatActivity implements OnMapReadyCallback {
    Bitmap bitmap;private final ThreadLocal<GoogleMap> mMap = new ThreadLocal<GoogleMap>();
    private Geocoder geocoder;
    String addr;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        double mLat = 0;
        double mLng = 0;
        mMap.set(googleMap);
        Geocoder mGeocoder = new Geocoder(this);
        try {
            List<Address> mResultLocation = mGeocoder.getFromLocationName(addr, 1);
            mLat = mResultLocation.get(0).getLatitude();
            mLng = mResultLocation.get(0).getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add a marker in Sydney and move the camera
        LatLng addrLocation = new LatLng(mLat, mLng);
        mMap.get().addMarker(new MarkerOptions().position(addrLocation).title(addr));
        mMap.get().moveCamera(CameraUpdateFactory.newLatLng(addrLocation));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(addrLocation, 15));
    }
    @Override
    protected void onCreate(Bundle savedInstanceStage) {
        super.onCreate(savedInstanceStage);
        setContentView(R.layout.placedetail);
        TextView tx1 = (TextView)findViewById(R.id.namefield);
        TextView tx2 = (TextView)findViewById(R.id.addrfield);
        TextView tx3 = (TextView)findViewById(R.id. timefield);
        TextView tx4 = (TextView)findViewById(R.id.numberfield);
        final ImageView placeUrl = (ImageView) findViewById(R.id.imageView);
        TextView tx5 = (TextView)findViewById(R.id.introfield);
        TextView tx6 = (TextView)findViewById(R.id.regionfield);
        TextView tx7 = (TextView)findViewById(R.id.categoryfield);
        TextView tx8 = (TextView)findViewById(R.id.menufield);
        Button call = (Button)findViewById(R.id.call);
        final TextView tv01;
        final RatingBar rb =(RatingBar)findViewById(R.id.ratingBar);
        Intent intent = getIntent(); /*데이터 수신*/

        String name = intent.getStringExtra("placeName");
        tx1.setText(name);
        addr = intent.getExtras().getString("placeAddr");
        tx2.setText(addr);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        String time = intent.getExtras().getString("placeTime");
        tx3.setText(time);
        final String number = intent.getExtras().getString("placeNumber");
        tx4.setText(number);
        final String imgurl = intent.getExtras().getString("placeUrl");
        if (imgurl.equals(""))
        {
            placeUrl.setImageResource(R.drawable.icon);
        }
        else
        {
            Thread mThread = new Thread() {
                @Override
                public void run(){
                    try {
                        URL url = new URL(imgurl);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoInput(true);
                        conn.connect();

                        InputStream is = conn.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            mThread.start();

            try {
                mThread.join();

                placeUrl.setImageBitmap(bitmap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String intro = intent.getExtras().getString("placeIntro");
        tx5.setText(intro);

        String region = intent.getExtras().getString("placeRegion");
        tx6.setText(region);

        String category = intent.getExtras().getString("placeCategory");
        tx7.setText(category);

        String menu = intent.getExtras().getString("placeMenu");
        tx8.setText(menu);

        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);

                }
        });

        LayerDrawable stars = (LayerDrawable) rb.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        tv01 = (TextView) findViewById(R.id.tv01);
        rb.setStepSize((float) 0.5);        //별 색깔이 1칸씩줄어들고 늘어남 0.5로하면 반칸씩 들어감// 처음보여줄때(색깔이 한개도없음) default 값이 0  이다
        rb.setIsIndicator(false);
        rb.setNumStars(5);//true - 별점만 표시 사용자가 변경 불가 , false - 사용자가 변경가능

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {


            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv01.setText("평점:" + rating);
            }




        });


    }
}