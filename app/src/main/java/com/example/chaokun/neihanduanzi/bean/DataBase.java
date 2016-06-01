package com.example.chaokun.neihanduanzi.bean;

/**
 * Created by linchaokun on 2016/6/1.
 */
public class DataBase {
    private int id;
    private String request;//请求json数据
    private int page;//页数
    private int MenuNumber;//菜单序号;
    private String counts;//评论json数据

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMenuNumber() {
        return MenuNumber;
    }

    public void setMenuNumber(int menuNumber) {
        MenuNumber = menuNumber;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
