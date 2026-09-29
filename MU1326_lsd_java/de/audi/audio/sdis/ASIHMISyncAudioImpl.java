/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.audi.audio.sdis.ASIHMISyncAudioImpl$SDISAudioListenerImpl;
import de.audi.audio.sdis.ifc.NullSdisAudioService;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioS;
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
    public final SdisAudioListener sdisAudioListener = new ASIHMISyncAudioImpl$SDISAudioListenerImpl(this, null);
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
        this.lc.log(1078071040, "[ASIHMISyncAudioService.register] %1", (Object)sdisAudioService);
        this.sdisAudioService = sdisAudioService;
    }

    @Override
    public IService getService() {
        return this.asiAudioService;
    }

    @Override
    public void attachStub(IStub iStub) {
        ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy = (ASIHMISyncAudioReplyProxy)iStub.getReplyProxyFrontend();
        this.lc.log(1078071040, "[ASIHMISyncAudioService.attachStub] '%1'proxy: %2", (Object)iStub, (Object)aSIHMISyncAudioReplyProxy);
        this.sdisAudioService.registerReplyProxy(aSIHMISyncAudioReplyProxy);
    }

    @Override
    public void detachStub(IStub iStub) {
        ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy = (ASIHMISyncAudioReplyProxy)iStub.getReplyProxyFrontend();
        this.lc.log(1078071040, "[ASIHMISyncAudioService.detachStub]  proxy: '%1' ", (Object)aSIHMISyncAudioReplyProxy);
        this.sdisAudioService.removeReplyProxy(aSIHMISyncAudioReplyProxy);
    }

    @Override
    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.setAudioContext] context:%1", (long)n);
        if (n == 1) {
            this.lc.log(-2137614336, "[ASIHMISyncAudioService.setAudioContext] Illegal audio context context:%1 do nothing", (long)n);
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

    @Override
    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.forceFrontAudioContext] con:text%1", (long)n);
        this.sdisAudioService.forceFrontAudioContext(n, aSIHMISyncAudioReply);
    }

    @Override
    public void requestEnableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.requestEnableA2LS] reply: %1, deviceId:%2", (Object)aSIHMISyncAudioReply, (Object)string);
        this.sdisAudioService.enableA2LS(string, aSIHMISyncAudioReply);
    }

    public void enableA2LS(byte[] byArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.enableA2LS] deprecated not implemented anymore", (Object)byArray);
    }

    @Override
    public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.disableA2LS]");
        this.sdisAudioService.disableA2LSFromSDIS(aSIHMISyncAudioReply);
    }

    @Override
    public void setVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.setVolume] volume:%1", (long)n);
        this.sdisAudioService.setVolume(n);
    }

    @Override
    public void increaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.increaseVolume] steps:%1", (long)n);
        this.sdisAudioService.increaseVolume(n);
    }

    @Override
    public void decreaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.lc.log(-2137614336, "[ASIHMISyncAudioService.decreaseVolume] steps:%1", (long)n);
        this.sdisAudioService.decreaseVolume(n);
    }

    static /* synthetic */ LogChannel access$100(ASIHMISyncAudioImpl aSIHMISyncAudioImpl) {
        return aSIHMISyncAudioImpl.lc;
    }
}

