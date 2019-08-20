package com.scrapyd.client.app.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scrapyd.client.app.R;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class ListHolder extends RecyclerView.ViewHolder {

    public TextView itemName;
    public TextView itemStatu;
    public TextView control;
    public ImageView statuIcon;
    public TextView timeStart;
    public TextView timeEnd;
    public ImageView spiderLog;
    public LinearLayout timeContent;

    public ListHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.spider_name);
        statuIcon = itemView.findViewById(R.id.statu_icon);
        timeStart = itemView.findViewById(R.id.time_start);
        timeEnd = itemView.findViewById(R.id.time_end);
        spiderLog = itemView.findViewById(R.id.spider_log);
        itemStatu = itemView.findViewById(R.id.spider_status);
        control = itemView.findViewById(R.id.control);
        timeContent = itemView.findViewById(R.id.time_content);

    }
}
