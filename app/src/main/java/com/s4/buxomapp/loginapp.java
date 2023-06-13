package com.s4.buxomapp;

import static com.tuya.sdk.security.SecuredStore.mContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.home.sdk.TuyaHomeSdk;

public class loginapp extends AppCompatActivity {
    Button Login;
    EditText email,Userpassword ;
    TextView gori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginapp);
        Login=(Button) findViewById(R.id.Loginapp);
        email = (EditText)findViewById(R.id.Emailapp);
        Userpassword = (EditText)findViewById(R.id.Passwordapp);
        gori = (TextView)findViewById(R.id.gori);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailaddress = email.getText().toString();
                String pass = Userpassword.getText().toString();
                logintoapp(emailaddress,pass);
            }
        });
        gori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gorig = new Intent(loginapp.this,login.class);
                startActivity(gorig);
                finish();
            }
        });
    }

    public void logintoapp(String user,String pass){
        // Enables login to the app with the email address and password.
        TuyaHomeSdk.getUserInstance().loginWithEmail("90", user, pass, new ILoginCallback() {
            @Override
            public void onSuccess(User user) {
                Toast.makeText(mContext, "Logged in with Username: ",Toast.LENGTH_LONG).show();
                Intent gomain = new Intent(loginapp.this,MainActivity.class);
                startActivity(gomain);
                finish();
            }

            @Override
            public void onError(String code, String error) {
                Toast.makeText(mContext, "code: " + code + "error:" + error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}