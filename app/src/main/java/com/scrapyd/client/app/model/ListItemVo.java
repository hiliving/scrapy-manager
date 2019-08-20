package com.scrapyd.client.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class ListItemVo {

    private int status;

    private String itemName;

    private String id;

    private String startTime;

    private String endTime;

    private String log;

    public static List<ListItemVo> from(ListDto data) {

        List<ListItemVo> listItemVos = new ArrayList<>();

        for (int i = 0; i < data.getRunning().size(); i++) {
            ListItemVo vo = new ListItemVo();
            vo.setStatus(0);
            vo.setId(data.getRunning().get(i).getId());
            vo.setItemName(data.getRunning().get(i).getSpider());
            vo.setStartTime(data.getRunning().get(i).getStart_time());
            listItemVos.add(vo);
        }
        for (int i = 0; i < data.getPending().size(); i++) {
            ListItemVo vo = new ListItemVo();
            vo.setStatus(1);
            vo.setId(data.getPending().get(i).getId());
            vo.setItemName(data.getPending().get(i).getSpider());
            listItemVos.add(vo);
        }
        for (int i = 0; i < data.getFinished().size(); i++) {
            ListItemVo vo = new ListItemVo();
            vo.setStatus(2);
            vo.setId(data.getFinished().get(i).getId());
            vo.setItemName(data.getFinished().get(i).getSpider());
            vo.setStartTime(data.getFinished().get(i).getStart_time());
            vo.setEndTime(data.getFinished().get(i).getEnd_time());
            listItemVos.add(vo);
        }
        return listItemVos;
    }

    public static List<ListItemVo> from(SpiderItemDto data) {
        List<ListItemVo> listItemVos = new ArrayList<>();

        for (int i = 0; i < data.getSpiders().size(); i++) {
            ListItemVo vo = new ListItemVo();
            vo.setItemName(data.getSpiders().get(i));
            vo.setStatus(-1);
            listItemVos.add(vo);
        }
        return listItemVos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
