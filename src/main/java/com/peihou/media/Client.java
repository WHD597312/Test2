package com.peihou.media;

public class Client {
    public static void main(String[] args){
        MainBoard mainBoard=new MainBoard();
        CDDevice cdDevice=new CDDevice(mainBoard);
        CPU cpu=new CPU(mainBoard);
        GraphiscsCard graphiscsCard=new GraphiscsCard(mainBoard);
        SoundCard soundCard=new SoundCard(mainBoard);
        mainBoard.setCdDevice(cdDevice);
        mainBoard.setCpu(cpu);
        mainBoard.setGraphiscsCard(graphiscsCard);
        mainBoard.setSoundCard(soundCard);
        cdDevice.load();
    }
}
