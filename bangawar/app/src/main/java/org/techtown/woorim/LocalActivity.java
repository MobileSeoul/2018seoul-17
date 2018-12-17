package org.techtown.woorim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class LocalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        Button Button3 = (Button) findViewById(R.id.button3);
        Button Button4 = (Button) findViewById(R.id.button4);
        Button Button5 = (Button) findViewById(R.id.button5);
        Button Button6 = (Button) findViewById(R.id.button6);
        Button Button7 = (Button) findViewById(R.id.button7);
        Button Button8 = (Button) findViewById(R.id.button8);
        Button Button9 = (Button) findViewById(R.id.button9);
        Button Button10 = (Button) findViewById(R.id.button10);
        Button Button11 = (Button) findViewById(R.id.button11);
        Button Button12 = (Button) findViewById(R.id.button12);
        Button Button13 = (Button) findViewById(R.id.button13);
        Button Button14 = (Button) findViewById(R.id.button14);
        Button Button15 = (Button) findViewById(R.id.button15);
        Button Button16 = (Button) findViewById(R.id.button16);
        Button Button17 = (Button) findViewById(R.id.button17);
        Button Button18 = (Button) findViewById(R.id.button18);
        Button Button19 = (Button) findViewById(R.id.button19);
        Button Button20 = (Button) findViewById(R.id.button20);
        Button Button21 = (Button) findViewById(R.id.button21);
        Button Button22 = (Button) findViewById(R.id.button22);
        Button Button23 = (Button) findViewById(R.id.button23);
        Button Button24 = (Button) findViewById(R.id.button24);
        Button Button25 = (Button) findViewById(R.id.button25);
        Button Button26 = (Button) findViewById(R.id.button26);
        Button Button = (Button) findViewById(R.id.button);


        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "금천구");
                startActivity(intent);
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "구로구");
                startActivity(intent);
            }
        });
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "강서구");
                startActivity(intent);
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "양천구");
                startActivity(intent);
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "관악구");
                startActivity(intent);
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "영등포구");
                startActivity(intent);
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "동작구");
                startActivity(intent);
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "강남구");
                startActivity(intent);
            }
        });
        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "서초구");
                startActivity(intent);
            }
        });
        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "송파구");
                startActivity(intent);
            }
        });
        Button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "마포구");
                startActivity(intent);
            }
        });
        Button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "은평구");
                startActivity(intent);
            }
        });
        Button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "성동구");
                startActivity(intent);
            }
        });
        Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "용산구");
                startActivity(intent);
            }
        });
        Button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "서대문구");
                startActivity(intent);
            }
        });
        Button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "종로구");
                startActivity(intent);
            }
        });
        Button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "성동구");
                startActivity(intent);
            }
        });
        Button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "강북구");
                startActivity(intent);
            }
        });
        Button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "동대문구");
                startActivity(intent);
            }
        });
        Button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "도봉구");
                startActivity(intent);
            }
        });
        Button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "중랑구");
                startActivity(intent);
            }
        });
        Button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "노원구");
                startActivity(intent);
            }
        });
        Button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "광진구");
                startActivity(intent);
            }
        });
        Button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "강동구");
                startActivity(intent);
            }
        });
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalActivity.this, ListActivity.class);
                intent.putExtra("localstring", "중구");
                startActivity(intent);
            }
        });




    }
}
