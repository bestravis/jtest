package net.voovo.json;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class JSONArray {

    public static void main(String[] args) {
        JSONObject[] jsonObjects=new JSONObject[]{};

        Book book=Book.getBook();
        Book book2=Book.getBook();
        Book book3=Book.getBook();
        Book book4=Book.getBook();

        List<Book> list=new LinkedList();
        list.addAll(Arrays.asList( book, book3, book2,book4));
        String name=list.get(0).getBookName();
        list.removeIf(e->e.getBookName().equals(name));

        list.sort((a,b)->-a.getCreateTime().compareTo(b.getCreateTime()));

        for (Book book1 : list) {
            System.out.println(book1.getCreateTime());
        }

    }

}
