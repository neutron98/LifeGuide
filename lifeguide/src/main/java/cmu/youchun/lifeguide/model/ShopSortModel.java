package cmu.youchun.lifeguide.model;

import lombok.Data;

import java.util.Objects;

@Data
public class ShopSortModel implements Comparable<ShopSortModel>{
    private Integer shopId;
    private double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopSortModel that = (ShopSortModel) o;
        return shopId.equals(that.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId);
    }

    @Override
    public int compareTo(ShopSortModel o) {
        return Double.compare(o.getScore(), score);
    }
}
