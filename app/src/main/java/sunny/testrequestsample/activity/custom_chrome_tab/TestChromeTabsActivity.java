package sunny.testrequestsample.activity.custom_chrome_tab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import sunny.testrequestsample.R;

public class TestChromeTabsActivity extends AppCompatActivity {

    WebView wv;
    WebSettings ws;
    public static final String EXTRA_URL = "extra.url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chrome_tabs);
        init();
    }

    private void init(){
        String url = getIntent().getStringExtra(EXTRA_URL);
        wv = findViewById(R.id.webview);
        wv.setWebViewClient(new WebViewClient());
        ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setAllowFileAccess(true);
        setTitle(url);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        wv.loadUrl(url);

    }
}
