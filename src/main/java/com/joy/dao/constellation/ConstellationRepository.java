package com.joy.dao.constellation;

import com.joy.entity.Constellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by joybar on 2018/2/5.
 */
public interface ConstellationRepository extends JpaRepository<Constellation,Long>,JpaSpecificationExecutor<Constellation> {

    List<Constellation> findByConstellationName(String constellationName);
    List<Constellation> findByConstellationType(Integer constellationType);
}
