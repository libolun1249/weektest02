package com.bawei.libolun20200106.api;

import com.bawei.libolun20200106.bean.LeftBean;
import com.bawei.libolun20200106.bean.RightLean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:00
 * @description api接口类
 */
public interface ApiService {

    @GET("baweiapi/category")
    Observable<LeftBean> getLeft();

    @GET("baweiapi/shopByCategory?category=生活")
    Observable<RightLean> getRight();


}
