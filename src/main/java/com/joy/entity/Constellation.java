package com.joy.entity;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public class Constellation extends BaseData{

    private String ConstellationName;
    private List<ConstellationBroadcast> constellationBroadcastList;

    public String getConstellationName() {
        return ConstellationName;
    }

    public void setConstellationName(String constellationName) {
        ConstellationName = constellationName;
    }

    public List<ConstellationBroadcast> getConstellationBroadcastList() {
        return constellationBroadcastList;
    }

    public void setConstellationBroadcastList(List<ConstellationBroadcast> constellationBroadcastList) {
        this.constellationBroadcastList = constellationBroadcastList;
    }
}
