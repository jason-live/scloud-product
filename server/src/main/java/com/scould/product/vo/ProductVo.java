package com.scould.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品对象
 */
@Data
public class ProductVo {

    /**
     * 品类名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 品类类型
     */
    @JsonProperty("type")
    private Integer categoryType;

    /**
     * 商品详情列表
     */
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
