package cmu.youchun.lifeguide.service.impl;


import cmu.youchun.lifeguide.model.ShopModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceImplTest {
    @Autowired
    ShopServiceImpl shopService;
    private static BigDecimal LATITUDE = new BigDecimal(40);
    private static BigDecimal LONGITUDE = new BigDecimal(-73);
    private static Integer EXISTING_USERID = 148;

    @Test
    public void recommend() {
    }

    @Test
    public void recommendML() {
        List<ShopModel> shopModelList = shopService.recommendML(LATITUDE, LONGITUDE, EXISTING_USERID);
        Assert.assertNotEquals(0, shopModelList.size());

    }

    @Test
    public void search() {
    }

    @Test
    public void searchES() {
    }
}
