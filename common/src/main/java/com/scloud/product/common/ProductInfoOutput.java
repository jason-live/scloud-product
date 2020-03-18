package com.scloud.product.common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoOutput {
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
