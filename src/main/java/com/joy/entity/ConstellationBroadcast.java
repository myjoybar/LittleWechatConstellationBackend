package com.joy.entity;

import javax.persistence.Entity;

/**
 * Created by joybar on 2018/2/5.
 */

@Entity
public class ConstellationBroadcast extends BaseData {
    private String constellationName;
    private Integer constellationType;
    private String broadcastMessage;

    private long publishTimestamp;
    private long startValidTimestamp;
    private long endValidTimestamp;

    public long getPublishTimestamp() {
        return publishTimestamp;
    }

    public void setPublishTimestamp(long publishTimestamp) {
        this.publishTimestamp = publishTimestamp;
    }

    public long getStartValidTimestamp() {
        return startValidTimestamp;
    }

    public void setStartValidTimestamp(long startValidTimestamp) {
        this.startValidTimestamp = startValidTimestamp;
    }

    public long getEndValidTimestamp() {
        return endValidTimestamp;
    }

    public void setEndValidTimestamp(long endValidTimestamp) {
        this.endValidTimestamp = endValidTimestamp;
    }

    public String getBroadcastMessage() {
        return broadcastMessage;
    }

    public void setBroadcastMessage(String broadcastMessage) {
        this.broadcastMessage = broadcastMessage;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    public Integer getConstellationType() {
        return constellationType;
    }

    public void setConstellationType(Integer constellationType) {
        this.constellationType = constellationType;
    }
}
