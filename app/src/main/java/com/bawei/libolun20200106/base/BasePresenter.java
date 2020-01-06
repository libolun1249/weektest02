package com.bawei.libolun20200106.base;

import com.bawei.libolun20200106.contract.IContract;

import java.lang.ref.WeakReference;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:02
 * @description P层的基类
 */
public abstract class BasePresenter<V extends IContract.IView> implements IContract.IPresenter {

    private WeakReference<V> weakReference;

    public BasePresenter(){

    }

    public void onAttch(V v){
        weakReference = new WeakReference<>(v);
    }

    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference = null;
        }
    }




}
