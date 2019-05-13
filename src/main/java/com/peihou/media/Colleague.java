package com.peihou.media;

public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator){
        this.mediator=mediator;
    }
}
