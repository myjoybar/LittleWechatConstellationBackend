package com.joy.dao.constellation;

import com.joy.entity.ConstellationBroadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface ConstellationRepository extends JpaRepository<ConstellationBroadcast,Long>,JpaSpecificationExecutor<ConstellationBroadcast> {

    List<ConstellationBroadcast> findAllBroadcastsByConstellationName(String constellationName);
    List<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer constellationType);
}
