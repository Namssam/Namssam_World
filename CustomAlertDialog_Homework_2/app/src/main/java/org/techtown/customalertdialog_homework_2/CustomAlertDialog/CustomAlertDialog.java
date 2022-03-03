package org.techtown.customalertdialog_homework_2.CustomAlertDialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

import org.techtown.customalertdialog_homework_2.R;


public class CustomAlertDialog extends AlertDialog {

    static Context context;
    static int id;
    static TextView tv_title;
    static Button btn_ok;
    static Button btn_cancel;
    static CustomAlertDialog cs_dialog;


    public CustomAlertDialog(@NonNull Context context) {
        super(context);
    }

    static class CustomBuilder {

        String title;

        CustomBuilder(Context context1, @LayoutRes int id1) {
            context = context1;
            id = id1;
        }
        // CustomAlertDialog의 setTitle 설정
        public CustomAlertDialog setTitle(@StringRes int id) {
            tv_title = cs_dialog.findViewById(R.id.tv_title);
            tv_title.setText(id);

            this.title = context.getString(id);

            return cs_dialog;
        }
        // setTitle 기능 설정
        public CustomBuilder setTitle(String str) {
            tv_title = cs_dialog.findViewById(R.id.tv_title);
            tv_title.setText(str);

            return this;
        }
        // CustomAlertDialog의 setPositiveBurron 설정... 어떤 요소를 넣어야 할까
        public CustomBuilder setPositiveButton(@StringRes int id, View view, View.OnClickListener listener) {
            btn_ok = cs_dialog.findViewById(R.id.btn_ok);

            return this;
        }
        // create 설정
        public CustomBuilder create() {
            cs_dialog = new CustomAlertDialog(context);
            cs_dialog.setContentView(id);

            return this;
        }
        // show 설정
        public CustomBuilder show() {
            cs_dialog.show();
            return this;
        }

    }


}
