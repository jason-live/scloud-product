package com.scloud.product.client;

import com.scloud.product.common.DecreaseStockInput;
import com.scloud.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {
    /**
     * 获取商品列表（给订单服务用的）
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     * @return
     */
    @PostMapping("/product/decreaseStock")
    String decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    @Component
    static class ProductClientFallback implements ProductClient {

        /**
         * 获取商品列表（给订单服务用的）
         *
         * @param productIdList
         * @return
         */
        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        /**
         * 扣库存
         *
         * @param decreaseStockInputList
         * @return
         */
        @Override
        public String decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
            return null;
        }
    }
}
