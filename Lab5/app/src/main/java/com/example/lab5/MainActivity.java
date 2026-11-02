package com.example.lab5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                 // 初始化 Activity
        setContentView(R.layout.activity_main);             // 連接 activity_main.xml 畫面

        Button btn = findViewById(R.id.button);             // 連接 Button 元件
        btn.setOnClickListener(new View.OnClickListener() { // Button 點擊事件
            @Override
            public void onClick(View view) {
                // 建立 AlertDialog 物件
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("請選擇功能");
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件");

                // 取消：使用 makeText 顯示訊息
                dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "dialog關閉", Toast.LENGTH_SHORT).show();
                    }
                });

                // 自定義Toast：執行副程式來顯示客製化 Toast
                dialog.setNegativeButton("自定義Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast();
                    }
                });

                // 顯示list：執行副程式來顯示含列表的對話框
                dialog.setPositiveButton("顯示list", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showListDialog();
                    }
                });

                dialog.show();
            }
        });
    }

    // 顯示客製化 Toast
    private void showToast() {
        Toast toast = new Toast(MainActivity.this);         // Step1：初始化 Toast
        toast.setGravity(Gravity.TOP, 0, 50);               // Step2：Toast 在畫面中顯示位置
        toast.setDuration(Toast.LENGTH_SHORT);              // Step3：Toast 在畫面中顯示的持續時間
        LayoutInflater inflater = getLayoutInflater();      // Step4：取得自定義的畫面
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_root));
        toast.setView(layout);                              // Step5：放入自定義的畫面(custom_toast.xml)
        toast.show();                                       // Step6：顯示畫面
    }

    // 顯示含列表的對話框
    private void showListDialog() {
        // 建立要顯示在列表上的字串
        final String[] list = {"message1", "message2", "message3", "message4", "message5"};
        // 建立 AlertDialog 物件
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用List呈現");
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 依照被點擊的項目用 Toast 顯示字串
                Toast.makeText(MainActivity.this, "您選擇的是" + list[i], Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }
}
