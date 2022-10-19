package com.example.baigiuaky2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dangKy extends AppCompatActivity {
    Button btdangky;
    TextView linkdangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        //anh xa
        btdangky = (Button)findViewById(R.id.btDangKy);
        linkdangnhap = (TextView) findViewById(R.id.linkDangNhap);

        //su kien dang ky, link dang nhap
        btdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        linkdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dangKy.this,dangNhap.class);
                startActivity(i);
            }
        });
    }
}