package bibi.applogin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

    private WebView web;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.wv);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        String databasePath = getApplicationContext()
                .getDir("database", Context.MODE_PRIVATE).getPath();
        webSettings.setDatabasePath(databasePath);

        web.loadUrl("file:///android_asset/index.html");

        web.setWebViewClient(new WebViewClient(){
            // Override URL
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String targetUrl1 = "file:///android_asset/sobre";
                String targetUrl2 = "file:///android_asset/politica";
                if(targetUrl1.equals(url)) {
                    Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                    startActivity(intent);
                    return true;
                }if(targetUrl2.equals(url)) {
                    Intent intent = new Intent(getApplicationContext(), PoliticaActivity.class);
                    startActivity(intent);
                    return true;
                }else{
                    view.loadUrl(url);
                }
                return true;
            }
        });

    }
}
