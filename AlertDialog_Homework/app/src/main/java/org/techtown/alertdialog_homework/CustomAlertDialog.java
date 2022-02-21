package org.techtown.alertdialog_homework;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAlertDialog extends AlertDialog {

    protected CustomAlertDialog(@NonNull Context context) {
        super(context);

        init(context);
    }

    protected CustomAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

        init(context);
    }

    public void setType(String type) {

        if (type == "Check") {

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle("Check Type입니다.")
                    .setMessage("Check Type입니다.")
                    .setPositiveButton("확인", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Check", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("취소", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "취소", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create();
                    builder.show();


        } else if (type == "Edit") {

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            EditText editText = new EditText(getContext());

            builder.setTitle("Edit Type입니다.")
                    .setMessage("Edit Type입니다.")
                    .setView(editText)
                    .setPositiveButton("확인", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create();
                    builder.show();

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle("Alert Type입니다.")
                    .setMessage("Alert Type입니다.")
                    .setPositiveButton("확인", new OnClickListener() {
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
