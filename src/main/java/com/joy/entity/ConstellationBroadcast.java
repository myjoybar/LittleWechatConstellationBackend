package com.joy.entity;

import javax.persistence.Entity;

/**
 * Created by joybar on 2018/2/5.
 */

@Entity
public class ConstellationBroadcast extends BaseData {
    private long publishTimestamp;
    private long startValidTimestamp;
    private long endValidTimestamp;
    private String BroadcastMessage;

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
        return BroadcastMessage;
    }

    public void setBroadcastMessage(String broadcastMessage) {
        BroadcastMessage = broadcastMessage;
    }
}
