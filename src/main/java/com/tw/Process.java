package com.tw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/4/9.
 */
public class Process {

    private static Display dp = new Display();

    //1选项时的处理过程
    public void oneProcess(Scanner sc,List<Info> infoList){
        dp.displayWhenSelectOne();
        do {
            try {
                HashMap<String,Integer> myMap = new HashMap<>();
                Info info = new Info();
                String str = sc.nextLine().trim();
                String[] s = str.split(",");
                info.setName(s[0]);
                info.setNum(Integer.parseInt(s[1].trim()));
                for (int i = 2; i < s.length; i++) {
                    String[] m = s[i].split(":");
                    myMap.put(m[0], Integer.parseInt(m[1].trim()));
                }
                info.setClasses(myMap);
                infoList.add(info);
                dp.displayWhenSelectOneFormatCorrectReturn(info.getName());
                dp.displayhome();
                return;
            } catch (Exception e) {
                dp.displayWhenSelectOneFormatError();
            }
        }while(true);

    }

    //2选项时的处理过程
    public void twoProcess(Scanner sc,List<Info> infoList){
        dp.displayWhenSelectTwo();
        do {
            try {
                String str = sc.nextLine();
                String[] numList = str.split(",");
                infoList.stream().map(n-> Arrays.stream(numList).map(e-> Integer.parseInt(e) == n.getNum())).collect(Collectors.toList());
                dp.displayWhenSelectTwoFormatCorrectReturn(infoList);
                dp.displayhome();
                return;
            } catch (Exception e) {
                dp.displayWhenSelectTwoFormatError();
            }
        }while(true);
    }


}
