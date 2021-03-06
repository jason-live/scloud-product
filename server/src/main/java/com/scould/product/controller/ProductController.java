package com.scould.product.controller;

import com.scloud.product.common.DecreaseStockInput;
import com.scloud.product.common.ProductInfoOutput;
import com.scould.product.entity.ProductCategory;
import com.scould.product.entity.ProductInfo;
import com.scould.product.service.CategoryService;
import com.scould.product.service.ProductService;
import com.scould.product.utils.ResultVoUtil;
import com.scould.product.vo.ProductInfoVo;
import com.scould.product.vo.ProductVo;
import com.scould.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo<ProductVo> list() {
        // Todo
        /**
         * 查询所有在架商品
         */
        List<ProductInfo> productInfoList = productService.findUpAll();

        /**
         * 获取类目type列表
         */
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        /**
         * 从数据库查询类目
         */
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /**
         * 数据构造
         */
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVoUtil.success(productVoList);
    }

    /**
     * 获取商品列表（给订单服务用的）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /**
     * 扣库存
     * @param decreaseStockInputList
     * @return
     */
    @PostMapping("/decreaseStock")
    public String decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
        return "ok";
    }
}
