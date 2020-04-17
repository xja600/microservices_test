package com.example.eureka_client.controller;

import com.example.eureka_client.service.CodeLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CodeLibraryController {
//    @Autowired
    @Resource
    private CodeLibraryService codeLibraryService;

    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping(value="getCodeNameByCodeNoAndItemNo", method = RequestMethod.GET)
    @ResponseBody
    public Object list(){
        System.out.println("-----CodeLibraryController.getCodeNameByCodeNoAndItemNo---------------");
        codeLibraryService.getCodeNameByCodeNoAndItemNo("ApplyChannel","00");

        return codeLibraryService.getCodeNameByCodeNoAndItemNo("ApplyChannel","00");
    }

}
