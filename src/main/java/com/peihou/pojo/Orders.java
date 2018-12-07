package com.peihou.pojo;

public class Orders {
    private int id;
    private String ordersn;
    private int uid;
    private String codes;

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordersn='" + ordersn + '\'' +
                ", uid=" + uid +
                '}';
    }
}
