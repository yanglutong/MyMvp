package com.yang.mymvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yang.mymvp.R;
import com.yang.mymvp.bean.JsonBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReAdapter extends RecyclerView.Adapter {
    private List<JsonBean.DataBean.ArticleListBean> itemList;
    private Context context;

    public ReAdapter(List<JsonBean.DataBean.ArticleListBean> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemView(LayoutInflater.from(context).inflate(R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemView itemView= (ItemView) holder;
        itemView.retitle.setText(itemList.get(position).getColumn_name());
        itemView.reYueDu.setText(itemList.get(position).getColumn_name());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    class ItemView extends RecyclerView.ViewHolder{

        private final CheckBox reCheck;
        private final TextView retitle;
        private final TextView reYueDu;

        public ItemView(@NonNull View itemView) {
            super(itemView);
            retitle = itemView.findViewById(R.id.ReTitle);
            reYueDu = itemView.findViewById(R.id.ReYueDu);
            reCheck = itemView.findViewById(R.id.Checked);
        }
    }
}
