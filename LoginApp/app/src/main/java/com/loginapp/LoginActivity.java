package com.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText editKullaniciAdi,editSifre;
    private SharedPreferences pref;
    private String username,password;
    private void init(){
        editKullaniciAdi=findViewById(R.id.editKullaniciAdi);
        editSifre=findViewById(R.id.editSifre);
        pref=getSharedPreferences("LoginRecord",MODE_PRIVATE);
    }

    private void MainActivityLogin(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void login_control(){
        username=pref.getString("UserName","");
        password=pref.getString("Password","");

        if (!username.equals("") && !password.equals("")){
            MainActivityLogin();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        login_control();
    }

    public void onLogin(View view) {

        username=editKullaniciAdi.getText().toString();
        password=editSifre.getText().toString();

        if (username.equals("")||password.equals("")||password.length()<8)
            Toast.makeText(this,"Alanları Kontrol Ediniz",Toast.LENGTH_SHORT).show();
        else{

            SharedPreferences.Editor prefEditor=pref.edit();
            prefEditor.putString("UserName",editKullaniciAdi.getText().toString());
            prefEditor.putString("Password",editSifre.getText().toString());
            prefEditor.commit();

            MainActivityLogin();
        }

    }
}
