package com.scrapyd.client.app.presenter;

/**
 * @author huangyong
 * createTime 2019-07-23
 */
public interface ItemClickListener {
    void onCancel(String projectName,String jobId);
    void start(String projectNamem,String spiderName);

    void onClickLog(String JobId);
}
