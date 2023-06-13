package com.s4.buxomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thingclips.smart.home.sdk.ThingHomeSdk;
import com.thingclips.smart.home.sdk.api.IThingGwSearcher;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.api.IGwSearchListener;
import com.tuya.smart.home.sdk.api.ITuyaGwSearcher;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;

import java.util.List;
import java.util.Map;

public class devoislist extends AppCompatActivity {
    ImageView backhome;
    TextView tt ;
    EditText getgetwayname;
    ImageView addget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devoislist);

        backhome=(ImageView) findViewById(R.id.backhome);
        tt=(TextView) findViewById(R.id.tt);
        addget = (ImageView)findViewById(R.id.openzig);
        getgetwayname =(EditText)findViewById(R.id.dename);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(devoislist.this,MainActivity.class);
                startActivity(backhome);
                finish();
            }
        });
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(devoislist.this,lighpage.class);
                startActivity(tt);
                finish();
            }
        });

        addget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ///  String getname = getgetwayname.getText().toString();
                getzegbi();
              //  testzegbi(getname);
               /// test2(getname);
             //// gettoken();
              ///  getsubdoggatway();
            ///   getde();
           ///   searchGatewayDevice();
               /// getde();
              /// homelist();
               // get();
              ///  connect();

            }
        });
    }


    public void getzegbi(){
        IThingGwSearcher mThingGwSearcher = ThingHomeSdk.getActivatorInstance().newThingGwActivator().newSearcher();
        mThingGwSearcher.registerGwSearchListener((com.thingclips.smart.home.sdk.api.IGwSearchListener) hgwBean -> {


            Toast.makeText(this, ""+hgwBean, Toast.LENGTH_SHORT).show();


        });

    }

    public void testzegbi(String name){
        TuyaHomeSdk.newGatewayInstance(name).getSubDevList(new ITuyaDataCallback<List<DeviceBean>>() {
            @Override
            public void onSuccess(List<DeviceBean> list) {
                Toast.makeText(devoislist.this, "ok conect"+list, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorCode, String errorMessage) {

                Toast.makeText(devoislist.this, ""+errorMessage, Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void test2(String Name){
        TuyaGwSubDevActivatorBuilder builder = new TuyaGwSubDevActivatorBuilder()
                .setDevId(Name)
                .setTimeOut(60)
                .setListener(new ITuyaSmartActivatorListener() {

                                 @Override
                                 public void onError(String errorCode, String errorMsg) {
                                     Toast.makeText(devoislist.this, ""+errorMsg, Toast.LENGTH_SHORT).show();

                                 }

                                 @Override
                                 public void onActiveSuccess(DeviceBean devResp) {
                                     Toast.makeText(devoislist.this, ""+devResp, Toast.LENGTH_SHORT).show();
                                 }

                                 @Override
                                 public void onStep(String step, Object data) {

                                 }
                             }
                );
        ITuyaActivator mTuyaGWSubActivator = TuyaHomeSdk.getActivatorInstance().newGwSubDevActivator(builder);
// Starts pairing.
        mTuyaGWSubActivator.start();



    }
    public void connect(String to){

        ActivatorBuilder builder = new ActivatorBuilder()
                .setSsid("SUPERONLINE_WiFi_66A8")
                .setContext(devoislist.this)
                .setPassword("3Y4VWLJFPTUE")
                .setActivatorModel(ActivatorModelEnum.TY_EZ)
                .setTimeOut(1000)
                .setToken(to)
                .setListener(new ITuyaSmartActivatorListener() {

                                 @Override
                                 public void onError(String errorCode, String errorMsg) {
                                     Toast.makeText(devoislist.this, " for err"+errorMsg, Toast.LENGTH_SHORT).show();

                                 }

                                 @Override
                                 public void onActiveSuccess(DeviceBean devResp) {

                                     Map<String, Object> dps = TuyaHomeSdk.getDataInstance().getDps(devResp.getDevId());
                                     Toast.makeText(devoislist.this, "oookkkkk"+dps, Toast.LENGTH_SHORT).show();

                                     get();
                                 }

                                 @Override
                                 public void onStep(String step, Object data) {

                                 }
                             }
                );
        ITuyaActivator mTuyaActivator = TuyaHomeSdk.getActivatorInstance().newMultiActivator(builder);
        mTuyaActivator.start();

    }

    public void withaccespoint(String to){
        ActivatorBuilder builder = new ActivatorBuilder()
                .setContext(devoislist.this)
                .setSsid("Ali&sa")
                .setPassword("Pizza2259")
                .setActivatorModel(ActivatorModelEnum.TY_EZ)
                .setTimeOut(120)
                .setToken(to)
                .setListener(new ITuyaSmartActivatorListener() {

                                 @Override
                                 public void onError(String errorCode, String errorMsg) {
                                 }

                                 @Override
                                 public void onActiveSuccess(DeviceBean devResp) {
                                     ITuyaDevice mDevice = TuyaHomeSdk.newDeviceInstance(devResp.getDevId());

                                     Toast.makeText(devoislist.this, "oookkkkk"+mDevice, Toast.LENGTH_SHORT).show();
                                    /// searchGatewayDevice();
                                     getde();

                                 }

                                 @Override
                                 public void onStep(String step, Object data) {

                                 }
                             }
                );
        ITuyaActivator mTuyaActivator = TuyaHomeSdk.getActivatorInstance().newMultiActivator(builder);
// Starts pairing.
        mTuyaActivator.start();
    }

    public void gettoken(){
        TuyaHomeSdk.getActivatorInstance().getActivatorToken(60529316,
                new ITuyaActivatorGetToken() {
                    @Override
                    public void onSuccess(String token) {
                        Toast.makeText(devoislist.this, "ok"+token, Toast.LENGTH_SHORT).show();
                        connect(token);





                    }

                    @Override
                    public void onFailure(String s, String s1) {
                        Toast.makeText(devoislist.this, "oops!", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    public void getde(){
        TuyaHomeSdk.newHomeInstance(60529316).getHomeDetail(new ITuyaHomeResultCallback() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                List<DeviceBean> deviceList = homeBean.getDeviceList();

                Toast.makeText(devoislist.this, "ookkkk"+deviceList, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(String errorCode, String errorMsg) {
                Toast.makeText(devoislist.this, "nooo", Toast.LENGTH_SHORT).show();
            }
        });
    }



   // public void getdevois(){
    //    TuyaHomeSdk.newHomeInstance(60529316).getHomeDetail(new ITuyaHomeResultCallback() {
      //      @Override
        //    public void onSuccess(HomeBean bean) {
             //   List<DeviceBean> deviceList = homeBean.getDeviceList();
                // Get `deviceBean`.
           // }
       //     @Override
        //    public void onError(String errorCode, String errorMsg) {
                // do something
          //  }
       // });

  //  }
  // Search ZigBee Gateway Device
  private void searchGatewayDevice() {

      ITuyaGwSearcher iTuyaGwSearcher = TuyaHomeSdk.getActivatorInstance().newTuyaGwActivator().newSearcher();
      iTuyaGwSearcher.registerGwSearchListener(new IGwSearchListener() {
          @Override
          public void onDevFind(HgwBean gw) {
              getNetworkConfigToken(gw);
          }
      });
  }

    // Get Network Configuration Token
    private void getNetworkConfigToken(HgwBean gw) {
        long homeId = 60529316;

        TuyaHomeSdk.getActivatorInstance().getActivatorToken(
                homeId, new ITuyaActivatorGetToken() {
                    @Override
                    public void onSuccess(String token) {

                        startNetworkConfig(token, gw);
                        Toast.makeText(devoislist.this, "sechch is ok!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String errorCode, String errorMsg) {

                    }
                }
        );
    }

    // Start network configuration -- ZigBee Gateway
    private void startNetworkConfig(String token, HgwBean hgwBean) {
        ITuyaActivator activator = TuyaHomeSdk.getActivatorInstance().newGwActivator(
                new TuyaGwActivatorBuilder()
                        .setContext(this)
                        .setTimeOut(100)
                        .setToken(token)
                        .setHgwBean(hgwBean)
                        .setListener(new ITuyaSmartActivatorListener() {
                            @Override
                            public void onError(String errorCode, String errorMsg) {

                                Toast.makeText(
                                        devoislist.this,
                                        "Activate Error" + errorMsg,
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onActiveSuccess(DeviceBean devResp) {

                                Toast.makeText(
                                        devoislist.this,
                                        "Activate success",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            }

                            @Override
                            public void onStep(String step, Object data) {

                            }
                        })
        );
        activator.start();
    }
    public void dlist(){
        TuyaHomeSdk.newHomeInstance(60529316).getHomeDetail(new ITuyaHomeResultCallback() {
            @Override
            public void onSuccess(HomeBean bean) {

            ///    List<DeviceBean> deviceList = homeBean.getDeviceList();

              ///  Toast.makeText(devoislist.this, ""+deviceList, Toast.LENGTH_SHORT).show();
                // Get `deviceBean`.
            }
            @Override
            public void onError(String errorCode, String errorMsg) {
                // do something
            }
        });


    }

    //// homelist
    public void homelist(){
        TuyaHomeSdk.getHomeManagerInstance().queryHomeList(new ITuyaGetHomeListCallback() {
            @Override
            public void onSuccess(List<HomeBean> homeBeans) {
                // do something
                Toast.makeText(devoislist.this, ""+homeBeans, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(String errorCode, String error) {
                // do something
            }
        });
    }

    public void get(){
        ActivatorBuilder builder = new ActivatorBuilder();
        TuyaHomeSdk.newGatewayInstance("v9it0loritxqmdzo").getSubDevList(new ITuyaDataCallback<List<DeviceBean>>() {
            @Override
            public void onSuccess(List<DeviceBean> list) {

                Toast.makeText(devoislist.this, "just to test answer"+ list, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorCode, String errorMessage) {

            }


        });
        ITuyaActivator mTuyaActivator = TuyaHomeSdk.getActivatorInstance().newMultiActivator(builder);
        mTuyaActivator.start();

    }

    public void getsubdoggatway(){
        TuyaGwSubDevActivatorBuilder builder = new TuyaGwSubDevActivatorBuilder()
                .setDevId("r7071")
                .setTimeOut(100)
                .setListener(new ITuyaSmartActivatorListener() {

                                 @Override
                                 public void onError(String errorCode, String errorMsg) {
                                     Toast.makeText(devoislist.this, "noooo", Toast.LENGTH_SHORT).show();

                                 }

                                 @Override
                                 public void onActiveSuccess(DeviceBean devResp) {
                                     Toast.makeText(devoislist.this, "okk"+devResp, Toast.LENGTH_SHORT).show();

                                 }

                                 @Override
                                 public void onStep(String step, Object data) {

                                 }
                             }

                );
        ITuyaActivator mTuyaGWSubActivator = TuyaHomeSdk.getActivatorInstance().newGwSubDevActivator(builder);

        mTuyaGWSubActivator.start();
    }




}