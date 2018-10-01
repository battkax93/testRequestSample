package sunny.testrequestsample.fragment.firstfragmet;

import android.content.Context;

/**
 * Created by Wayan-MECS on 10/1/2018.
 */

public interface contractFirstFragment {

    interface mainView{
        void showProgress();
        void hideProgress();
    }

    interface presenter{
        void onRefresh(Context frag, xAdapter adapter, String order, String sort, String site);
    }
}
