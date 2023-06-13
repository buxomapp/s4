package com.s4.buxomapp;

import static com.tuya.sdk.security.SecuredStore.mContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuya.smart.android.user.api.IRegisterCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.home.sdk.TuyaHomeSdk;

public class vrifaypage extends AppCompatActivity {

    Button vrbutton;
    EditText code ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrifaypage);

        vrbutton=(Button)findViewById(R.id.vrbutton);
        code =(EditText)findViewById(R.id.code);




        //// vrigay

        vrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getpass = getIntent();
                Intent getmail = getIntent();
                String UserPassword = getpass.getStringExtra("sendpass");
                String Usermailaddress = getmail.getStringExtra("sendemail");

                String Codev = code.getText().toString();

               if (Codev.isEmpty()){
                  Toast.makeText(vrifaypage.this,"You Must put a code !",Toast.LENGTH_LONG).show();

              }else {
                   try {
                     reg(Usermailaddress,UserPassword,Codev);
                   }catch (Exception e){
                        Toast.makeText(vrifaypage.this,"Somthing was wrong",Toast.LENGTH_LONG).show();
                 }

              }

            }
        });
    }


    public void reg(String mail , String password , String code){
        TuyaHomeSdk.getUserInstance().registerAccountWithEmail("90", mail,password,code, new IRegisterCallback() {

            @Override
            public void onSuccess(User user) {
                Toast.makeText(mContext, "Registered successfully.", Toast.LENGTH_SHORT).show();
                Intent go = new Intent(vrifaypage.this,MainActivity.class);
                startActivity(go);
                finish();
            }

            @Override
            public void onError(String code, String error) {
               Toast.makeText(mContext, "code: " + code + "error:" + error, Toast.LENGTH_SHORT).show();
                //Intent go = new Intent(vrifaypage.this,MainActivity.class);
                //startActivity(go);
                ///finish();
            }
        });
    }
}