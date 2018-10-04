package sunny.testrequestsample.activity.custom_chrome_tab;

import android.support.customtabs.CustomTabsClient;

/**
 * Created by Wayan-MECS on 10/3/2018.
 */

public interface ServiceConnectionCallback {
    /**
     * Called when the service is connected.
     *
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected.
     */
    void onServiceDisconnected();
}

