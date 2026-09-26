/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.sdis.ASIHMISyncAudioImpl;
import de.audi.audio.sdis.ASIHMISyncAudioImpl$1;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;

class ASIHMISyncAudioImpl$SDISAudioListenerImpl
implements SdisAudioListener {
    private volatile int currentVolume;
    private final /* synthetic */ ASIHMISyncAudioImpl this$0;

    private ASIHMISyncAudioImpl$SDISAudioListenerImpl(ASIHMISyncAudioImpl aSIHMISyncAudioImpl) {
        this.this$0 = aSIHMISyncAudioImpl;
    }

    @Override
    public void updateAudioContext(AudioState audioState) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateAudioContext] %1", (Object)SdisLabels.getAudioState(audioState));
        try {
            this.this$0.updateAudioContext(audioState);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateAudioContext]", (Throwable)exception);
        }
    }

    @Override
    public void updateFrontAudioContext(AudioState audioState) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateFrontAudioContext] %1", (Object)SdisLabels.getAudioState(audioState));
        try {
            this.this$0.updateFrontAudioContext(audioState);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateFronAudioContext]", (Throwable)exception);
        }
    }

    @Override
    public void updateVolumeRange(VolumeRange volumeRange) {
        try {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateVolumeRange] min:%1 max:%2", (long)volumeRange.min, (long)volumeRange.max);
            this.this$0.updateVolumeRange(volumeRange);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateVolumeRange]", (Throwable)exception);
        }
    }

    @Override
    public void updateVolume(int n) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateVolume] currentVolume:%1 -> volume:%2", (long)this.currentVolume, (long)n);
        try {
            if (this.currentVolume != n) {
                this.currentVolume = n;
                this.this$0.updateVolume(n);
            } else {
                ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateVolume] volume has not changed send no update");
            }
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateVolume]", (Throwable)exception);
        }
    }

    @Override
    public void updateAudibleState(int n) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateAudibleState] audibleState:%1", (long)n);
        try {
            this.this$0.updateAudibleState(n);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateAudibleState]", (Throwable)exception);
        }
    }

    @Override
    public void updateA2LSState(A2LSState a2LSState) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateA2LSState] a2lsState:%1", (Object)a2LSState);
        try {
            this.this$0.updateA2LSState(a2LSState);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateA2LSState]", (Throwable)exception);
        }
    }

    @Override
    public void updateVolumeLockState(VolumeLockState volumeLockState) {
        ASIHMISyncAudioImpl.access$100(this.this$0).log(-2137614336, "-> [SDISAudioListenerImpl.updateVolumeLockState] volumeLockState:%1", (Object)volumeLockState);
        try {
            this.this$0.updateVolumeLockState(volumeLockState);
        }
        catch (Exception exception) {
            ASIHMISyncAudioImpl.access$100(this.this$0).log(10000, "[SDISAudioListenerImpl.updateVolumeLockState]", (Throwable)exception);
        }
    }

    /* synthetic */ ASIHMISyncAudioImpl$SDISAudioListenerImpl(ASIHMISyncAudioImpl aSIHMISyncAudioImpl, ASIHMISyncAudioImpl$1 aSIHMISyncAudioImpl$1) {
        this(aSIHMISyncAudioImpl);
    }
}

