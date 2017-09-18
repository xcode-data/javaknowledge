package com.part4;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JDemo1 {
    private static ArrayList<Book> bookList = new ArrayList<Book>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // ����xmlParsing.xml�ļ�
        // ����SAXReader�Ķ���reader
        SAXReader reader = new SAXReader();
        try {
            // ͨ��reader�����read��������xmlParsing.xml�ļ�,��ȡdocuemnt����
            Document document = reader.read(new File("file/xmlParsing.xml"));
            // ͨ��document�����ȡ���ڵ�bookstore
            Element bookStore = document.getRootElement();
            // ͨ��element�����elementIterator������ȡ������
            Iterator it = bookStore.elementIterator();
            // ��������������ȡ���ڵ��е���Ϣ���鼮��
            while (it.hasNext()) {
                System.out.println("=====��ʼ����ĳһ����=====");
                Element book = (Element) it.next();
                // ��ȡbook���������Լ� ����ֵ
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("��������" + attr.getName() + "--����ֵ��"
                            + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println("�ڵ�����" + bookChild.getName() + "--�ڵ�ֵ��" + bookChild.getStringValue());
                }
                System.out.println("=====��������ĳһ����=====");
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}