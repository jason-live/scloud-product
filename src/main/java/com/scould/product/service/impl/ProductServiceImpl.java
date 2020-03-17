package com.scould.product.service.impl;

import com.scould.product.dto.CartDto;
import com.scould.product.entity.ProductInfo;
import com.scould.product.enums.ProductStatusEnum;
import com.scould.product.enums.ResultEnum;
import com.scould.product.exception.ProductException;
import com.scould.product.repository.ProductInfoRepository;
import com.scould.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    /**
     * 查询商品列表
     * @param productInfoList
     * @return
     */
    @Override
    public List<ProductInfo> findList(List<String> productInfoList) {
        return productInfoRepository.findByProductIdIn(productInfoList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto: cartDtoList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDto.getProductId());
            // 商品不存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            // 库存不足
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
