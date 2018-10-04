package sunny.testrequestsample.activity.custom_chrome_tab;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Wayan-MECS on 10/3/2018.
 */

public class WebviewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, TestChromeTabsActivity.class);
        intent.putExtra(TestChromeTabsActivity.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }
}
