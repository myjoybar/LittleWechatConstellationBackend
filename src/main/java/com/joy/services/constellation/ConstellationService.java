package com.joy.services.constellation;

import com.joy.entity.ConstellationBroadcast;
import com.joy.result.data.BaseResultInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface ConstellationService {

    List<ConstellationBroadcast> findAllBroadcastsByConstellationName(String constellationName);

    List<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer constellationType);

    Page<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer page, Integer size, final Integer constellationType, int sortDirection);

    BaseResultInfo addConstellationBroadcast(Integer constellationType, String broadcastMessage,long publishTimestamp,  long startValidTimestamp, long endValidTimestamp);

    BaseResultInfo deleteConstellationBroadcastById(Long id);

    BaseResultInfo updateConstellationBroadcast(Long id,Integer constellationType, String broadcastMessage,long publishTimestamp,  long startValidTimestamp, long endValidTimestamp);



}
