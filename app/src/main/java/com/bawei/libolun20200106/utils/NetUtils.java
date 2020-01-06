package com.bawei.libolun20200106.utils;

import com.bawei.libolun20200106.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:03
 * @description 封装网络工具类
 */
public class NetUtils {

    private static NetUtils netUtils;
    private Retrofit retrofit;

    private NetUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    //单例模式
    public static NetUtils getInstance() {
        if (netUtils == null) {
            synchronized (NetUtils.class) {
                if (netUtils == null) {
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public <T> T classservice(Class<T> tClass) {
        T t = retrofit.create(tClass);
        return t;
    }

    //判断有网无网
    public boolean isNet(){
        return netUtils.isNet();
    }
}
