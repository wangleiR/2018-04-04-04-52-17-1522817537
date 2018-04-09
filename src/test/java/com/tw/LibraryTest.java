package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.fest.assertions.api.Assertions.assertThat;

public class LibraryTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    public Info setInfo( String name,int num, HashMap classes){
        Info info = new Info();
        info.setName(name);
        info.setNum(num);
        info.setClasses(classes);
        return info;
    }
    public HashMap<String,Integer> setHashMap(int math,int chi,int eng,int pro){
        HashMap<String,Integer> myMap = new HashMap<>();
        myMap.put("数学",math);
        myMap.put("语文",chi);
        myMap.put("英语",eng);
        myMap.put("编程",pro);
        return myMap;
    }
    @Test
    //测试主页面显示信息
    public void test_homeDisplay_Method() {
        Display display = new Display();
        display.displayhome();
        assertThat(systemOut().endsWith("请输入你的选择（1～3)\n")).isTrue();
    }

    @Test
    //测试选项1时输入数据的结果
    public void test_oneProcess_InputCorrect() throws Exception {
        List<Info> infoList = new ArrayList<>();
        String[] arr = new String[]{"张三,101,数学:75,语文:95,英语:80,编程:80"};
        List<String> list = Arrays.asList(arr);
        Process process  = new Process();
        process.oneProcess(new Scanner("张三,101,数学:75,语文:95,英语:80,编程:80"),infoList);
        assertThat(systemOut().endsWith("请输入你的选择（1～3)\n")).isTrue();
    }

    @Test
    //测试选项2时输入数据的结果
    public void test_twoProcess_InputCorrect() throws Exception {
        List<Info> infoList = new ArrayList<>();
        Info info1 = setInfo("张三",101,setHashMap(75,95,80,80));
        Info info2 = setInfo("李四",102,setHashMap(85,80,70,90));
        infoList.add(info1);
        infoList.add(info2);
        Process process  = new Process();
        process.twoProcess(new Scanner("101,102"),infoList);
        assertThat(systemOut().endsWith("请输入你的选择（1～3)\n")).isTrue();
    }

    @Test
    //测试选项2时输入数据的结果
    public void test_twoProcess_InputError() throws Exception {
        List<Info> infoList = new ArrayList<>();
        Info info1 = setInfo("张三",101,setHashMap(75,95,80,80));
        Info info2 = setInfo("李四",102,setHashMap(85,80,70,90));
        infoList.add(info1);
        infoList.add(info2);
        Process process  = new Process();
        process.twoProcess(new Scanner("101,102,103"),infoList);
        assertThat(systemOut().endsWith("请输入你的选择（1～3)\n")).isTrue();
    }
    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces

        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertThat(mockedList.get(0)).isEqualTo(value);

    }

}
