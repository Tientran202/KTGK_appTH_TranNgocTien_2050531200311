package com.example.baigiuaky2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChitietActivity extends AppCompatActivity {

    LinearLayout btnbackct;
    ImageView anh;
    TextView ten,mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet);

        //anh xa
        btnbackct = (LinearLayout) findViewById(R.id.btnbackchitiet);
        anh = (ImageView)findViewById(R.id.anhct);
        ten = (TextView) findViewById(R.id.tenct);
        mota = (TextView) findViewById(R.id.motact);

        //khoi tao intent
        Intent it = getIntent();

        //Nhan du lieu
        Bundle bd = it.getBundleExtra("dulieu");

        String tens = bd.getString("ten");
        String motas = bd.getString("mota");
        int anhs = bd.getInt("anh");

        ten.setText(tens);
        mota.setText(motas);
        anh.setImageResource(anhs);


        // even back profile
        btnbackct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChitietActivity.this,BottomnavigationActivity.class);
                startActivity(i);
            }
        });
    }
}