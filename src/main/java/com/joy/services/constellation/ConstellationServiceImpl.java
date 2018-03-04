package com.joy.services.constellation;

import com.joy.constant.Constant;
import com.joy.dao.constellation.ConstellationRepository;
import com.joy.entity.ConstellationBroadcast;
import com.joy.result.ConstantError;
import com.joy.result.data.BaseResultInfo;
import com.joy.result.data.ErrorResult;
import com.joy.result.data.SuccessResult;
import com.joy.utils.NumberUtils;
import com.joy.utils.SOUtils;
import com.joy.utils.StringUtils;
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


    /**
     * add
     * @param constellationType
     * @param broadcastMessage
     * @param publishTimestamp
     * @param startValidTimestamp
     * @param endValidTimestamp
     * @return
     */
    @Override
    public BaseResultInfo addConstellationBroadcast(Integer constellationType, String broadcastMessage, long publishTimestamp, long startValidTimestamp, long endValidTimestamp) {
        BaseResultInfo baseResultInfo = null;
        if (constellationType < Constant.CONSTELLATION_Aries || constellationType > Constant.CONSTELLATION_Pisces) {
            ErrorResult errorResult = new ErrorResult(ConstantError.ERROR_CONSTELLATION_TYPE.getErrorCode(), ConstantError.ERROR_CONSTELLATION_TYPE.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }
        if (StringUtils.isEmpty(broadcastMessage)) {
            ErrorResult errorResult = new ErrorResult(ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY.getErrorCode(), ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }
        if (String.valueOf(publishTimestamp).length() != 13 || String.valueOf(startValidTimestamp).length() != 13 || String.valueOf(endValidTimestamp).length() != 13) {
            ErrorResult errorResult = new ErrorResult(ConstantError.TIME_STAMP_ERROR.getErrorCode(), ConstantError.TIME_STAMP_ERROR.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }
        ConstellationBroadcast constellationBroadcast = new ConstellationBroadcast();
        constellationBroadcast.setConstellationType(constellationType);
        constellationBroadcast.setConstellationName(Constant.CONSTELLATION_MAP.get(constellationType));
        constellationBroadcast.setBroadcastMessage(broadcastMessage);
        constellationBroadcast.setStartValidTimestamp(startValidTimestamp);
        constellationBroadcast.setEndValidTimestamp(endValidTimestamp);
        constellationBroadcast.setPublishTimestamp(publishTimestamp);

        ConstellationBroadcast constellationBroadcastResult = constellationRepository.save(constellationBroadcast);
        if (null == constellationBroadcastResult) {
            ErrorResult errorResult = new ErrorResult(ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_SAVE_OCCURS_ERROR.getErrorCode(), ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_SAVE_OCCURS_ERROR.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        } else {
            baseResultInfo = new SuccessResult(constellationBroadcastResult);
            return baseResultInfo;
        }

    }

    /**
     * delete
     * @param id
     * @return
     */
    @Override
    public BaseResultInfo deleteConstellationBroadcastById(Long id) {
        try {
            constellationRepository.delete(id);
            return new SuccessResult("delete success");
        } catch (Exception e) {
            SOUtils.print("deleteConstellationBroadcastById error:" + e.getMessage());
        }
        return new ErrorResult("delete fail");
    }

    /**
     * update
     * @param id
     * @param constellationType
     * @param broadcastMessage
     * @param publishTimestamp
     * @param startValidTimestamp
     * @param endValidTimestamp
     * @return
     */
    @Override
    public BaseResultInfo updateConstellationBroadcast(Long id, Integer constellationType, String broadcastMessage, long publishTimestamp, long startValidTimestamp, long endValidTimestamp) {
        BaseResultInfo baseResultInfo = null;
        SOUtils.print("constellationRepository.exists(id)" + constellationRepository.exists(id));
        if (constellationRepository.exists(id)) {
            ConstellationBroadcast saveBroadcast = new ConstellationBroadcast();
            if (constellationType < Constant.CONSTELLATION_Aries || constellationType > Constant.CONSTELLATION_Pisces) {
                ErrorResult errorResult = new ErrorResult(ConstantError.ERROR_CONSTELLATION_TYPE.getErrorCode(), ConstantError.ERROR_CONSTELLATION_TYPE.getErrorMsg());
                baseResultInfo = new ErrorResult(errorResult);
                return baseResultInfo;
            }
            if (StringUtils.isEmpty(broadcastMessage)) {
                ErrorResult errorResult = new ErrorResult(ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY.getErrorCode(), ConstantError.ERROR_CONSTELLATION_BROADCAST_MSG_EMPTY.getErrorMsg());
                baseResultInfo = new ErrorResult(errorResult);
                return baseResultInfo;
            }
            if (String.valueOf(publishTimestamp).length() != 13 || String.valueOf(startValidTimestamp).length() != 13 || String.valueOf(endValidTimestamp).length() != 13) {
                ErrorResult errorResult = new ErrorResult(ConstantError.TIME_STAMP_ERROR.getErrorCode(), ConstantError.TIME_STAMP_ERROR.getErrorMsg());
                baseResultInfo = new ErrorResult(errorResult);
                return baseResultInfo;
            }
            saveBroadcast.setId(id);
            saveBroadcast.setConstellationType(constellationType);
            saveBroadcast.setBroadcastMessage(broadcastMessage);
            saveBroadcast.setPublishTimestamp(publishTimestamp);
            saveBroadcast.setStartValidTimestamp(startValidTimestamp);
            saveBroadcast.setEndValidTimestamp(endValidTimestamp);
            constellationRepository.save(saveBroadcast);
            return new SuccessResult(constellationRepository.save(saveBroadcast));
        }else{
            ErrorResult errorResult = new ErrorResult(ConstantError.NO_CONSTELLATION_BROADCAST_IN_DB_ERROR.getErrorCode(), ConstantError.NO_CONSTELLATION_BROADCAST_IN_DB_ERROR.getErrorMsg());
            baseResultInfo = new ErrorResult(errorResult);
            return baseResultInfo;
        }

    }


    /**
     * 获取列表
     * @param pageNumber
     * @param pageSize
     * @param constellationType
     * @param sortDirection
     * @return
     */
    @Override
    public Page<ConstellationBroadcast> findAllBroadcastsByConstellationType(Integer pageNumber, Integer pageSize, final Integer constellationType, int sortDirection) {

        Pageable pageable = null;
        if (sortDirection == Constant.ARTICLE_SORT_DIRECTION_DESC) {
            pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.DESC, "id");
        } else {
            pageable = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "id");
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
