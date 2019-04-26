package com.yoneya1014.datepickerfragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateView = findViewById(R.id.dateView);
        Button selectDate = findViewById(R.id.selectDate);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickFragment fragment = new DatePickFragment();
                fragment.show(getSupportFragmentManager(), null);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //monthは仕様上、「選択した月 - 1」の値になるので使用するときはmonthの部分に+1をする
        String text = year + "/" + (month + 1) + "/" + day;
        dateView.setText(text);
    }
}
