package com.scrapyd.client.app.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.scrapyd.client.app.http.ApiService;
import com.scrapyd.client.app.http.BaseApi;
import com.scrapyd.client.app.model.ListDto;
import com.scrapyd.client.app.model.ScheduleDto;
import com.scrapyd.client.app.model.SpiderItemDto;
import com.scrapyd.client.app.presenter.iview.ISpider;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class SpiderPresenter {

    private Context context;
    private ISpider iSpider;

    public SpiderPresenter(Context context, ISpider iSpider) {
        this.context = context;
        this.iSpider = iSpider;
    }

    /**
     * 获取爬虫状态列表
     */
    public void getTaskList(String projectName){

        BaseApi.request(BaseApi.createApi(ApiService.class)
                        .getSpiderList(projectName), new BaseApi.IResponseListener<ListDto>() {
                    @Override
                    public void onSuccess(ListDto data) {
                        iSpider.onLoad(data);
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(context, "加载失败", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    /**
     * 运行爬虫
     */
    public void runSpider(String projectName,String spiderName){

        BaseApi.request(BaseApi.createApi(ApiService.class)
                        .runSpider(projectName,spiderName), new BaseApi.IResponseListener<ScheduleDto>() {
                    @Override
                    public void onSuccess(ScheduleDto data) {
                        Toast.makeText(context, ""+data.getStatus(), Toast.LENGTH_SHORT).show();
                        Log.e("getstatus",data.getJobid()+""+data.getStatus());
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(context, "加载失败", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    /**
     * 获取项目所有爬虫
     * @param projectName
     */
    public void getSpiderList(String projectName) {
        BaseApi.request(BaseApi.createApi(ApiService.class)
                        .getSpiders(projectName), new BaseApi.IResponseListener<SpiderItemDto>() {
                    @Override
                    public void onSuccess(SpiderItemDto data) {
                        iSpider.onLoadSpider(data);
                        Log.e("getspiderlist",data.getStatus()+""+data.getSpiders().size());
                    }

                    @Override
                    public void onFail() {
                        Toast.makeText(context, "加载失败", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void cancel(String movRecommond, String jobId) {

    }
}
