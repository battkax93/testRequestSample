package sunny.testrequestsample.fragment.secondfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sunny.testrequestsample.R;
import sunny.testrequestsample.activity.custom_chrome_tab.CustomTabActivityHelper;
import sunny.testrequestsample.activity.custom_chrome_tab.WebviewFallback;
import sunny.testrequestsample.activity.qrcode_activity.QrCodeActivity;
import sunny.testrequestsample.activity.txtrecog_activity.TextRecogActivity;

public class SecondFragment extends Fragment implements contractSecondFragment.mainView {

    Button bTxtRecog, bQrCode, bTest;
    Context ctx;
    Boolean grant = false;

    private static String TAG = "SecondFragment";
    private static int requestPermissionID = 88;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View secondFragment = inflater.inflate(R.layout.fragment_second, container, false);
        init(secondFragment);
        return secondFragment;
    }

    void init(View view) {
        ctx = getContext();
        bTxtRecog = view.findViewById(R.id.b_txt_recog);
        bQrCode = view.findViewById(R.id.b_qrcode);
        bTest = view.findViewById(R.id.b_test);

        bTxtRecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(1);
            }
        });
        bQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(2);
            }
        });
        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(3);
            }
        });

    }

    private void action (int pos){
        Intent i;
        switch (pos){
            case 1:
                Log.d(TAG,"1");
                i = new Intent(getContext(), TextRecogActivity.class);
                startActivity(i);
                break;
            case 2:
                Log.d(TAG,"2");
                i = new Intent(getContext(), QrCodeActivity.class);
                startActivity(i);
                break;
            case 3:
                Log.d(TAG,"3");
                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                CustomTabActivityHelper.openCustomTab(
                        getActivity(),// activity
                        customTabsIntent,
                        Uri.parse("http://www.google.com"),
                        new WebviewFallback()
                );
        }
    }

    @Override
    public void showToast() {

    }
}
