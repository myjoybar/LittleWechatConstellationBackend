package com.joy.controller;

import com.joy.entity.ConstellationBroadcast;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import com.joy.services.constellation.ConstellationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by joybar on 2018/2/6.
 */
@RestController
public class ConstellationController {

    public static String TAG = "ConstellationController";

    @Autowired
    private ConstellationServiceImpl constellationService;


    // http://106.14.139.72:8221/constellation/say
    // http://localhost:8221/constellation/say
    @GetMapping(value = "/say")
    public BaseResultInfo say() {
        return new SuccessResult( "hello");
    }

    //http://localhost:8221/constellation/test
    @GetMapping(value = "/test")
    public String test() {
        return constellationService.test();
    }


   //  http://localhost:8222/constellation/addConstellationBroadcast?constellationType=1&broadcastMessage=2018-01-22有人可能觉得你在做白日梦，脑袋云里雾里。你现在的某个梦想也许是白日梦吧，但并不代表你不能实现它。制定切实的计划，白日梦也能成真。今天就开始踏出第一步&startValidTimestamp=1518006481000&endValidTimestamp=1518006433000
    @PostMapping(value = "/addConstellationBroadcast", produces = "application/json; charset=utf-8")
    public BaseResultInfo articleConstellationBroadcast(@RequestParam("constellationType") Integer constellationType,
                                     @RequestParam("startValidTimestamp") Long startValidTimestamp,
                                     @RequestParam("endValidTimestamp") Long endValidTimestamp,
                                     @RequestParam("broadcastMessage") String broadcastMessage) throws UnsupportedEncodingException {

        return constellationService.addConstellationBroadcast(constellationType,broadcastMessage,startValidTimestamp,endValidTimestamp);
    }

  //  http://localhost:8222/constellation/findallbroadcast?page=0&size=5&constellationType=1&sortDirection=0
    @RequestMapping(value = "/findallbroadcast", method = {RequestMethod.GET})
    public BaseResultInfo findAllBroadcastsByConstellationType(ModelMap modelMap,
                                         @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                         @RequestParam(value = "constellationType", defaultValue = "0") Integer constellationType,
                                         @RequestParam(value = "sortDirection", defaultValue = "0") Integer sortDirection
    ) {

        Page<ConstellationBroadcast> datas = constellationService.findAllBroadcastsByConstellationType(pageNumber, pageSize, constellationType, sortDirection);
        modelMap.addAttribute("datas", datas);
        SuccessResult resultInfo = new SuccessResult( datas);
        return resultInfo;
    }


}
