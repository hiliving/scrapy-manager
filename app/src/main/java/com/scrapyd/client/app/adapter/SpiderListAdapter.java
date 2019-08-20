package com.scrapyd.client.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scrapyd.client.app.R;
import com.scrapyd.client.app.holder.ListHolder;
import com.scrapyd.client.app.model.ListItemVo;
import com.scrapyd.client.app.presenter.ItemClickListener;

import java.util.Collections;
import java.util.List;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class SpiderListAdapter extends RecyclerView.Adapter<ListHolder> {

    private List<ListItemVo> info;
    private ItemClickListener itemClickListener;

    public SpiderListAdapter(List<ListItemVo> info, ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.info = info;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View holderview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        return new ListHolder(holderview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListHolder listHolder, final int i) {

        if (this.info==null){
            return;
        }
        listHolder.itemName.setText(info.get(i).getItemName());


        switch (info.get(i).getStatus()) {
            case 0:
                listHolder.itemStatu.setText("运行中");
                listHolder.control.setText("停止");
                listHolder.control.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null) {
                            itemClickListener.onCancel("", info.get(i).getId());
                            listHolder.itemStatu.setText("已停止");
                        }
                    }
                });
                listHolder.statuIcon.setVisibility(View.GONE);
                listHolder.timeStart.setVisibility(View.VISIBLE);
                listHolder.timeEnd.setVisibility(View.INVISIBLE);
                listHolder.spiderLog.setVisibility(View.VISIBLE);
                listHolder.timeContent.setVisibility(View.VISIBLE);

                String startTimes = info.get(i).getStartTime();
                String starts = startTimes.substring(0, startTimes.indexOf("."));
                listHolder.timeStart.setText("start:" + starts);
                listHolder.spiderLog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null) {
                            itemClickListener.onClickLog(info.get(i).getId());
                        }
                    }
                });
                break;
            case 1:
                listHolder.statuIcon.setVisibility(View.VISIBLE);
                listHolder.itemStatu.setText("等待中");
                listHolder.control.setText("就绪");
                listHolder.statuIcon.setImageResource(R.drawable.ic_wait);

                listHolder.statuIcon.setVisibility(View.VISIBLE);
                listHolder.timeStart.setVisibility(View.INVISIBLE);
                listHolder.timeEnd.setVisibility(View.INVISIBLE);
                listHolder.spiderLog.setVisibility(View.INVISIBLE);
                listHolder.timeContent.setVisibility(View.GONE);
                break;
            case 2:
                listHolder.statuIcon.setVisibility(View.VISIBLE);
                listHolder.itemStatu.setText("已完成");
                listHolder.statuIcon.setImageResource(R.drawable.ic_done);
                listHolder.control.setVisibility(View.GONE);
                listHolder.timeContent.setVisibility(View.VISIBLE);
                listHolder.timeStart.setVisibility(View.VISIBLE);
                listHolder.timeEnd.setVisibility(View.VISIBLE);
                listHolder.spiderLog.setVisibility(View.VISIBLE);

                String startTime = info.get(i).getStartTime();
                String endTime = info.get(i).getEndTime();
                String start = startTime.substring(0, startTime.indexOf("."));
                String end = startTime.substring(0, endTime.indexOf("."));
                listHolder.timeStart.setText("start:" + start);
                listHolder.timeEnd.setText("end:" + end);
                listHolder.spiderLog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null) {
                            itemClickListener.onClickLog(info.get(i).getId());
                        }
                    }
                });
                break;
            default:
                listHolder.control.setVisibility(View.VISIBLE);
                listHolder.itemStatu.setVisibility(View.GONE);
                listHolder.statuIcon.setVisibility(View.GONE);
                listHolder.timeContent.setVisibility(View.GONE);
                listHolder.control.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemClickListener != null) {
                            itemClickListener.start("", info.get(i).getItemName());
                        }
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return info != null ? info.size() : 0;
    }

    public void setData(List<ListItemVo> listItemVo) {
        this.info = listItemVo;
    }
}
