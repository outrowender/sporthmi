/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.ifc.NullSdisAudioService;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioS;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class ASIHMISyncAudioImpl
extends ASIHMISyncAudioAbstractBaseService
implements ASIHMISyncAudioS,
IASIProvider {
    public final SdisAudioListener sdisAudioListener = new SDISAudioListenerImpl();
    private final LogChannel lc;
    private final ASIHMISyncAudioService asiAudioService;
    private SdisAudioService sdisAudioService;

    public ASIHMISyncAudioImpl(int n, LogChannel logChannel) {
        this.lc = logChannel;
        this.sdisAudioService = new NullSdisAudioService(logChannel);
        this.asiAudioService = new ASIHMISyncAudioService(n, this);
        try {
            this.updateASIVersion("2.3.00");
            this.updateRequestIDs(new short[]{0, 1, 2, 9, 10, 11, 3, 6, 12, 22, 4, 8, 21});
            this.updateReplyIDs(new short[]{7, 13, 14, 15, 19, 20, 17, 18, 23, 24, 25});
        }
        catch (MethodException methodException) {
            logChannel.log(10000, "[ASIHMISyncAudioImpl.new] Could not register ASI version!", (Throwable)methodException);
        }
    }

    public void setAudioService(SdisAudioService sdisAudioService) {
        this.lc.log(1000000, "[ASIHMISyncAudioService.register] %1", (Object)sdisAudioService);
        this.sdisAudioService = sdisAudioService;
    }

    public IService getService() {
        return this.asiAudioService;
    }

    public void attachStub(IStub iStub) {
        ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy = (ASIHMISyncAudioReplyProxy)iStub.getReplyProxyFrontend();
        this.lc.log(1000000, "[ASIHMISyncAudioService.attachStub] '%1'proxy: %2", (Object)iStub, (Object)aSIHMISyncAudioReplyProxy);
        this.sdisAudioService.registerReplyProxy(aSIHMISyncAudioReplyProxy);
    }

    public void detachStub(IStub iStub) {
        ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy = (ASIHMISyncAudioReplyProxy)iStub.getReplyProxyFrontend();
        this.lc.log(1000000, "[ASIHMISyncAudioService.detachStub]  proxy: '%1' ", (Object)aSIHMISyncAudioReplyProxy);
        this.sdisAudioService.removeReplyProxy(aSIHMISyncAudioReplyProxy);
    }

    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.setAudioContext] context:%1", (long)n);
        if (n == 1) {
            this.lc.log(10000000, "[ASIHMISyncAudioService.setAudioContext] Illegal audio context context:%1 do nothing", (long)n);
            return;
        }
        if (n == -1) {
            this.sdisAudioService.joinActiveAudioContext(aSIHMISyncAudioReply);
        } else if (n == -2) {
            this.sdisAudioService.unjoinActiveAudioContext(aSIHMISyncAudioReply);
        } else {
            this.sdisAudioService.setAudioContext(n, aSIHMISyncAudioReply);
        }
    }

    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(10000000, "[ASIHMISyncAudioService.forceFrontAudioContext] con:text%1", (long)n);
        this.sdisAudioService.forceFrontAudioContext(n, aSIHMISyncAudioReply);
    }

    public void requestEnableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.requestEnableA2LS] reply: %1, deviceId:%2", (Object)aSIHMISyncAudioReply, (Object)string);
        this.sdisAudioService.enableA2LS(string, aSIHMISyncAudioReply);
    }

    public void enableA2LS(byte[] byArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.enableA2LS] deprecated not implemented anymore", (Object)byArray);
    }

    public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.disableA2LS]");
        this.sdisAudioService.disableA2LSFromSDIS(aSIHMISyncAudioReply);
    }

    public void setVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.setVolume] volume:%1", (long)n);
        this.sdisAudioService.setVolume(n);
    }

    public void increaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.increaseVolume] steps:%1", (long)n);
        this.sdisAudioService.increaseVolume(n);
    }

    public void decreaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) throws MethodException {
        this.lc.log(10000000, "[ASIHMISyncAudioService.decreaseVolume] steps:%1", (long)n);
        this.sdisAudioService.decreaseVolume(n);
    }

    private class SDISAudioListenerImpl
    implements SdisAudioListener {
        private volatile int currentVolume;

        private SDISAudioListenerImpl() {
        }

        public void updateAudioContext(AudioState audioState) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateAudioContext] %1", (Object)SdisLabels.getAudioState(audioState));
            try {
                ASIHMISyncAudioImpl.this.updateAudioContext(audioState);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateAudioContext]", (Throwable)exception);
            }
        }

        public void updateFrontAudioContext(AudioState audioState) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateFrontAudioContext] %1", (Object)SdisLabels.getAudioState(audioState));
            try {
                ASIHMISyncAudioImpl.this.updateFrontAudioContext(audioState);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateFronAudioContext]", (Throwable)exception);
            }
        }

        public void updateVolumeRange(VolumeRange volumeRange) {
            try {
                ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateVolumeRange] min:%1 max:%2", (long)volumeRange.min, (long)volumeRange.max);
                ASIHMISyncAudioImpl.this.updateVolumeRange(volumeRange);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateVolumeRange]", (Throwable)exception);
            }
        }

        public void updateVolume(int n) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateVolume] currentVolume:%1 -> volume:%2", (long)this.currentVolume, (long)n);
            try {
                if (this.currentVolume != n) {
                    this.currentVolume = n;
                    ASIHMISyncAudioImpl.this.updateVolume(n);
                } else {
                    ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateVolume] volume has not changed send no update");
                }
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateVolume]", (Throwable)exception);
            }
        }

        public void updateAudibleState(int n) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateAudibleState] audibleState:%1", (long)n);
            try {
                ASIHMISyncAudioImpl.this.updateAudibleState(n);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateAudibleState]", (Throwable)exception);
            }
        }

        public void updateA2LSState(A2LSState a2LSState) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateA2LSState] a2lsState:%1", (Object)a2LSState);
            try {
                ASIHMISyncAudioImpl.this.updateA2LSState(a2LSState);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateA2LSState]", (Throwable)exception);
            }
        }

        public void updateVolumeLockState(VolumeLockState volumeLockState) {
            ASIHMISyncAudioImpl.this.lc.log(10000000, "-> [SDISAudioListenerImpl.updateVolumeLockState] volumeLockState:%1", (Object)volumeLockState);
            try {
                ASIHMISyncAudioImpl.this.updateVolumeLockState(volumeLockState);
            }
            catch (Exception exception) {
                ASIHMISyncAudioImpl.this.lc.log(10000, "[SDISAudioListenerImpl.updateVolumeLockState]", (Throwable)exception);
            }
        }
    }
}

