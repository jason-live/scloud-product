package com.scould.product.service.impl;

import com.scould.product.entity.ProductInfo;
import com.scould.product.enums.ProductStatusEnum;
import com.scould.product.repository.ProductInfoRepository;
import com.scould.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
