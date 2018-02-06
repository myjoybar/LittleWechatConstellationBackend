package com.joy.services.constellation;

import com.joy.entity.ConstellationBroadcast;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface ConstellationService {

    List<ConstellationBroadcast> findAllBroadcastsByConstellationName(String constellationName);

    List<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer constellationType);

    Page<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer page, Integer size, final Integer constellationType, int sortDirection);
}
