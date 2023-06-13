package com.s4.buxomapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.s4.buxomapp.databinding.ActivityMainBinding;

import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    private static final int PICKFILE_RESULT_CODE = 0;
    private static final int RESULT_LOAD_IMAGE = 0;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        ImageView add = binding.addplc;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addroom = new Intent(MainActivity.this,addroom.class);
                startActivity(addroom);
                finish();
            }
        });
        TextView location = binding.setlocation;
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent golocations = new Intent(MainActivity.this,locations.class);
                startActivity(golocations);
                finish();
            }
        });


        Button addcatgory = binding.addcatgory;
        addcatgory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gocat = new Intent(MainActivity.this,catgorys.class);
                startActivity(gocat);
                finish();

                
            }
        });

        ImageView bedroom = binding.bedroom;
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gocat = new Intent(MainActivity.this,rooms.class);
                startActivity(gocat);
                finish();
            }
        });
///////
      //  ConstraintLayout back= binding.container;

     //   ImageView bak = binding.backi;

      //  back.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
             //   back.set
       //     }
      //  });


      //  ImageView changebach = binding.backi;

      ///  changebach.setOnClickListener(new View.OnClickListener() {
         ///   @Override
        //    public void onClick(View view) {
                //try {
              ///      change_backgrand();
             ///   }catch (Exception e){
               ///     Toast.makeText(MainActivity.this, "Fuke you", Toast.LENGTH_SHORT).show();
            //    }

          ///  }
       /// });




    }


    //public void change_backgrand(){
    //    Intent intent = new Intent();
   //     intent.setType("*/*");
    //    intent.setAction(Intent.ACTION_GET_CONTENT);
    //    startActivityForResult(Intent.createChooser(intent,"Select Video "), 33);
       /// File file = new File(directory, "back" + ".png");
      //  imageView.setImageDrawable(Drawable.createFromPath(file.toString()));


   // }
   /// public void onActivityResult(int requestCode, int resultCode,
                              //   Intent data) {
      // // // TODO Auto-generated method stub
     ///   super.onActivityResult(requestCode, resultCode, data);


       /// if (requestCode == 33) {
        ///    Uri currFileURI = data.getData();
          ///  String path= currFileURI.getPath();

        //    ImageView back = binding.back;
         ///   File imgFile = new  File(path);

        ///    if(imgFile.exists()) {
          ///      Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
          ///      back.setImageBitmap(myBitmap);
        ///    }



         ///   Toast.makeText(this, ""+path, Toast.LENGTH_SHORT).show();

   // public void onActivityResult(int requestCode, int resultCode, Intent data) {
     //   super.onActivityResult(requestCode, resultCode, data);

      //  if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
         //   Uri selectedImageUri = data.getData();
          //  String[] projection = {MediaStore.Images.Media.DATA};
          //  @SuppressWarnings("deprecation")
         ///   Cursor cursor = getContentResolver().query(selectedImageUri, projection, null, null, null);
        ///    cursor.moveToFirst();

          //  int column_index = cursor.getColumnIndex(projection[0]);
         ///   String imagePath = cursor.getString(column_index);
         ///   cursor.close();

            ///   ImageView back = binding.back;
             /// File imgFile = new  File(path);

          /// File imageFile = new File(imagePath);
         ///   if (imageFile.exists()) {
             ///   Bitmap imageBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            ///  back.setImageBitmap(imageBitmap);
        ///    }

       /// } else {
       ///     Toast.makeText(this, "You have not selected and image", Toast.LENGTH_SHORT).show();
      /////  }
    //}
    }