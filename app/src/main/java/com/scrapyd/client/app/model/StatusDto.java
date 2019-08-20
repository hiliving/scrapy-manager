package com.scrapyd.client.app.model;

/**
 * @author huangyong
 * createTime 2019-07-22
 */
public class StatusDto {


    /**
     * status : ok
     * running : 0
     * pending : 0
     * finished : 0
     * node_name : node-name
     */

    private String status;
    private String running;
    private String pending;
    private String finished;
    private String node_name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }
}
