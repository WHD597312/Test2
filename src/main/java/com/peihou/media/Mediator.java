package com.peihou.media;

public abstract class Mediator {
    /**
     * 同事对象改变时通知中介者的方法
     * 在同事对象改变时由中介者通知其他对象
     * @param colleague
     */
    public abstract void change(Colleague colleague);
}
