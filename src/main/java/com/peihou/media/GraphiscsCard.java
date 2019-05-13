package com.peihou.media;

public class GraphiscsCard extends Colleague {
    public GraphiscsCard(Mediator mediator) {
        super(mediator);
    }
    public void videoPaly(String data){
        System.out.println("视频："+data);
    }
}
