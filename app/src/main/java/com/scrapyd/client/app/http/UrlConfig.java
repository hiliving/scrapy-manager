package com.scrapyd.client.app.http;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class UrlConfig {


    public static String BASE_URL = "http://123.207.150.253:6800/";

    //获取任务进行时列表
    public static final String GetSpiderJobsList = "listjobs.json";

    //运行爬虫
    public static final String ScheduleSpider = "schedule.json";


    public static final String GetSpiderList ="listspiders.json";
}
