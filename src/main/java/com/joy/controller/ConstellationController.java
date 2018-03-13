package com.joy.controller;

import com.joy.entity.ConstellationBroadcast;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.SuccessResult;
import com.joy.services.constellation.ConstellationServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by joybar on 2018/2/6.
 * API:https://localhost:8221/constellation/swagger-ui.html
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
        return new SuccessResult("hello");
    }

    //http://localhost:8221/constellation/test
    @GetMapping(value = "/test")
    public String test() {
        return constellationService.test();
    }

    //  http://localhost:8222/constellation/addConstellationBroadcast?constellationType=1&broadcastMessage=2018-01-22有人可能觉得你在做白日梦，脑袋云里雾里。你现在的某个梦想也许是白日梦吧，但并不代表你不能实现它。制定切实的计划，白日梦也能成真。今天就开始踏出第一步&startValidTimestamp=1518006481000&endValidTimestamp=1518006433000
    @ApiOperation(value = "添加Broadcast信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "broadcastMessage", value = "消息", required = true, paramType = "body", dataType = "String"),
            @ApiImplicitParam(name = "constellationType", value = "星座类型", required = true, paramType = "body", dataType = "Integer"),
            @ApiImplicitParam(name = "publishTimestamp", value = "发布时间戳", required = true, paramType = "body", dataType = "Long")
    })
    public BaseResultInfo articleConstellationBroadcast(@RequestParam("constellationType") Integer constellationType,
                                                        @RequestParam("publishTimestamp") Long publishTimestamp,
                                                        @RequestParam("broadcastMessage") String broadcastMessage) throws UnsupportedEncodingException {

        return constellationService.addConstellationBroadcast(constellationType, broadcastMessage, publishTimestamp);
    }

    //https://localhost:8221/constellation/deleteBroadcastById?id=2
    @ApiOperation(value = "删除Broadcast", notes = "根据ID删除")
    @ApiImplicitParam(name = "id", value = "Broadcast id", required = true,paramType = "path", dataType = "Long")
    @PostMapping(value = "/deleteBroadcastById")
    public BaseResultInfo deleteBroadcastById(@RequestParam("id") Long id) {
        return constellationService.deleteConstellationBroadcastById(id);
    }

    @ApiOperation(value = "更新Broadcast", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Broadcast id", required = true, paramType = "body", dataType = "Long"),
            @ApiImplicitParam(name = "constellationType", value = "星座类型", required = true, paramType = "body", dataType = "Integer"),
            @ApiImplicitParam(name = "broadcastMessage", value = "消息", required = true, paramType = "body", dataType = "String"),
            @ApiImplicitParam(name = "publishTimestamp", value = "发布时间戳", required = true, paramType = "body", dataType = "Long")
    })
    @PostMapping(value = "/updateBroadcast")
    public BaseResultInfo updateConstellationBroadcast(
            @RequestParam("id") Long id,
            @RequestParam("constellationType") Integer constellationType,
            @RequestParam("broadcastMessage") String broadcastMessage,
            @RequestParam("publishTimestamp") Long publishTimestamp) {
        return constellationService.updateConstellationBroadcast(id, constellationType, broadcastMessage, publishTimestamp);

    }


    //  http://localhost:8222/constellation/findallbroadcast?pageNumber=0&pageSize=5&constellationType=1&sortDirection=0
    @ApiOperation(value = "获取列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页数", required = true, paramType = "body",defaultValue="0",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, paramType = "body", defaultValue="5",dataType = "Integer"),
            @ApiImplicitParam(name = "constellationType", value = "星座类型(1-12,0表示all)", required = true, paramType = "body", defaultValue="0",dataType = "Integer"),
            @ApiImplicitParam(name = "sortDirection", value = "排序（0，1）", required = true, paramType = "body", defaultValue="0",dataType = "Integer")
    })
    @RequestMapping(value = "/findallbroadcast", method = {RequestMethod.GET})
    public BaseResultInfo findAllBroadcastsByConstellationType(
                                                               @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "constellationType", defaultValue = "0") Integer constellationType,
                                                               @RequestParam(value = "sortDirection", defaultValue = "0") Integer sortDirection
    ) {
        Page<ConstellationBroadcast> datas = constellationService.findAllBroadcastsByConstellationType(pageNumber, pageSize, constellationType, sortDirection);
        SuccessResult resultInfo = new SuccessResult(datas);
        return resultInfo;
    }

}
