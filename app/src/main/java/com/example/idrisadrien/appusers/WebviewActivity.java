package com.example.idrisadrien.appusers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by idrisadrien on 20/10/2017.
 */

public class WebviewActivity extends Activity {

    /* Cette activité permet l'affichage de la page d'aide par le biais du bouton Aide se trouvant
    sur la page principale */

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("file:///android_asset/index.html");


        final Button retour = (Button)findViewById(R.id.retour);
        View.OnClickListener clikOnRetour = new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(WebviewActivity.this, ListUsersActivity.class);
                intent.putExtra("test",-1);
                startActivity(intent);
            }
        };

        retour.setOnClickListener(clikOnRetour);

        Intent intent = getIntent();

    }


}
