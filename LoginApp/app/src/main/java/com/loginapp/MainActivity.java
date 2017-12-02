package com.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txtView;
    private SharedPreferences pref;
    private void init(){
        txtView=findViewById(R.id.txtView);
        pref=getSharedPreferences("LoginRecord",MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String name=pref.getString("UserName","").toString();
        txtView.setText("Welcome to App  !! \n"+name);
        MainActivity.this.setTitle(name);
    }

    public void onSignOut(View view) {
        SharedPreferences.Editor prefEditor=pref.edit();
        prefEditor.putString("UserName","");
        prefEditor.putString("Password","");
        prefEditor.commit();

        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
