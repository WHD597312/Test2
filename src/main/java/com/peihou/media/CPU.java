package com.peihou.media;

public class CPU extends Colleague {
    private String dataVideo,dataSound;
    public CPU(Mediator mediator) {
        super(mediator);
    }

    public String getDataVideo() {
        return dataVideo;
    }

    public String getDataSound() {
        return dataSound;
    }


    /**
     * 解析音频数据
     * @param data
     */
    public void decodedeData(String data){
        String[] tmp=data.split(",");
        dataSound=tmp[0];
        dataVideo=tmp[1];
        mediator.change(this);
    }
}
