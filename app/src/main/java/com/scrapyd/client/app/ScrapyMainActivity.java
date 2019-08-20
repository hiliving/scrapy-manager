package com.scrapyd.client.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.scrapyd.client.app.adapter.SpiderListAdapter;
import com.scrapyd.client.app.model.ListDto;
import com.scrapyd.client.app.model.ListItemVo;
import com.scrapyd.client.app.model.SpiderItemDto;
import com.scrapyd.client.app.presenter.ItemClickListener;
import com.scrapyd.client.app.presenter.SpiderPresenter;
import com.scrapyd.client.app.presenter.iview.ISpider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrapyMainActivity extends AppCompatActivity implements ISpider {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.spider_list)
    RecyclerView spiderList;
    @BindView(R.id.task_list)
    RecyclerView taskList;
    @BindView(R.id.refresh)
    TextView refresh;
    private SpiderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrapy_main);
        ButterKnife.bind(this);

        presenter = new SpiderPresenter(this, this);
        initData();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                Toast.makeText(ScrapyMainActivity.this, "已刷新", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //任务列表，刚开始应该是空的
        presenter.getTaskList("Movie");
        //获取爬虫列表
        presenter.getSpiderList("Movie");
    }

    @Override
    public void onLoad(ListDto data) {

        List<ListItemVo> listItemVo = ListItemVo.from(data);
        SpiderListAdapter spiderListAdapter = new SpiderListAdapter(listItemVo,itemClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        taskList.setLayoutManager(linearLayoutManager);
        taskList.setAdapter(spiderListAdapter);
    }

    @Override
    public void onLoadSpider(SpiderItemDto data) {
        List<ListItemVo> listItemVo = ListItemVo.from(data);
        SpiderListAdapter spiderListAdapter = new SpiderListAdapter(listItemVo,itemClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        spiderList.setLayoutManager(linearLayoutManager);
        spiderList.setAdapter(spiderListAdapter);
    }

    ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onCancel(String projectName, String jobId) {
            presenter.cancel("Movie",jobId);
        }

        @Override
        public void start(String projectNamem, String spiderName) {
            presenter.runSpider("Movie",spiderName);
        }

        @Override
        public void onClickLog(String JobId) {

        }
    };
}
