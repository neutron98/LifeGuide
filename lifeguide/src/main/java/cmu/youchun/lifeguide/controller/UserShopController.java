package cmu.youchun.lifeguide.controller;

import cmu.youchun.lifeguide.BusinessException;
import cmu.youchun.lifeguide.common.CommonRes;
import cmu.youchun.lifeguide.common.EmBusinessError;
import cmu.youchun.lifeguide.model.CategoryModel;
import cmu.youchun.lifeguide.model.ShopModel;
import cmu.youchun.lifeguide.service.CategoryService;
import cmu.youchun.lifeguide.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/shop")
@RequestMapping("/shop")
public class UserShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/recommend")
    @ResponseBody
    public CommonRes recommend(@RequestParam("longitude")BigDecimal longitude,
                               @RequestParam("latitude") BigDecimal latitude) throws BusinessException {
        if (longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return CommonRes.create(shopModelList);
    }

    //Search Service V1.0
    @RequestMapping("/search")
    @ResponseBody
    public CommonRes search(@RequestParam(name="longitude")BigDecimal longitude,
                            @RequestParam(name="latitude")BigDecimal latitude,
                            @RequestParam(name="keyword")String keyword,
                            @RequestParam(name="orderby",required = false)Integer orderby,
                            @RequestParam(name="categoryId",required = false)Integer categoryId,
                            @RequestParam(name="tags",required = false)String tags) throws BusinessException, IOException {
        if(StringUtils.isEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = (List<ShopModel>) shopService.searchES(longitude,latitude,keyword,orderby,categoryId,tags).get("shop");
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String,Object>> tagsAggregation = shopService.searchGroupByTags(keyword,categoryId,tags);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        resMap.put("category",categoryModelList);
        resMap.put("tags",tagsAggregation);
        return CommonRes.create(resMap);

    }

}
