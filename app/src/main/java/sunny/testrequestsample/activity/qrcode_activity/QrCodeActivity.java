package sunny.testrequestsample.activity.qrcode_activity;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;
import sunny.testrequestsample.R;
import sunny.testrequestsample.activity.custom_chrome_tab.CustomTabActivityHelper;
import sunny.testrequestsample.activity.custom_chrome_tab.WebviewFallback;

public class QrCodeActivity extends Activity implements QRCodeReaderView.OnQRCodeReadListener {

    QRCodeReaderView qrCodeReaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        init();
    }

    private void init() {
        qrCodeReaderView = findViewById(R.id.camera_view);
        qrCodeReaderView.setOnQRCodeReadListener(this);
        qrCodeReaderView.setQRDecodingEnabled(true);
        qrCodeReaderView.setAutofocusInterval(2000L);
        qrCodeReaderView.setTorchEnabled(true);
        qrCodeReaderView.setBackCamera();
        qrCodeReaderView.setHorizontalFadingEdgeEnabled(true);
        qrCodeReaderView.animate();
        qrCodeReaderView.startCamera();
    }

    private void goToChromeTabs(String url) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        CustomTabActivityHelper.openCustomTab(this,// activity
                customTabsIntent,
                Uri.parse(url),
                new WebviewFallback()
        );
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        goToChromeTabs(text);
    }
}

