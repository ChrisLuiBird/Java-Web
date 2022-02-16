package com.chris.party;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class Dom4JTest{

    @Test
    public void test1() throws Exception{
        SAXReader saxReader = new SAXReader();
        try{
            Document document = saxReader.read("xml解析Demo/xml/employees.xml");
            System.out.println(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws Exception{
        SAXReader saxReader = new SAXReader();
        try{
            //读取xml文件
            Document document = saxReader.read("xml解析Demo/xml/employees.xml");

            //拿到根元素()顶级元素
            Element e = document.getRootElement();
//            System.out.println(e);
            //根据子标签名获取子元素List
            List<Element> employees = e.elements("employee");


            employees.forEach(employee -> {

//                System.out.println(employee.asXML());
                //以下是 40行打印结果
//                <employee id="001">
//                    <name>Chris</name>
//                    <age>25</age>
//                    <salary>50000</salary>
//                </employee>
//            <employee id="002">
//                    <name>Peter</name>
//                    <age>22</age>
//                    <salary>40000</salary>
//                </employee>

//                Element name = employee.element("name");
//                System.out.println(name.asXML());
                //以下是54行打印结果
//                <name>Chris</name>
//                <name>Peter</name>

//                Element name = employee.element("name");
//                //获取标签中的文本内容
//                System.out.println(name.getText());
                //以下是61行打印结果
//              Chris
//              Peter

                //直接获取制定标签的文本内容
//                System.out.println(employee.elementText("salary"));

               //获取标签属性
//                System.out.println(employee.attributeValue("id"));

                //整合转换成对象
                String id = employee.attributeValue("id");
                String name = employee.elementText("name");
                String age = employee.elementText("age");
                BigDecimal salary = new BigDecimal(employee.elementText("salary"));
                System.out.println(new Employees(name,age, id, salary));
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}