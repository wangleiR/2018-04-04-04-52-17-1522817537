package com.tw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 2018/4/9.
 */
public class Display {
    //主页面的显示内容
    public void displayhome(){
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
        System.out.println("请输入你的选择（1～3)");
    }
    //选择1
    public void displayWhenSelectOne(){
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }
    //选择1 格式错误
    public void displayWhenSelectOneFormatError(){
        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
    }
    //选择1 格式正确 返回
    public void displayWhenSelectOneFormatCorrectReturn(String studentName){
        System.out.println("学生"+studentName+"的成绩被添加");
    }
    //选择2
    public void displayWhenSelectTwo(){
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }
    //选择2 格式错误
    public void displayWhenSelectTwoFormatError(){
        System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }
    //选择2 格式正确 返回
    public void displayWhenSelectTwoFormatCorrectReturn(List<Info> list){

        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================");
        List<Integer> all = new ArrayList<>();

        List<String> className = getClassName();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> score = new ArrayList<>();
            for (int j= 0;j < className.size();j++){
                score.add((int)list.get(i).getClasses().get(className.get(j)));
            }
            int count = score.stream().reduce(0, (sum, element) -> sum + element);
            System.out.print(list.get(i).getName()+"/");
            score.stream().map(e -> e+"/").forEach(System.out::print);
            System.out.println(count/4.00+"/"+count);
            all.add(count);
        }
        System.out.println("========================");
        System.out.println("全班总分平均数："+all.stream().mapToInt((x) -> x).summaryStatistics().getAverage());
        System.out.println("全班总分中位数："+(all.get(all.size()/2)+all.get(all.size()/2-1))/2.0);
    }

    public List<String> getClassName(){
        List<String> className = new ArrayList<>();
        className.add("数学");
        className.add("语文");
        className.add("英语");
        className.add("编程");
        return className;

    }
}
//        张三,101,数学:75,语文:95,英语:80,编程:80
//        李四,102,数学:85,语文:80,英语:70,编程:90