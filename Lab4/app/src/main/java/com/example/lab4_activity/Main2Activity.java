package com.example.lab4_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    private EditText set_drink;
    private RadioGroup rg1, rg2;
    private Button btn_send;

    private String sugar = "無糖";
    private String ice_opt = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 用 RadioGroup 監聽 RadioButton 的按下事件，並把字串改成甜度資訊
        rg1 = findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton1) {
                sugar = "無糖";
            } else if (i == R.id.radioButton2) {
                sugar = "少糖";
            } else if (i == R.id.radioButton3) {
                sugar = "半糖";
            } else if (i == R.id.radioButton4) {
                sugar = "全糖";
            }
        });

        // 用 RadioGroup 監聽 RadioButton 的按下事件，並把字串改成冰塊資訊
        rg2 = findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton5) {
                ice_opt = "去冰";
            } else if (i == R.id.radioButton6) {
                ice_opt = "微冰";
            } else if (i == R.id.radioButton7) {
                ice_opt = "少冰";
            } else if (i == R.id.radioButton8) {
                ice_opt = "正常冰";
            }
        });

        // 用 Button 監聽按下事件，飲料、甜度、冰塊的資訊回傳到前一頁面
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            // 把飲料、甜度與冰塊資訊放入 Bundle
            b.putString("drink", drink);
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);
            i.putExtras(b);
            // 用 RESULT_OK 標記執行狀態並記錄 Intent
            setResult(Activity.RESULT_OK, i);
            finish();
        });
    }
}
