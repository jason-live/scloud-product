package com.scould.product.service;

import com.scould.product.dto.CartDto;
import com.scould.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productInfoList
     * @return
     */
    List<ProductInfo> findList(List<String> productInfoList);

    /**
     * 口库存
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);
}
