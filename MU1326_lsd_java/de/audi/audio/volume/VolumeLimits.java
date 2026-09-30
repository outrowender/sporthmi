/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.atip.log.LogChannel;
import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.volume.OnOffVolumeRange;
import de.esolutions.fw.util.commons.Buffer;

public class VolumeLimits {
    private static final int INT_AMP_MAX = 30;
    private static final int EXT_AMP_MAX = 40;
    public final IAudioListener audioListener = new Audiolistener();
    public final ISoundListener soundListener = new SoundListener();
    private final Object mutex = new Object();
    private final OnOffVolumeRange.Controller controller;
    private final LogChannel lc;
    private volatile int origMin = 0;
    private volatile int origMax = 40;
    private volatile int activeConnection = 0;
    private boolean internalAmplifier = true;

    public VolumeLimits(AudioEnv audioEnv, OnOffVolumeRange.Controller controller) {
        this.lc = audioEnv.lcVol;
        this.controller = controller;
    }

    private Buffer updateLimits() {
        int n;
        int n2;
        if (this.isVolMenuConnection(this.activeConnection)) {
            return new Buffer().append("Active connection ").append(this.activeConnection).append(" is a volume menu connection -> don't change min/max!");
        }
        boolean bl = this.isSpecialConnection(this.activeConnection);
        if (bl) {
            n2 = 0;
            n = this.internalAmplifier ? 30 : 40;
        } else {
            n2 = this.origMin;
            n = this.origMax;
        }
        this.controller.getRange(0).updateLimits(n2, n);
        this.controller.getRange(3).updateLimits(n2, n);
        this.controller.getRange(4).updateLimits(n2, n);
        return new Buffer().append("min:").append(n2).append(" max:").append(n).append(" AAC:").append(this.activeConnection).append(" special:").append(bl);
    }

    private boolean isVolMenuConnection(int n) {
        switch (n) {
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 92: 
            case 94: 
            case 132: {
                return true;
            }
        }
        return false;
    }

    private boolean isSpecialConnection(int n) {
        switch (n) {
            case 95: 
            case 98: 
            case 99: 
            case 103: 
            case 104: 
            case 112: 
            case 114: 
            case 115: 
            case 116: 
            case 117: 
            case 118: 
            case 119: 
            case 124: 
            case 129: {
                return true;
            }
        }
        return false;
    }

    private class Audiolistener
    extends DefaultAudioListener {
        private Audiolistener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateActiveConnection(int n, int n2) {
            Buffer buffer;
            Object object = VolumeLimits.this.mutex;
            synchronized (object) {
                VolumeLimits.this.activeConnection = n;
                buffer = VolumeLimits.this.updateLimits();
            }
            VolumeLimits.this.lc.log(10000000, "[VolumeLimits.updateActiveConnection] %1", (Object)buffer);
        }
    }

    private class SoundListener
    extends DefaultSoundListener {
        private SoundListener() {
        }

        public void updateActiveAmplifiers(int n) {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateVolumeRange(int n, int n2) {
            Buffer buffer;
            Object object = VolumeLimits.this.mutex;
            synchronized (object) {
                VolumeLimits.this.origMin = n;
                VolumeLimits.this.origMax = n2;
                buffer = VolumeLimits.this.updateLimits();
            }
            VolumeLimits.this.lc.log(10000000, "[VolumeLimits.updateVolumeRange] %1", (Object)buffer);
        }
    }
}

