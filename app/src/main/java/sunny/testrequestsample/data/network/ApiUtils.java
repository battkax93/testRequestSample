package sunny.testrequestsample.data.network;

import sunny.testrequestsample.Globals;


public class ApiUtils {


    private ApiUtils() {}

    //set baseUrl & time out here
    public static SOService getSOService() {
        return RetrofitClient
                .getClient(Globals.BASE_URL_STACK,Globals.timeout)
                .create(SOService.class);
    }
}
