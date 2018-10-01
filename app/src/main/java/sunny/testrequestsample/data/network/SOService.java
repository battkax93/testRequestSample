package sunny.testrequestsample.data.network;


import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sunny.testrequestsample.Globals;
import sunny.testrequestsample.data.model.Answer;

/**
 * Created by Chike on 12/3/2016.
 */


public interface SOService {

    String url = Globals.BASE_URL_STACK2;

    @GET(url)
    Call<Answer> getAnswers();

    @GET(url)
    Call<Answer> getAnswers(
            @Query("order") String order,
            @Query("sort") String sort,
            @Query("site") String site);

    @GET(url)
    Call<Answer> getDisplayImage();
    // RxJava
    // Observable<SOAnswersResponse> getAnswers();

    @GET(url)
    Call<List<Answer>> getAnswers(@Query("tagged") String tags);


}
