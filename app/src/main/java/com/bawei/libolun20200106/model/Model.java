package com.bawei.libolun20200106.model;

import com.bawei.libolun20200106.api.Api;
import com.bawei.libolun20200106.api.ApiService;
import com.bawei.libolun20200106.bean.LeftBean;
import com.bawei.libolun20200106.bean.RightLean;
import com.bawei.libolun20200106.contract.IContract;
import com.bawei.libolun20200106.utils.NetUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:03
 * @description M层
 */
public class Model implements IContract.IModel {
    @Override
    public void getLeftData(IContract.IModelCallback modelCallback) {
        NetUtils.getInstance().classservice(ApiService.class).getLeft()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        modelCallback.success(leftBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightData(HashMap<String, String> params, IContract.IModelCallback modelCallback) {
        NetUtils.getInstance().classservice(ApiService.class).getRight()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightLean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightLean rightLean) {
                        modelCallback.success(rightLean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
