package com.example.eureka_client.service;

import org.apache.ibatis.annotations.Param;

public interface CodeLibraryService {

    String getCodeNameByCodeNoAndItemNo(@Param("codeNo")String codeNo, @Param("itemNo")String itemNo);

}
