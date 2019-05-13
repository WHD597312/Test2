package com.peihou.media;


public class MainBoard extends Mediator {
    private CPU cpu;
    private CDDevice cdDevice;
    private SoundCard soundCard;
    private GraphiscsCard graphiscsCard;
    @Override
    public void change(Colleague colleague){
        if (colleague==cdDevice){
            handleCD(cdDevice);
        }else if (colleague==cpu){
            handleCPU(cpu);
        }
    }

    private void handleCD(CDDevice cdDevice){
        cpu.decodedeData(cdDevice.read());
    }
    private void handleCPU(CPU cpu){
        soundCard.soundPlay(cpu.getDataSound());
        graphiscsCard.videoPaly(cpu.getDataVideo());
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setCdDevice(CDDevice cdDevice) {
        this.cdDevice = cdDevice;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public void setGraphiscsCard(GraphiscsCard graphiscsCard) {
        this.graphiscsCard = graphiscsCard;
    }
}
