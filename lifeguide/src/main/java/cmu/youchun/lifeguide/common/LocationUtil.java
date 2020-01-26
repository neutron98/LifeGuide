package cmu.youchun.lifeguide.common;

import java.math.BigDecimal;

    public class LocationUtil {

        private static final BigDecimal EARTH_RADIUS = new BigDecimal(6378.137);
        private static final BigDecimal MATH_PI = new BigDecimal(Math.PI);
        private static final BigDecimal FT_FACTOR = new BigDecimal(3280.84);
        /**Calculate arc length**/
        private static BigDecimal getRad(BigDecimal big){
            return big.multiply(MATH_PI).divide(new BigDecimal(180.0), BigDecimal.ROUND_DOWN);
        }


        public static Integer getDistance(BigDecimal lat1,BigDecimal lng1,
                                                     BigDecimal lat2,BigDecimal lng2 ){

            BigDecimal radLat1 = getRad(lat1);
            BigDecimal radLat2 = getRad(lat2);
            BigDecimal a = radLat1.subtract(radLat2);
            BigDecimal b = getRad(lng1).subtract(getRad(lng2));

            Double sinA = Math.sin(a.doubleValue()/2);
            Double sinB = Math.sin(b.doubleValue()/2);
            Double cosA = radLat1.doubleValue();
            Double cosB = radLat2.doubleValue();

            Double obj = 2 * Math.asin(Math.sqrt(Math.pow(sinA,2) + Math.cos(cosA)*Math.cos(cosB)*Math.pow(sinB, 2)));
            BigDecimal s = new BigDecimal(obj);
            s = s.multiply(EARTH_RADIUS).multiply(FT_FACTOR);
            return Integer.valueOf(s.intValue());
        }



}
