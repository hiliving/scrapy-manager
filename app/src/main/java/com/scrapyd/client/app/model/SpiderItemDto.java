package com.scrapyd.client.app.model;

import java.util.List;

/**
 * @author huangyong
 * createTime 2019-07-23
 */
public class SpiderItemDto {

    /**
     * status : ok
     * spiders : ["spider1","spider2","spider3"]
     */

    private String status;
    private List<String> spiders;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSpiders() {
        return spiders;
    }

    public void setSpiders(List<String> spiders) {
        this.spiders = spiders;
    }
}
