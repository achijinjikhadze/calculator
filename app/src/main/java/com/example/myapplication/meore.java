package com.example.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class meore extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meore);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        EditText editText = findViewById(R.id.edittxt);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editText.setShowSoftInputOnFocus(false);
        }
        editText.setCursorVisible(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);


        //c
        Button btnc = findViewById(R.id.btc);

        //[x],%,/,x,-,+,.,=
        Button btnx = findViewById(R.id.btx);
        Button btnp = findViewById(R.id.btp);
        Button btngy = findViewById(R.id.btgy);
        Button btngm = findViewById(R.id.btgm);
        Button btnms = findViewById(R.id.btms);
        Button btnpl = findViewById(R.id.btpl);
        Button btnw = findViewById(R.id.btw);
        Button btntl = findViewById(R.id.bttl);

        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
        Button bt5 = findViewById(R.id.bt5);
        Button bt6 = findViewById(R.id.bt6);
        Button bt7 = findViewById(R.id.bt7);
        Button bt8 = findViewById(R.id.bt8);
        Button bt9 = findViewById(R.id.bt9);
        Button bt0 = findViewById(R.id.bt0);

        //cifrebi
        Button[] buttons = {bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0};
        for (Button button : buttons) {
            button.setOnClickListener(v -> {
               // editText.append(button.getText());
                int curspos = editText.getSelectionStart();
                editText.getText().insert(curspos, button.getText());
            });
        }

       //gasuftaveba
        btnc.setOnClickListener(v -> {
            editText.setText("");
        });

        //washla
        btnx.setOnClickListener(v -> {
            int curspos = editText.getSelectionStart();
            int textsz = editText.getText().length();

            if (curspos > 0 && textsz > 0) {
                editText.getText().delete(curspos - 1, curspos);
            }
        });

        //%procenti
        btnp.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int textsz = s.length();
            if (textsz > 0){
                char lastc = s.charAt(textsz-1);
                if (lastc>='0' && lastc<='9'){
                    try{
                        double num=Double.parseDouble(s);
                        num=num/100;
                        editText.setText(String.valueOf(num));
                        editText.setSelection(editText.getText().length());
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        // gayofa
        btngy.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int curspos = editText.getSelectionStart();
            int textsz = s.length();
            if (textsz > 0){
                char lastc = s.charAt(textsz-1);
                if (lastc>='0' && lastc<='9'){
                    try {
                        Editable editable = editText.getText();
                        editable.insert(curspos, "/");
                        editable.setSpan(
                                new ForegroundColorSpan(Color.RED),
                                curspos,
                                curspos + 1,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // gamravleba
        btngm.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int curspos = editText.getSelectionStart();
            int textsz = s.length();
            if (textsz > 0){
                char lastc = s.charAt(textsz-1);
                if (lastc>='0' && lastc<='9'){
                    try {
                        Editable editable = editText.getText();
                        editable.insert(curspos, "X");
                        editable.setSpan(
                                new ForegroundColorSpan(Color.RED),
                                curspos,
                                curspos + 1,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        // gamokleba
        btnms.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int curspos = editText.getSelectionStart();
            int textsz = s.length();
            if (textsz > 0){
                char lastc = s.charAt(textsz-1);
                if (lastc>='0' && lastc<='9'){
                    try {
                        Editable editable = editText.getText();
                        editable.insert(curspos, "-");
                        editable.setSpan(
                                new ForegroundColorSpan(Color.RED),
                                curspos,
                                curspos + 1,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnpl.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int curspos = editText.getSelectionStart();

            int textsz = s.length();
            if (textsz > 0) {
                char lastc = s.charAt(textsz - 1);
                if (lastc >= '0' && lastc <= '9') {
                    try {
                         Editable editable = editText.getText();
                        editable.insert(curspos, "+");
                        editable.setSpan(
                                new ForegroundColorSpan(Color.RED),
                                curspos,
                                curspos + 1,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // wertili
        btnw.setOnClickListener(v -> {
            String s = editText.getText().toString();
            int curspos = editText.getSelectionStart();


            int lastop = Math.max(
                    Math.max(s.lastIndexOf('+',curspos-1), s.lastIndexOf('-',curspos-1)),
                    Math.max(s.lastIndexOf('X',curspos-1), s.lastIndexOf('/',curspos-1))
            );

            String num = s.substring(lastop+1, curspos);
            if (s.length() > 0) {
                char lastc = s.charAt(curspos > 0 ? curspos - 1 : 0);

                 if (!num.contains(".") && ((lastc >= '0' && lastc <= '9') /*|| lastc == '+' || lastc == '-' || lastc == 'X' || lastc == '/'*/)) {
                    editText.getText().insert(curspos, btnw.getText());
                }
            } else {

                editText.getText().insert(curspos, "0.");
            }
        });


        //=udris
        btntl.setOnClickListener(v -> {
            String expr = editText.getText().toString();


        });




    }


}
