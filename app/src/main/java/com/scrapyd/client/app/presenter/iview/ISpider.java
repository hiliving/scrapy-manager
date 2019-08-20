package com.scrapyd.client.app.presenter.iview;

import com.scrapyd.client.app.model.ListDto;
import com.scrapyd.client.app.model.SpiderItemDto;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public interface ISpider {

    void onLoad(ListDto data);

    void onLoadSpider(SpiderItemDto data);
}
