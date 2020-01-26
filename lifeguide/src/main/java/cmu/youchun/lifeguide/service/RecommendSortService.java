package cmu.youchun.lifeguide.service;

import java.util.List;

public interface RecommendSortService {
    List<Integer> sort(List<Integer> shopIdList, Integer userId);
}
