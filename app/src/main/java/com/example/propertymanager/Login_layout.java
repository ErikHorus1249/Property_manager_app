package com.example.propertymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login_layout extends AppCompatActivity {

    ImageButton login_button, login_eye;
    EditText login_username, login_password;
    CheckBox login_checkbox;
    SharedPreferences sharedPreferences;
    Boolean hide_pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

//        sharedPreferences
        sharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE);

        login_button = findViewById(R.id.login_button);
        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        login_checkbox = findViewById(R.id.login_checkbox);
        login_eye = findViewById(R.id.login_eye);

//        lay thong tin dang nhap
        login_username.setText(sharedPreferences.getString("username", ""));
        login_password.setText(sharedPreferences.getString("password", ""));
        login_checkbox.setChecked(sharedPreferences.getBoolean("checkboxstt", false));

        login_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_password.setHint("");
                String password = login_password.getText().toString().trim();
                if(!hide_pass && !password.equals("")){
                    login_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    login_eye.setImageResource(R.drawable.login_hide);
                    hide_pass = true;
                }else {
                    login_eye.setImageResource(R.drawable.login_apperance);
                    login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    hide_pass = false;
                }

            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = login_username.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if(username.equals("admin") && password.equals("admin")){
//                    lưu thong tin cua nguoi dung
                    if(login_checkbox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checkboxstt", true);
                        editor.commit();
                    }
                    Toast.makeText(getBaseContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);

                }else{
                    login_username.setText("");
                    Toast.makeText(getBaseContext(), "Sai thông tin đăng nhập, vui lòng thử lại!" + username + " " + password, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

//    private void togglePassVisability() {
//        if (hide_pass) {
//            String pass = login_password.getText().toString();
//            login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
//            firstEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            firstEditText.setText(pass);
//            firstEditText.setSelection(pass.length());
//        } else {
//            String pass = firstEditText.getText().toString();
//            firstEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//            firstEditText.setInputType(InputType.TYPE_CLASS_TEXT);
//            firstEditText.setText(pass);
//            firstEditText.setSelection(pass.length());
//        }
//        isPasswordVisible= !isPasswordVisible;
//    }

}