package sunny.testrequestsample.fragment.firstfragmet;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sunny.testrequestsample.data.model.Answer;
import sunny.testrequestsample.data.network.ApiUtils;
import sunny.testrequestsample.data.network.SOService;

/**
 * Created by Wayan-MECS on 10/1/2018.
 */

public class presentFirstFragment implements contractFirstFragment.presenter {

    private contractFirstFragment.mainView mv;
    SOService mServices = ApiUtils.getSOService();

    public presentFirstFragment(contractFirstFragment.mainView mainView) {
        this.mv = mainView;
    }

    @Override
    public void onRefresh(final Context frag, final xAdapter adapter, String order, String sort, String site) {
        mServices.getAnswers(order, sort, site).enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                mv.showProgress();
                if (response.isSuccessful()) {
                    Log.d("res", "success");
                    mv.hideProgress();
                    adapter.updateAnswers(response.body().getItems());
                } else {
                    Log.d("res", "not success");
                    mv.hideProgress();
                    Toast.makeText(frag, "check your connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {

            }
        });
    }
}
