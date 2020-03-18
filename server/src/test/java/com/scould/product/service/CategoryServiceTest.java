package com.scould.product.service;

import com.scould.product.ProductApplicationTests;
import com.scould.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class CategoryServiceTest extends ProductApplicationTests {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(productCategoryList.size() > 0);
    }
}