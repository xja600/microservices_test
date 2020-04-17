package com.example.eureka_client.xdclass.jdk.jdk8.lambda;

import com.example.eureka_client.xdclass.jdk.jdk8.optional.Student;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Description : jdk8之前，java不支持函数式编程，所谓的函数编程，即可理解是将一个函数(行为)
 * 作为一个参数进行传递，面向对象编程是对数据的抽象，而函数式编程则是对行为的抽象(将行为作为一个参数进行传递)
 * lambda 表达式的实现方式的本质是以  匿名内部类的方式进行实现的
 * 好处：重构现有的代码，更高的开始效率，尤其是集合Collection操作的时候。
 *
 * 静态方法：方法引用与构造函数引用
 * 实例方法：Instance::methodName
 * 构造函数：类名::new
 * ClassName::methodName
 * @author xinjunan
 * @date 2020/2/12 17:34
 */

public class Main {
    public static void main(String[] args) {
        try {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println("非函数式编程");
               }
           }).start();

           //上面的代码与下面的是一样的效果
           new Thread(()-> System.out.println("函数式编程")).start();

           //排序
            //使用前
            List<String> list1 = Arrays.asList("aa","bb","cc");

            Collections.sort(list1, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return b.compareTo(a);
                }
            });

            for(String string :list1){
                System.out.println("非函数式编程："+string);
            }
            //使用后
            List<String> list2 = Arrays.asList("aa","bb","cc");
            Collections.sort(list2,(a,b)->b.compareTo(a));

            for(String string :list2){
                System.out.println("函数式编程："+string);
            }

            //自定义 lambda表达式
            //正常用法
            System.out.println("正常用法:"+operate(20,5,(Integer x,Integer y)->{
                return x*y;
            }));
           //用 lambda表达式
            System.out.println("用 lambda表达式:"+operate(20,5,(x, y)->x*y));

            test("测试111",new FunctionObj());
            //常规使用
            Function<Integer,Integer> func = p->p*100;
            System.out.println(func.apply(10));


            //静态方法
            Function<String,Integer> fun = Integer::parseInt;
            Integer value = fun.apply("1024");
            System.out.println("静态方法："+value);

            //构造非静态函数引用
            String content = "测试123";
            Function<Integer,String> fun2 = content::substring;
            String result = fun2.apply(1);
            System.out.println("构造非静态函数引用："+result);

            //构造函数引用，多个参数
            BiFunction<String,Integer,User> biFunction = User::new;
            User user1 = biFunction.apply("小滴课堂",2);
            System.out.println("构造函数引用，多个参数："+user1);

           //构造函数引用，单个参数
            Function<String,User> function = User::new;
            User user2 = function.apply("小滴课堂");
            System.out.println("构造函数引用，单个参数："+user2);

            //将函数表达式传过去
            sayHello(String::toUpperCase,"xdclass.net");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Integer operate(Integer x,Integer y,OperFunction<Integer,Integer> of){

        return  of.operate(x,y);
    }
    public static void test(String inputStr, Function functionObj){
        System.out.println(functionObj.apply(inputStr));
    }

private static void sayHello(Function<String,String> func,String param){
        String result = func.apply(param);
    System.out.println("将函数表达式传过去："+result);
}
}

