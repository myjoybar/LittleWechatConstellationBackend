package com.joy.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joybar on 2018/2/6.
 */
public class Constant {


    public final static int CONSTELLATION_Aries = 1;
    public final static int CONSTELLATION_Taurus = 2;
    public final static int CONSTELLATION_Gemini = 3;
    public final static int CONSTELLATION_Cancer = 4;
    public final static int CONSTELLATION_Leo = 5;
    public final static int CONSTELLATION_Virgo = 6;
    public final static int CONSTELLATION_Libra = 7;
    public final static int CONSTELLATION_Scorpio = 8;
    public final static int CONSTELLATION_Sagittarius = 9;
    public final static int CONSTELLATION_Capricorn = 10;
    public final static int CONSTELLATION_Aquarius = 11;
    public final static int CONSTELLATION_Pisces = 12;

    public static Map<Integer,String>CONSTELLATION_MAP = new HashMap<Integer,String>();

    static {
       CONSTELLATION_MAP.put(CONSTELLATION_Aries,"Aries");
       CONSTELLATION_MAP.put(CONSTELLATION_Taurus,"Taurus");
       CONSTELLATION_MAP.put(CONSTELLATION_Gemini,"Gemini");
       CONSTELLATION_MAP.put(CONSTELLATION_Cancer,"Cancer");
       CONSTELLATION_MAP.put(CONSTELLATION_Leo,"Leo");
       CONSTELLATION_MAP.put(CONSTELLATION_Virgo,"Virgo");
       CONSTELLATION_MAP.put(CONSTELLATION_Libra,"Libra");
       CONSTELLATION_MAP.put(CONSTELLATION_Scorpio,"Scorpio");
       CONSTELLATION_MAP.put(CONSTELLATION_Sagittarius,"Sagittarius");
       CONSTELLATION_MAP.put(CONSTELLATION_Capricorn,"Capricorn");
       CONSTELLATION_MAP.put(CONSTELLATION_Aquarius,"Aquarius");
       CONSTELLATION_MAP.put(CONSTELLATION_Pisces,"Pisces");
    }

    public final static int ARTICLE_SORT_DIRECTION_ASC = 0;
    public final static int ARTICLE_SORT_DIRECTION_DESC = 1;


    public final static int USER_ADMIN_ROLE = 0; //管理员
    public final static int USER_GUEST_ROLE = 1; //普通用户

    public final static int USER_SEX_MALE = 0;
    public final static int USER_SEX_FEMALE = 1;

    public final static int SORT_DIRECTION_ASC = 0;
    public final static int SORT_DIRECTION_DESC = 1;

}
