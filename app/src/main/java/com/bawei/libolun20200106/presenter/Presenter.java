package com.bawei.libolun20200106.presenter;

import com.bawei.libolun20200106.contract.IContract;
import com.bawei.libolun20200106.model.Model;

import java.util.HashMap;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:03
 * @description P层
 */
public class Presenter implements IContract.IPresenter {

    private IContract.IView iView;
    private Model model;

    public Presenter(IContract.IView iView) {
        this.iView = iView;
        model = new Model();
    }

    @Override
    public void getLeftData() {
        model.getLeftData(new IContract.IModelCallback() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });
    }

    @Override
    public void getRightData(HashMap<String, String> params) {
        model.getRightData(params, new IContract.IModelCallback() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });
    }
}
