//package com.spring.dao.config;
//
//import com.slabs.pushdata.service.SLAssetInfoService2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
///**
// * @author MG01972
// * @date 2019-09-27 14:46
// */
//public class test implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
//    SLAssetInfoService2 assetInfoService;
//
//    public void test1() throws Exception{
//        assetInfoService.pushDataToBIByStatus("02");
//    }
//
//    public static void main(String[] args) {
//        test test = new test();
//        try {
//            test.test1();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        test test = new test();
//        try {
//            System.out.println("----------------1------------------------");
//            test.test1();
//            System.out.println("----------------2------------------------");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
