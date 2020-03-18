package com.scould.product.service;

import com.scloud.product.common.DecreaseStockInput;
import com.scloud.product.common.ProductInfoOutput;
import com.scould.product.ProductApplicationTests;
import com.scould.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> productInfoOutputList = productService.findList(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(productInfoOutputList.size() > 0);
    }

    @Test
    public void decreaseStock() {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("164103465734242707", 2);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}