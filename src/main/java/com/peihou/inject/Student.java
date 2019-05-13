package com.peihou.inject;

public class Student {
    @ButterKnife(id=1)
    int id;

    @SuppressWarnings("过时")
    public int getId() {
        System.out.println("通过注解给Id设值");
        return id;
    }

    public void setId(int id) {
        System.out.println("通过注解给Id设值");
        this.id = id;
    }
}
