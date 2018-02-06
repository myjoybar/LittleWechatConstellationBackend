package com.joy.entity.enumconfig;

/**
 * Created by joybar on 2018/2/5.
 */
public enum ConstellationConfig {

    Aries(1,"Aries"),
    Taurus(2,"Taurus"),
    Gemini(3,"Gemini"),
    Cancer(4,"Cancer"),
    Leo(5,"Leo"),
    Virgo(6,"Virgo"),
    Libra(7,"Libra"),
    Scorpio(8,"Scorpio"),
    Sagittarius(9,"Sagittarius"),
    Capricorn(10,"Capricorn"),
    Aquarius(11,"Aquarius"),
    Pisces(12,"Pisces"),
    ;

    private int constellationCode;
    private String constellationName;

    ConstellationConfig(int constellationCode, String constellationName) {
        this.constellationCode = constellationCode;
        this.constellationName = constellationName;
    }

    public int getConstellationCode() {
        return constellationCode;
    }

    public void setConstellationCode(int constellationCode) {
        this.constellationCode = constellationCode;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }
}
