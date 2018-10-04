package sunny.testrequestsample.activity.txtrecog_activity;

import android.app.Activity;

/**
 * Created by Wayan-MECS on 10/3/2018.
 */

public interface textRecogContract {

    interface mainView {
        void startCamera(Activity activity);
        void showProgress();
        void hideProgress();
    }

}
