package net.voovo.json;

import java.util.List;
import java.util.Random;

public class Book {

    Long createTime;

    String bookName;

    List list;

    public static Book getBook(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book=new Book();
        book.setBookName(Math.random()*100+"");
        book.setCreateTime(System.currentTimeMillis());
        return book;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
