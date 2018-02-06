package com.joy.services.constellation;

import com.joy.constant.Constant;
import com.joy.dao.constellation.ConstellationRepository;
import com.joy.entity.ConstellationBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2018/2/6.
 */
@Service
public class ConstellationServiceImpl implements ConstellationService {

    @Autowired
    private ConstellationRepository constellationRepository;


    public String test() {
        return "hello";
    }


    @Override
    public List<ConstellationBroadcast> findAllBroadcastsByConstellationName(String constellationName) {
        return null;
    }

    @Override
    public List<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer constellationType) {
        return null;
    }


    @Override
    public Page<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer page, Integer size, final Integer constellationType, int sortDirection){

        Pageable pageable = null;
        if (sortDirection == Constant.ARTICLE_SORT_DIRECTION_DESC) {
            pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        } else {
            pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        }
        Page<ConstellationBroadcast> bookPage = constellationRepository.findAll(new Specification<ConstellationBroadcast>() {
            @Override
            public Predicate toPredicate(Root<ConstellationBroadcast> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                list.add(criteriaBuilder.equal(root.get("constellationType").as(String.class), constellationType));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);
        return bookPage;
    }
}
