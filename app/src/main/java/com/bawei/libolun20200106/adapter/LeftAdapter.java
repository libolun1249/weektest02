package com.bawei.libolun20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.libolun20200106.R;
import com.bawei.libolun20200106.bean.LeftBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:02
 * @description 左侧列表适配器
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context context;
    private List<LeftBean.Left.Category> categoryList;

    public LeftAdapter(Context context, List<LeftBean.Left.Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //左侧列表的布局
        View view = View.inflate(context, R.layout.left_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(categoryList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv)
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private LeftClick leftClick;

    public void setLeftClick(LeftClick leftClick) {
        this.leftClick = leftClick;
    }

    public interface LeftClick {
        void leftclick(String id);
    }
}
