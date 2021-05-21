package com.example.pizzariadommortandello.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pizzariadommortandello.R;

public class MainActivity extends AppCompatActivity {

    Button btn_newPizza;
    Button btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_newPizza = (Button) findViewById(R.id.btn_newPizza);
        btn_menu = (Button) findViewById(R.id.btn_menu);
    }

    public void onClick_btn_newPizza (View v) {
        Intent it_trocaTela = new Intent(MainActivity.this, NewPizza.class);
        startActivity(it_trocaTela);
    };

    public void onClick_btn_menu (View v) {
        Intent it_trocaTela = new Intent(MainActivity.this, ListPizza.class);
        startActivity(it_trocaTela);
    };

}