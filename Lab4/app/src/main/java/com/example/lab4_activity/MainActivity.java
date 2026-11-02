package com.example.lab4_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_meal;
    private Button btn_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal);          // 連接 TextView 元件
        btn_select = findViewById(R.id.btn_choice);     // 連接 Button 元件
        btn_select.setOnClickListener(view -> {         // Button 點擊事件
            // 透過 Intent 切換至 Main2Activity
            mStartForResult.launch(
                    new Intent(this, Main2Activity.class)
            );
        });
    }

    // 建立 ActivityResultLauncher 作為發送及接收資料的函式
    private final ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                // 確認執行的結果
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    // 如果 intent 不為 null，且 intent 的 extras 不為 null
                    if (intent != null && intent.getExtras() != null) {
                        Bundle b = intent.getExtras();
                        // 取得飲料、甜度、冰塊資料
                        String str1 = b.getString("drink");
                        String str2 = b.getString("sugar");
                        String str3 = b.getString("ice");
                        // 透過 TextView.setText() 顯示資料
                        tv_meal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s", str1, str2, str3));
                    }
                }
            });
}
