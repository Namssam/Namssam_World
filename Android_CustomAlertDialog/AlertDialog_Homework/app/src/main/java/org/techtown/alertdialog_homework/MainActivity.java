package org.techtown.alertdialog_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    CustomAlertDialog csAlertDialog;

    String CHECK_TYPE = "Check";
    String EDIT_TYPE = "Edit";
    String ALERT_TYPE = "Alert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_checkType = findViewById(R.id.btn_checkType);
        btn_checkType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(CHECK_TYPE);
            }
        });

        Button btn_editType = findViewById(R.id.btn_editType);
        btn_editType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(EDIT_TYPE);
            }
        });

        Button btn_alertType = findViewById(R.id.btn_alertType);
        btn_alertType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(ALERT_TYPE);
            }
        });
    }

    public void showCustomDialog(String type) {
        if (type == "Check") {

            csAlertDialog = new CustomAlertDialog(this);
            csAlertDialog.setType(CHECK_TYPE);
            csAlertDialog.show();

        } else if (type == "Edit") {

            csAlertDialog = new CustomAlertDialog(this);
            csAlertDialog.setType(EDIT_TYPE);
            csAlertDialog.show();

        } else {

            csAlertDialog = new CustomAlertDialog(this);
            csAlertDialog.setType(ALERT_TYPE);
            csAlertDialog.show();

        }
    }
}