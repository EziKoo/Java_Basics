package com.chy.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 230.3));
        col.add(new Book("小李飞刀", "古龙", 221.3));
        col.add(new Book("红楼梦", "曹雪芹", 140.3));

        //System.out.println(col);

        //现在希望遍历出col里面的每一个元素
        //1、先得到 col 对应的迭代器
        Iterator iterator = col.iterator();
        //2、使用while循环遍历
        //while (iterator.hasNext()) {      //判断是否还有数据
        //    //返回下一个元素，类型是Object
        //    Object obj = iterator.next();
        //    System.out.println("obj = " + obj);
        //}

        //快捷键，快速生成while循环   ==> itit
        //显示所有快捷键的快捷键 ctrl + j
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
        //当退出while循环后，这时iterator迭代器，指向最后的元素
        //System.out.println(iterator.next());// NoSuchElementException
        //如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();

        //第二次遍历
        System.out.println("------------------------");
        while (iterator.hasNext()) {
            Object obj1 =  iterator.next();
            System.out.println(obj1);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
