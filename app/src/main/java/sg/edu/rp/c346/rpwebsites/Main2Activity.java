package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {
    WebView wbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wbView = findViewById(R.id.WebViewPage);

        wbView.setWebViewClient(new WebViewClient());
        Intent intentReceived = getIntent();
        String URL = intentReceived.getStringExtra("URL");
        wbView.loadUrl(URL);
    }
}
