package com.example.music.generator;

public class Generator{

    private GeneratorThread generatorThread;
    private double tuneFreq = 0f;
    private int tuneAmp = 10000;

    public Generator playTune(){
        if(generatorThread == null){
            generatorThread= new GeneratorThread();
            generatorThread.setTuneFreq(tuneFreq);
            generatorThread.start();
        }
        return this;
    }

    public void setTuneFreq(double tuneFreq) {
        this.tuneFreq = tuneFreq;
        if(generatorThread != null){
            generatorThread.setTuneFreq(tuneFreq);
        }
    }

    public void setTuneAmp(int tuneAmp){
        this.tuneAmp = tuneAmp;
        if(generatorThread != null){
            generatorThread.setAmp(tuneAmp);
        }
    }

    public double getTuneFreq() {
        return tuneFreq;
    }

    public void stopTune(){
        if(generatorThread != null){
            generatorThread.stopTune();
            generatorThread = null;
        }
    }

}