package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList= new ArrayList();

        spinnerArrayList.add("Пистолеты");
        spinnerArrayList.add("Пистолеты-пулемёты");
        spinnerArrayList.add("Автоматы");
        spinnerArrayList.add("Винтовки");
        spinnerArrayList.add("Карабины");
        spinnerArrayList.add("Пулемёты");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("Пистолеты",500.0);
        goodsMap.put("Пистолеты-пулемёты",1000.0);
        goodsMap.put("Автоматы",1500.0);
        goodsMap.put("Винтовки",2000.0);
        goodsMap.put("Карабины",2500.0);
        goodsMap.put("Пулемёты",3000.0);
    }

    public void increaseQuantity(View view)
    {
        quantity=quantity+1;
        TextView quantityTextView = findViewById (R.id.QuantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.Price_Text);
        priceTextView.setText(""+ quantity * price);

    }
    public void decreaseQuantity(View view)
    {   quantity=quantity - 1;
        if (quantity<0) quantity = 0;
        TextView quantityTextView = findViewById (R.id.QuantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.Price_Text);
        priceTextView.setText(""+ quantity * price);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.Price_Text);
        priceTextView.setText("" + quantity * price);
        ImageView goodsImageView = findViewById(R.id.goodsImageView);
        if (goodsName.equals("Автоматы")) {
            goodsImageView.setImageResource(R.drawable.gun_1);
        } else if (goodsName.equals("Винтовки")) {
            goodsImageView.setImageResource(R.drawable.sr);
        } else if (goodsName.equals("Карабины")) {
            goodsImageView.setImageResource(R.drawable.kar);
        } else if (goodsName.equals("Пулеметы")) {
            goodsImageView.setImageResource(R.drawable.pul);
        } else if (goodsName.equals("Пистолеты-пулемёты")) {
            goodsImageView.setImageResource(R.drawable.pp);
        } else if (goodsName.equals("Пистолеты")) {
            goodsImageView.setImageResource(R.drawable.pist);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}