package com.scould.product.service;

import com.scloud.product.common.DecreaseStockInput;
import com.scloud.product.common.ProductInfoOutput;
import com.scould.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productInfoList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productInfoList);

    /**
     * 口库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
