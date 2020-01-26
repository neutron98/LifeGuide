package cmu.youchun.lifeguide.service.impl;

import cmu.youchun.lifeguide.dao.RecommendDOMapper;
import cmu.youchun.lifeguide.model.RecommendDO;
import cmu.youchun.lifeguide.service.RecommendRecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RecommendRecallServiceImpl implements RecommendRecallService {

    @Autowired
    private RecommendDOMapper recommendDOMapper;



    @Override
    public List<Integer> recall(Integer userId){
        RecommendDO recommendDO = recommendDOMapper.selectByPrimaryKey(userId);

        if(recommendDO == null){
            recommendDO = recommendDOMapper.selectByPrimaryKey(9999999);
        }
        String[] shopIdArr = recommendDO.getShopIdList().split(",");
        List<Integer> shopIdList = new ArrayList<>();
        for(int i = 0; i < shopIdArr.length; i++) {
            shopIdList.add(Integer.valueOf(shopIdArr[i]));
        }
        return shopIdList;
    }

}
