package com.s4.buxomapp;

import static com.tuya.sdk.security.SecuredStore.mContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.sdk.api.IResultCallback;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class login extends AppCompatActivity {

 Button Login;
 EditText email,Userpassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login=(Button) findViewById(R.id.Login);
        email = (EditText)findViewById(R.id.Email);
        Userpassword = (EditText)findViewById(R.id.Password);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailaddress = email.getText().toString();
                String pass = Userpassword.getText().toString();
               // Intent go = new Intent(login.this,MainActivity.class);
               // startActivity(go);
                //finish();
               user(emailaddress,pass);
             ///   userwithphone();

            }
        });

















    }
 //  public static void api(String age){
   //     OkHttpClient client = new OkHttpClient().newBuilder()
              //  .build();
     //   MediaType mediaType = MediaType.parse("application/json");
      //  RequestBody body = RequestBody.create(mediaType, "{\r\n    \"id\": 2,\r\n    \"title\": \"SomeTitle\",\r\n    \"content\": \"SomeContent\",\r\n    \"createdAt\": \"2020-07-15\",\r\n    \"updatedAt\": \"2020-07-15\"\r\n}");
     //   Request request = new Request.Builder()
             //   .url("https://nodetesting3.herokuapp.com/api/notes")
             //   .method("POST", body)
             ///   .addHeader("Content-Type", "application/json")
             //   .build();
       // try {
         //   Response response = client.newCall(request).execute();
      //  } catch (IOException e) {
       //     e.printStackTrace();
     //   }
   /// }


    public void user(String mail,String password){
// Returns a verification code to an email address.
        TuyaHomeSdk.getUserInstance().sendVerifyCodeWithUserName(mail, "", "90", 1, new IResultCallback() {
            @Override
            public void onError(String code, String error) {
                Toast.makeText(mContext, "code: " + code + "error:" + error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess() {
               //// Toast.makeText(mContext, "Verification code returned successfully.", Toast.LENGTH_SHORT).show();
                Intent gotovrifay = new Intent(login.this,vrifaypage.class);
                gotovrifay.putExtra("sendpass",password);
                gotovrifay.putExtra("sendemail",mail);
                startActivity(gotovrifay);
                finish();
            }


        });

    }

}