package room.lipengfei.com.yourroom.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a1 on 2017/5/25.
 */

public class RetrofitUtils {
    public static String BASE_URL ="";
    public static  MyService getMyService(){
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//错误重连
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        MyService myService = retrofit.create(MyService.class);
        return myService;
    }
}
