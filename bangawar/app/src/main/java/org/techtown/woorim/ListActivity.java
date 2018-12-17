package org.techtown.woorim;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.Signature;

public class ListActivity extends AppCompatActivity {
    private ArrayAdapter divisionAdapter;
    private Spinner divisionSpinner;

    private String placeName = "";
    private String placeAddr = "";
    private String placeTime = "";
    private String placeNumber = "";
    private String placeUrl = "";
    private String placeIntro = "";
    private String placeRegion = "";
    private String placeCategory = "";
    private String placeMenu = "";

    private ListView placeListView;
    private PlaceListAdapter adapter;
    private List<Place> placeList;

    String lstring;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Intent intent = getIntent();
        lstring = intent.getStringExtra("localstring");
        new BackgroundTask().execute();

        final String finalPlaceName = placeName;

        placeListView = (ListView) findViewById(R.id.placeListView);
        placeList = new ArrayList<Place>();
        adapter = new PlaceListAdapter(getApplicationContext(), placeList);
        placeListView.setAdapter(adapter);



        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PlaceDetail.class);

                intent.putExtra("placeName", placeList.get(i).getPlaceName());
                intent.putExtra("placeAddr", placeList.get(i).getPlaceAddr());
                intent.putExtra("placeTime", placeList.get(i).getPlaceTime());
                intent.putExtra("placeNumber", placeList.get(i).getPlaceNumber());
                intent.putExtra("placeUrl", placeList.get(i).getPlaceUrl());
                intent.putExtra("placeIntro", placeList.get(i).getPlaceIntro());
                intent.putExtra("placeRegion", placeList.get(i).getPlaceRegion());
                intent.putExtra("placeCategory", placeList.get(i).getPlaceCategory());
                intent.putExtra("placeMenu", placeList.get(i).getPlaceMenu());
                startActivity(intent);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute() {
            try {
                target = "http://woorim1022.cafe24.com/PlaceList.php?placeDivision=" + URLEncoder.encode(lstring, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp).append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) { super.onProgressUpdate(); }

        @Override
        public void onPostExecute(String result) {
            try {
                placeList.clear();
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                String placeName = ""; // 이름
                String placeAddr = ""; // 주소
                String placeTime = ""; // 시간
                String placeNumber = ""; // 전화번호
                String placeUrl = ""; // 이미지
                String placeIntro = ""; // 소개
                String placeRegion = ""; // 지역별
                String placeCategory = ""; // 장소별
                String placeMenu = ""; // 메뉴
                int count = 0;
                while (count < jsonArray.length())
                {
                    JSONObject object = jsonArray.getJSONObject(count);
                    placeName = object.getString("placeName");
                    placeAddr = object.getString("placeAddr");
                    placeTime = object.getString("placeTime");
                    placeNumber = object.getString("placeNumber");
                    placeUrl = object.getString("placeUrl");
                    placeIntro = object.getString("placeIntro");
                    placeRegion = object.getString("placeRegion");
                    placeCategory = object.getString("placeCategory");
                    placeMenu = object.getString("placeMenu");
                    Place place = new Place(placeName, placeAddr, placeTime, placeNumber, placeUrl, placeIntro, placeRegion, placeCategory, placeMenu);
                    placeList.add(place);
                    count++;
                }
                if(count == 0)
                {
                    AlertDialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                    dialog = builder.setMessage("조회되지 않습니다.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}