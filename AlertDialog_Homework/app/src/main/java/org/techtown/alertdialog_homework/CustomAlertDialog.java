package org.techtown.alertdialog_homework;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAlertDialog extends AlertDialog.Builder {

    public CustomAlertDialog(Context context) {
        super(context);

        init(context);
    }

    public void setType(String type) {

        if (type == "Check") {

            CustomAlertDialog builder = new CustomAlertDialog(getContext());

            builder.setTitle("Check Type입니다.")
                    .setMessage("Check Type입니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Check", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "취소", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.create();
            builder.show();


        } else if (type == "Edit") {

            CustomAlertDialog builder = new CustomAlertDialog(getContext());

            EditText editText = new EditText(getContext());

            builder.setTitle("Edit Type입니다.")
                    .setView(editText)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.create();
            builder.show();

        } else {
            CustomAlertDialog builder = new CustomAlertDialog(getContext());

            builder.setTitle("Alert Type입니다.")
                    .setMessage("Alert Type입니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Alert", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.create();
            builder.show();
        }
    }

    private void init(Context context) {

    }
}
