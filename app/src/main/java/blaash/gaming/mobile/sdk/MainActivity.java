package blaash.gaming.mobile.sdk;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.utils.ViewSpline;

import blaash.gaming.mobile.urlmodule.BlaashEvents;
import blaash.gaming.mobile.urlmodule.BlaashSDK;
import blaash.gaming.mobile.urlmodule.Customer;
import blaash.gaming.mobile.urlmodule.Product;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//*********************************************************************Token**************************************************************
//        Events events = new Events(new TokenFormat("abcd","xyz","DC101","tenant1CustomerSocial@gmail.com","abcd@fb.com"));
//
//        String token = events.getTokenToSend();
//        Log.e(TAG, "onCreate: Token = " + token);
//
//        Button btn = findViewById(R.id.button);
//        btn.setOnClickListener(v ->
//        {
//            Intent i = new Intent(this,WebViewActivity.class);
//            i.putExtra("token",token);
//            startActivity(i);
//        })
// *********************************************************************Token**************************************************************
        BlaashSDK sdk = new BlaashSDK();
        sdk.initialize("abc","abc","abc","abc","abc","abc");

    }
}