package org.techtown.customalertdialog_homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.techtown.customalertdialog_homework_2.CustomAlertDialog.CustomAlertDialog;

public class MainActivity extends AppCompatActivity {

    CustomAlertDialog customAlertDialog;

    String CHECK_TYPE = "Check";
    String EDIT_TYPE = "Edit";
    String ALERT_TYPE = "Alert";

    /// 완성 후 다시 새로 짜야 함 예전 코드임 ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(CHECK_TYPE);
            }
        });

        Button btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(EDIT_TYPE);
            }
        });

        Button btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(ALERT_TYPE);
            }
        });
    }

    public void showCustomDialog(String type) {
        if (type == "Check") {

            customAlertDialog = new CustomAlertDialog(this);
            customAlertDialog.setType(CHECK_TYPE);

        } else if (type == "Edit") {

            customAlertDialog = new CustomAlertDialog(this);
            customAlertDialog.setType(EDIT_TYPE);

        } else {

            customAlertDialog = new CustomAlertDialog(this);
            customAlertDialog.setType(ALERT_TYPE);

        }
    }
}