package com.bawei.libolun20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.libolun20200106.R;
import com.bawei.libolun20200106.bean.RightLean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:02
 * @description 右侧列表的适配器
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {

    private Context context;
    private List<RightLean.Right> list;

    public RightAdapter(Context context, List<RightLean.Right> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //右侧列表的布局
        View view = View.inflate(context, R.layout.right_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position).goods_name);
        Glide.with(context).load(list.get(position).goods_thumb)
                .transform(new RoundedCorners(10))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv)
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
