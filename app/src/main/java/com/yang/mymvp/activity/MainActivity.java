package com.yang.mymvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yang.mymvp.R;
import com.yang.mymvp.adapter.ReAdapter;
import com.yang.mymvp.base.BaseActivity;
import com.yang.mymvp.base.BasePresenter;
import com.yang.mymvp.bean.JsonBean;
import com.yang.mymvp.presenter.MainPresenter;
import com.yang.mymvp.utils.ToastUtils;
import com.yang.mymvp.view.MainView;
import com.yang.mymvp.weight.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    private RecyclerView mRecycler;
    private Button mBtDelete;
    private Button mBtEdit;
    private Button mBtUnQx;
    private boolean isVisible=true;
    private List<JsonBean.DataBean.ArticleListBean> itemList;
    private ReAdapter reAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        //找到控件
        mRecycler = findViewById(R.id.recycler);
        mBtDelete = findViewById(R.id.BtDelete);
        mBtEdit = findViewById(R.id.BtEdit);
        mBtUnQx = findViewById(R.id.BtUnQx);
        mBtDelete.setOnClickListener(this);
        mBtEdit.setOnClickListener(this);
        mBtUnQx.setOnClickListener(this);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        showLoading();
        //设置布局管理器
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        //设置分割线
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //创建数据源
        itemList = new ArrayList<>();
        //创建适配器
        reAdapter = new ReAdapter(itemList, this);
        //设置适配器
        mRecycler.setAdapter(reAdapter);
        //加载数据
        presenter.getData();

        reAdapter.setShowDelete(new ReAdapter.ShowDelete() {
            @Override
            public void showDelete(boolean fs) {
                if(fs){
                    mBtDelete.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    public void setBean(JsonBean jsonBean) {
        itemList.addAll(jsonBean.getData().getArticle_list());
        reAdapter.notifyDataSetChanged();
    }

    @Override
    public void setToast(String msg) {
        showToast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtEdit:{
                //点击编辑模式显示checkbox和取消按钮
                if(isVisible){
                    reAdapter.setVisible(isVisible);
                    //取消按钮显示
                    mBtUnQx.setVisibility(View.VISIBLE);
                    isVisible=false;
                    reAdapter.notifyDataSetChanged();
                }else{
                    reAdapter.setVisible(isVisible);
                    //取消按钮显示
                    mBtUnQx.setVisibility(View.GONE);
                    isVisible=true;
                    reAdapter.notifyDataSetChanged();
                }
                break;
            }
            case R.id.BtUnQx:{
                break;
            }
            case R.id.BtDelete:{
                ArrayList<JsonBean.DataBean.ArticleListBean> listBeans = new ArrayList<>();
                for (int i = 0; i <reAdapter.itemList.size() ; i++) {
                    if(reAdapter.itemList.get(i).isCheck){
                        listBeans.add(itemList.get(i));
                    }
                }
                itemList.removeAll(listBeans);
                reAdapter.notifyDataSetChanged();
                break;
            }
        }
    }
}
