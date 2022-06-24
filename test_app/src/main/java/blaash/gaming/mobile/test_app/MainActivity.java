package blaash.gaming.mobile.test_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import blaash.gaming.mobile.sdk.BlaashSDK;
import blaash.gaming.mobile.sdk.BuildConfig;
import blaash.gaming.mobile.sdk.Crypto;
import blaash.gaming.mobile.sdk.Customer;
import blaash.gaming.mobile.sdk.Token;
import blaash.gaming.mobile.sdk.TokenGeneration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TokenGeneration tkgen = new TokenGeneration(new Token("abc","abc",
                "abc", "abc","abc"));
        try {
            Log.e(TAG, "onCreate: Token = " + tkgen.getTokenToSend());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            TokenGeneration.encrypt("Hello","0123456789abcdef");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        BlaashSDK sdk = new BlaashSDK();
//        sdk.initialize("abc","abc","abc","abc","abc",
//                "abc");
//        Customer customer = new Customer();
//        customer.setFirst_name("abc");
//        customer.setLast_name("abc");
//        customer.setEmailId("abc");
//        sdk.notifySignUp(customer);
    }
}