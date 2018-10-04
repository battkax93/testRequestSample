package sunny.testrequestsample.fragment.firstfragmet;

import android.content.Context;

public interface contractFirstFragment {

    interface mainView{
        void showProgress();
        void hideProgress();
    }

    interface presenter{
        void onRefresh(Context frag, xAdapter adapter, String order, String sort, String site);
    }
}
