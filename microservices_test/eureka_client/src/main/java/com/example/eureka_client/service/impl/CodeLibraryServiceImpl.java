package com.example.eureka_client.service.impl;

import com.example.eureka_client.service.CodeLibraryService;
import com.spring.dao.mapper.CodeLibraryMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeLibraryServiceImpl  implements CodeLibraryService {
//    public class CodeLibraryServiceImpl extends ServiceImpl<CodeLibraryMapper, CodeLibrary>  implements CodeLibraryService {

    @Autowired
    CodeLibraryMapper codeLibraryMapper;

    @Override
    public String getCodeNameByCodeNoAndItemNo(String codeNo, String itemNo) {
        if (StringUtils.isBlank(codeNo)||StringUtils.isBlank(itemNo)){
            return "";
        }
        return codeLibraryMapper.getCodeNameByCodeNoAndItemNo(codeNo,itemNo);
    }
}