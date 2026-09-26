/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tghu.waveplayer.WavePlayerMaster;
import de.audi.tghu.waveplayer.WavePlayerMaster$1;
import de.audi.tghu.waveplayer.WavePlayerMaster$Request;
import de.audi.tghu.waveplayer.WavePlayerUtil;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

class WavePlayerMaster$DSIWavePlayerListenerImpl
implements DSIWavePlayerListener {
    private final /* synthetic */ WavePlayerMaster this$0;

    private WavePlayerMaster$DSIWavePlayerListenerImpl(WavePlayerMaster wavePlayerMaster) {
        this.this$0 = wavePlayerMaster;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAudioRequest(int n, int n2) {
        Object object;
        if (n2 != 1) {
            this.this$0.lc.log(1078071040, "[DSIWavePlayerListener.updateAudioRequest] INVALID validFlag:%1", (long)n2);
            return;
        }
        if (this.this$0.lc.isDebug()) {
            object = WavePlayerUtil.getAudioStateLabel(n);
            this.this$0.lc.log(-2137614336, "[DSIWavePlayerListener.updateAudioRequest] audioState:%2 (%1)", object, (long)n);
        }
        if (n == 1) {
            WavePlayerMaster.access$100(this.this$0).registerWaveplayerService();
        }
        object = WavePlayerMaster.access$200(this.this$0);
        synchronized (object) {
            WavePlayerMaster.access$300(this.this$0, n);
            WavePlayerMaster.access$402(this.this$0, n);
            WavePlayerMaster$Request wavePlayerMaster$Request = WavePlayerMaster.access$500(this.this$0).get();
            if (wavePlayerMaster$Request == null) {
                this.this$0.lc.log(-2137614336, "WavePlayerMaster: Queue is empty", (long)n);
                WavePlayerMaster.access$602(this.this$0, -1);
                WavePlayerMaster.access$702(this.this$0, -1);
                return;
            }
            switch (n) {
                case 0: {
                    this.this$0.lc.log(-2137614336, "WavePlayerMaster: State Active");
                    WavePlayerMaster.access$602(this.this$0, -1);
                    if (wavePlayerMaster$Request.id != 2 && wavePlayerMaster$Request.id != 3) break;
                    this.this$0.lc.log(-2137614336, "WavePlayerMaster: State ACTIVE => Sending queued ABORT request");
                    WavePlayerMaster.access$500(this.this$0).remove();
                    this.this$0.abort(wavePlayerMaster$Request.client);
                    return;
                }
                case 1: {
                    this.this$0.lc.log(-2137614336, "WavePlayerMaster: State IDLE");
                    WavePlayerMaster.access$602(this.this$0, -1);
                    if (wavePlayerMaster$Request.id != 0 && wavePlayerMaster$Request.id != 1) break;
                    this.this$0.lc.log(-2137614336, "WavePlayerMaster: State IDLE => Sending queued MODE: %1 request", (long)wavePlayerMaster$Request.id);
                    WavePlayerMaster.access$500(this.this$0).remove();
                    this.this$0.playTone(wavePlayerMaster$Request.client, wavePlayerMaster$Request.id, wavePlayerMaster$Request.toneId);
                    return;
                }
                default: {
                    this.this$0.lc.log(-2137614336, "WavePlayerMaster: State %1 - Nothing todo", (long)n);
                }
            }
        }
    }

    @Override
    public void audioTriggerResponse(int n) {
        if (this.this$0.lc.isDebug()) {
            String string = WavePlayerUtil.getAudioModeLabel(n);
            this.this$0.lc.log(-2137614336, "[DSIWavePlayerListener.audioTriggerResponse] audioMode:%2 (%1)", (Object)string, (long)n);
        }
    }

    @Override
    public void updatePlayTone(int n, int n2) {
        if (n2 != 1) {
            this.this$0.lc.log(1078071040, "[DSIWavePlayerListener.updatePlayTone] INVALID validFlag:%1", (long)n2);
            return;
        }
        this.this$0.lc.log(-2137614336, "[DSIWavePlayerListener.updatePlayTone] playToneInfo:%1", (long)n);
        WavePlayerMaster.access$802(this.this$0, n);
        int n3 = WavePlayerMaster.access$900(this.this$0).size();
        for (int i2 = 0; i2 < n3; ++i2) {
            WavePlayerListener wavePlayerListener = (WavePlayerListener)WavePlayerMaster.access$900(this.this$0).get(i2);
            this.this$0.lc.log(-2137614336, "WavePlayerMaster.updatePlayTone(%1) -> %1.playToneInfo(%2)", (Object)wavePlayerListener, (long)n);
            WavePlayerMaster.access$1000(this.this$0, wavePlayerListener, n);
        }
    }

    @Override
    public void setPlayTone(int n) {
        if (this.this$0.lc.isDebug()) {
            String string = WavePlayerUtil.getResultLabel(n);
            this.this$0.lc.log(14808325, "[DSIWavePlayerListener.setPlayTone] result:%2 (%1)", (Object)string, (long)n);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.this$0.lc.log(10000, "[DSIWavePlayerListener.asyncException] code:%2 request:%3 msg:%1", (Object)string, (long)n, (long)n2);
    }

    /* synthetic */ WavePlayerMaster$DSIWavePlayerListenerImpl(WavePlayerMaster wavePlayerMaster, WavePlayerMaster$1 wavePlayerMaster$1) {
        this(wavePlayerMaster);
    }
}

