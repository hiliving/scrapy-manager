package com.scrapyd.client.app.model;

import java.util.List;

/**
 * @author huangyong
 * createTime 2019-07-22
 * 获取爬虫状态，运行中、完成、等待
 */
public class ListDto {

    /**
     * status : ok
     * pending : [{"id":"78391cc0fcaf11e1b0090800272a6d06","spider":"spider1"}]
     * running : [{"id":"422e608f9f28cef127b3d5ef93fe9399","spider":"spider2","start_time":"2012-09-12 10:14:03.594664"}]
     * finished : [{"id":"2f16646cfcaf11e1b0090800272a6d06","spider":"spider3","start_time":"2012-09-12 10:14:03.594664","end_time":"2012-09-12 10:24:03.594664"}]
     */

    private String status;
    private List<PendingBean> pending;
    private List<RunningBean> running;
    private List<FinishedBean> finished;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PendingBean> getPending() {
        return pending;
    }

    public void setPending(List<PendingBean> pending) {
        this.pending = pending;
    }

    public List<RunningBean> getRunning() {
        return running;
    }

    public void setRunning(List<RunningBean> running) {
        this.running = running;
    }

    public List<FinishedBean> getFinished() {
        return finished;
    }

    public void setFinished(List<FinishedBean> finished) {
        this.finished = finished;
    }

    public static class PendingBean {
        /**
         * id : 78391cc0fcaf11e1b0090800272a6d06
         * spider : spider1
         */

        private String id;
        private String spider;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpider() {
            return spider;
        }

        public void setSpider(String spider) {
            this.spider = spider;
        }
    }

    public static class RunningBean {
        /**
         * id : 422e608f9f28cef127b3d5ef93fe9399
         * spider : spider2
         * start_time : 2012-09-12 10:14:03.594664
         */

        private String id;
        private String spider;
        private String start_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpider() {
            return spider;
        }

        public void setSpider(String spider) {
            this.spider = spider;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }
    }

    public static class FinishedBean {
        /**
         * id : 2f16646cfcaf11e1b0090800272a6d06
         * spider : spider3
         * start_time : 2012-09-12 10:14:03.594664
         * end_time : 2012-09-12 10:24:03.594664
         */

        private String id;
        private String spider;
        private String start_time;
        private String end_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpider() {
            return spider;
        }

        public void setSpider(String spider) {
            this.spider = spider;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }
}
