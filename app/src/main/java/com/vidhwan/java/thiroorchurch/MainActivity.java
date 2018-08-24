package com.vidhwan.java.thiroorchurch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView nonet = findViewById(R.id.nmg);
        WebView webView=findViewById(R.id.wv);

        webView.loadUrl("http://thiroorchurch.org");


        if(isOnline(getApplicationContext())) {

            webView.setVisibility(View.VISIBLE);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
        }

        else

        {
            Toast.makeText(MainActivity.this, "No internet connection!", Toast.LENGTH_LONG).show();
            nonet.setVisibility(View.VISIBLE);
        }


    }

    private boolean isOnline(Context ctx) {

        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }


    }


    @Override
    public void onBackPressed() {
        WebView webView=findViewById(R.id.wv);
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
            Toast.makeText(MainActivity.this,"God Bless You!",Toast.LENGTH_SHORT).show();
        }
    }
}
