package cmu.youchun.lifeguide.service;

import java.util.List;

public interface RecommendRecallService {
    /**
     * Recall a list of shop id for a user
     * @param userId
     * @return a shopIdList
     */
    List<Integer> recall(Integer userId);
}
