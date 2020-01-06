package com.bawei.libolun20200106.contract;

import java.util.HashMap;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:02
 * @description 契约类
 */
public interface IContract {

    interface IModel {
        void getLeftData(IModelCallback modelCallback);

        void getRightData(HashMap<String, String> params, IModelCallback modelCallback);
    }

    interface IModelCallback {
        void success(Object o);

        void failure(Throwable throwable);
    }

    interface IView {
        void success(Object o);

        void failure(Throwable throwable);

    }

    interface IPresenter {
        void getLeftData();

        void getRightData(HashMap<String, String> params);
    }
}
