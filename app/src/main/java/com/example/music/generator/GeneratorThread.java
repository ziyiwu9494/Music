package com.example.music.generator;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

class GeneratorThread extends Thread {

    private boolean isRunning;
    private int sr = 44100;
    private double tuneFreq = 440;
    private int tuneAmp = 10000;

    @Override
    public void run() {
        super.run();
        isRunning = true;
        int buffsize = AudioTrack.getMinBufferSize(sr,
                AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        // create an audiotrack object
        AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sr, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, buffsize,
                AudioTrack.MODE_STREAM);

        short samples[] = new short[buffsize];
        double twopi = 8.*Math.atan(1.);
        double ph = 0.0;

        // start audio
        audioTrack.play();

        // synthesis loop
        while(isRunning){
            double fr = tuneFreq;
            double amp = tuneAmp;
            for(int i=0; i < buffsize; i++){
                samples[i] = (short) (amp*Math.sin(ph));
                ph += twopi*fr/sr;
            }
            audioTrack.write(samples, 0, buffsize);
        }
        audioTrack.stop();
        audioTrack.release();
    }

    double getTuneFreq() {
        return tuneFreq;
    }

    void setTuneFreq(double tuneFreq) {
        this.tuneFreq = tuneFreq;
    }

    void setAmp(int tuneAmp){
        this.tuneAmp = tuneAmp;
    }


    public boolean isRunning() {
        return isRunning;
    }

    void stopTune() {
        isRunning = false;

        try {
            this.join();
            this.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}