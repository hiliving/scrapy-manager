package com.scrapyd.client.app.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.scrapyd.client.app.R;
import com.scrapyd.client.app.adapter.SpiderListAdapter;
import com.scrapyd.client.app.model.ListDto;
import com.scrapyd.client.app.model.ListItemVo;
import com.scrapyd.client.app.model.SpiderItemDto;
import com.scrapyd.client.app.presenter.ItemClickListener;
import com.scrapyd.client.app.presenter.SpiderPresenter;
import com.scrapyd.client.app.presenter.iview.ISpider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpiderListFragment extends Fragment implements ISpider {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private RecyclerView recyclerView;
    private SpiderPresenter presenter;
    private int index;
    private List<ListItemVo> listItemVo =new ArrayList<>();
    private SpiderListAdapter spiderListAdapter;

    public static SpiderListFragment newInstance(int index) {
        SpiderListFragment fragment = new SpiderListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_spider_manager, container, false);
        recyclerView = root.findViewById(R.id.item_list);


        presenter = new SpiderPresenter(getContext(), this);

        pageViewModel.getSpiderList().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                Log.e("getdataresu", s + "");
                switch (s) {
                    case 1:
                        //获取任务总表
                        presenter.getSpiderList("Movie");
                        //获取任务状态表，共3个
                        presenter.getTaskList("Movie");
                        break;
                    case 2:
                        //获取任务状态表，共3个
                        presenter.getTaskList("Movie");
                        break;
                    default:
                        break;
                }
            }
        });
        if (index == 2) {
            spiderListAdapter = new SpiderListAdapter(listItemVo, itemClickListener);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(spiderListAdapter);
            Observable.interval(2000, TimeUnit.MILLISECONDS).subscribe(new io.reactivex.Observer<Long>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Long aLong) {
                    Log.e("hahahahah", "yes run");
                    if (presenter != null) {
                        //获取任务状态表，共3个
                        presenter.getTaskList("Movie");
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        }
        return root;
    }

    @Override
    public void onLoad(ListDto data) {
        switch (index) {
            case 2:
                listItemVo = ListItemVo.from(data);
                if (spiderListAdapter!=null){
                    spiderListAdapter.setData(listItemVo);
                    spiderListAdapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoadSpider(SpiderItemDto data) {
        List<ListItemVo> listItemVo = ListItemVo.from(data);
        SpiderListAdapter spiderListAdapter = new SpiderListAdapter(listItemVo, itemClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(spiderListAdapter);
    }

    ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onCancel(String projectName, String jobId) {
            presenter.cancel("Movie", jobId);
        }

        @Override
        public void start(String projectNamem, String spiderName) {
            presenter.runSpider("Movie", spiderName);
        }

        @Override
        public void onClickLog(String JobId) {

        }
    };
}