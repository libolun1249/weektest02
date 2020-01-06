package com.bawei.libolun20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.libolun20200106.contract.IContract;

import butterknife.Unbinder;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:03
 * @description Activity的基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {

    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Layout());

        p = initPresenter();
        if (p != null) {
            p.onAttch(this);
            p = null;
        }
        initData();
        initView();

    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract int Layout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null) {
            p.deatch();
            p = null;
        }
    }
}
