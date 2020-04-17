package com.example.eureka_client.xdclass.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description : 数据元素是原始集合，如list、Set、Map
 * 生成流，可以是串行流Stream(常用)或并行流parallelStream(不常用)
 * 中间操作，可以是排序，聚合，过滤，转换等
 * 终端操作，很多流操作本身就会返回一个流，所以多个操作可以直接连接起来，
 * 最后统一进行收集
 * @author xinjunan
 * @date 2020/2/13 17:34
 */

public class Main {
    public static void main(String[] args) {
        try {
            //1、
            List<String> list = Arrays.asList("springboot教程","微服务教程","并发教程","redis教程","消息队列教程");
            List<String> resultList = list.stream().map(obj->"在小滴课堂学习,"+obj)
            .collect(Collectors.toList());

            System.out.println(resultList);
        //2、
            List<User> userList = Arrays.asList(new User(1,"小东1","123"),new User(2,"小东2","123"),new User(3,"小东3","123"),new User(4,"小东4","123"));
            List<UserDTO>  userDTOList = userList.stream().map(obj->{
                UserDTO userDTO = new UserDTO(obj.getId(),obj.getName());
                return userDTO;
            }).collect(Collectors.toList());

            System.out.println("userDTOList:"+userDTOList);

            //筛选
            List<String> resultList2 = list.stream().filter(obj->obj.length()>5)
            .collect(Collectors.toList());
            System.out.println("筛选list长度超过5的字符串："+resultList2);

            List<String> list2 = Arrays.asList("a","微服务教程","aa","aaa","aaaa");
            //升序1
            List<String> resultList3 = list2.stream().sorted().collect(Collectors.toList());
            System.out.println("升序1："+resultList3);
            //升序2
            List<String> resultList4 = list2.stream().sorted(Comparator.comparing(obj->obj.length())).collect(Collectors.toList());
            System.out.println("升序2："+resultList4);

            //降序
            List<String> resultList5 = list2.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
            System.out.println("降序："+resultList5);

            //降序，获取前面几个 limit 截取
            List<String> resultList6 = list2.stream().sorted(Comparator.comparing(String::length).reversed()).limit(2).collect(Collectors.toList());
            System.out.println("降序,截取："+resultList6);

            //代码意思：所有的字符串长度都大于5的则返回true 否则返回false
            boolean flag1 = list.stream().allMatch(obj->obj.length()>5);
            System.out.println("字符串长度都大于5的结果："+flag1);

            //代码意思：只要有一个字符串长度大于5的则返回true 否则返回false
            boolean flag2 = list.stream().anyMatch(obj->obj.length()>5);
            System.out.println("只要有一个字符串长度大于5的结果："+flag2);

            //最大

            //CopyOnWriteArrayList线程安全，并行流parallelStream线程不安全
            List list3 = new CopyOnWriteArrayList();
            IntStream.range(0,100).parallel().forEach(list3::add);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

