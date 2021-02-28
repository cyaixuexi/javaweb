package com.cy.pojo;


import org.dom4j.Document;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;


public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        try{
            Document doc = saxReader.read("src/books.xml");
            System.out.println(doc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    * 读取books.xml文件生成book类
    * */
    @Test
    public void test2() throws Exception {
        //1 读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2 通过document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println( rootElement);
        //3 通过根元素获取book标签？
        //element()和elements都是通过标签名查找子元素
        List<Element> books = rootElement.elements();
        //4 遍历，处理每个book标签转化为book类
        for(Element book:books){
            //asXML() 把标签对象 转换为标签字符串
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");
//            System.out.println(nameElement.asXML());
            String nameText = nameElement.getText();

//            System.out.println(nameText);
            //直接获取指定标签名的文本内容
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");

            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText,authorText,priceText));
        }
    }

}
