/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tghu.waveplayer.WavePlayerMaster;

public class WavePlayerClient
implements RingTonePlayer,
SystemTonePlayer {
    final int sessionID;
    final WavePlayerMaster waveplayer;
    WavePlayerListener listener;
    private int request = -1;
    private int lastToneId = 0;
    private int requestedTone = 0;

    WavePlayerClient(WavePlayerMaster wavePlayerMaster, int n) {
        this.waveplayer = wavePlayerMaster;
        this.sessionID = n;
    }

    @Override
    public void playDefault(int n) {
        this.callPlay(n, 1, "playDefault", 0);
    }

    @Override
    public void abort() {
        this.waveplayer.lc.log(-2137614336, "WavePlayerClient[%1].abort() ", (long)this.sessionID);
        this.request = 2;
        this.lastToneId = 0;
        this.waveplayer.abort(this);
    }

    @Override
    public void setListener(WavePlayerListener wavePlayerListener) {
        this.waveplayer.lc.log(-2137614336, "WavePlayerClient[%2].setListener( %1 )", (Object)wavePlayerListener, (long)this.sessionID);
        if (wavePlayerListener != null) {
            this.listener = wavePlayerListener;
            this.waveplayer.addListener(wavePlayerListener);
        }
    }

    @Override
    public void removeListener(WavePlayerListener wavePlayerListener) {
        this.waveplayer.lc.log(-2137614336, "WavePlayerClient[%2].removeListener( %1 )", (Object)wavePlayerListener, (long)this.sessionID);
        if (wavePlayerListener != null) {
            this.listener = null;
            this.waveplayer.removeListener(wavePlayerListener);
        }
    }

    @Override
    public void playTone(int n, int n2) {
        this.callPlay(n, 0, "play", n2);
    }

    int getLastRequest() {
        return this.request;
    }

    int getLastToneId() {
        return this.lastToneId;
    }

    int getRequestedTone() {
        return this.requestedTone;
    }

    public String toString() {
        return new StringBuffer().append("WavePlayerClient-").append(this.sessionID).toString();
    }

    private void callPlay(int n, int n2, String string, int n3) {
        this.waveplayer.lc.log(-2137614336, "WavePlayerClient[%2].%1( %3 ) ", (Object)string, (long)this.sessionID, (long)n);
        this.requestedTone = n2;
        this.lastToneId = n3;
        switch (n) {
            case 0: {
                this.request = 0;
                this.waveplayer.playTone(this, n, n3);
                break;
            }
            case 1: {
                this.request = 1;
                this.waveplayer.playTone(this, n, n3);
                break;
            }
            default: {
                this.waveplayer.lc.log(10000, "WavePlayerClient[%2].%1( %3 ) - Unknown play mode! ", (Object)string, (long)this.sessionID, (long)n);
            }
        }
    }
}

