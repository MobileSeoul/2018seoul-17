package org.techtown.woorim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class PlaceListAdapter extends BaseAdapter {
    Bitmap bitmap;

    private Context context;
    private List<Place> placeList;

    public PlaceListAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @Override
    public int getCount() { return placeList.size(); }

    @Override
    public Object getItem(int i) {
        return placeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.place, null);
        TextView placeName = (TextView) v.findViewById(R.id.placeName);
        TextView placeAddr = (TextView) v.findViewById(R.id.placeAddr);
        TextView placeNumber = (TextView) v.findViewById(R.id.placeNumber);
        ImageView placeUrl = (ImageView) v.findViewById(R.id.placeUrl);
        TextView placeCategory = (TextView) v.findViewById(R.id.placeCategory);

        final String imgurl = placeList.get(i).getPlaceUrl();
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

        placeName.setText(placeList.get(i).getPlaceName());
        placeAddr.setText(placeList.get(i).getPlaceAddr());
        placeNumber.setText(placeList.get(i).getPlaceNumber());
        placeCategory.setText(placeList.get(i).getPlaceCategory());

        return v;
    }
}