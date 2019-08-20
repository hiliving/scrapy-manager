package com.scrapyd.client.app.http;

import com.scrapyd.client.app.model.ListDto;
import com.scrapyd.client.app.model.ScheduleDto;
import com.scrapyd.client.app.model.SpiderItemDto;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public interface ApiService {


    @GET(UrlConfig.GetSpiderJobsList)
    Observable<ListDto> getSpiderList(@Query("project") String projectName);

    @GET(UrlConfig.GetSpiderList)
    Observable<SpiderItemDto> getSpiders(@Query("project") String projectName);

    @FormUrlEncoded
    @POST(UrlConfig.ScheduleSpider)
    Observable<ScheduleDto> runSpider(@Field("project") String project,@Field("spider") String spiderName);


}
