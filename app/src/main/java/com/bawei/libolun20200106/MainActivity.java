package com.bawei.libolun20200106;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.bawei.libolun20200106.bean.LeftBean;
import com.bawei.libolun20200106.bean.RightLean;
import com.bawei.libolun20200106.contract.IContract;
import com.bawei.libolun20200106.presenter.Presenter;
import com.bawei.libolun20200106.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements IContract.IView {

    @BindView(R.id.leftrv)
    RecyclerView leftrv;
    @BindView(R.id.rightrv)
    RecyclerView rightrv;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*presenter = new Presenter(this);*/
        //初始化控件
        leftrv = findViewById(R.id.leftrv);
        rightrv = findViewById(R.id.rightrv);
        leftrv.setLayoutManager(new LinearLayoutManager(this));
        rightrv.setLayoutManager(new GridLayoutManager(this, 2));
        //eventbus注册
        EventBus.getDefault().register(this);
        if (NetUtils.getInstance().isNet()) {
            presenter.getLeftData();
        } else {
            Toast.makeText(this, "没有网络连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void success(Object o) {
        if (o instanceof LeftBean) {

        } else if (o instanceof RightLean) {

        }
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
