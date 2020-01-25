package cmu.youchun.lifeguide.service;

import cmu.youchun.lifeguide.BusinessException;
import cmu.youchun.lifeguide.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

    Integer countAll();

}
