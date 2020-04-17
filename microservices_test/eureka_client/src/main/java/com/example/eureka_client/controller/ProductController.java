package com.example.eureka_client.controller;

import com.example.eureka_client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    /**
     * 根据id查找商品详情
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id){
        return productService.findById(id);
    }
}
