package com.example.baigiuaky2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class dangNhap extends AppCompatActivity {
    Button btdangnhap;
    TextView linkdangky;
    EditText ettendangnhap,etmatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        //anh xa
        btdangnhap = (Button) findViewById(R.id.btDangNhap);
        linkdangky = (TextView) findViewById(R.id.linkdangKy);
        ettendangnhap = (EditText)findViewById(R.id.ETtenDangNhap);
        etmatkhau =(EditText)findViewById(R.id.ETmatKhau);

        //su kien danh nhap
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dangNhap.this,BottomnavigationActivity.class);
                if(ettendangnhap.getText().toString().equals("") || etmatkhau.getText().toString().equals("")){
                    Toast.makeText(dangNhap.this, "Không được dể trống thông tin đăng nhâp", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(ettendangnhap.getText().toString().equals("t") || etmatkhau.getText().toString().equals("1")){
                        Toast.makeText(dangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                    else
                        Toast.makeText(dangNhap.this, "Tên đăng nhập hoặc mật khẩu bị sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //su kien  link dang ky
        linkdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dangNhap.this,dangKy.class);
                startActivity(i);
            }
        });


    }
}