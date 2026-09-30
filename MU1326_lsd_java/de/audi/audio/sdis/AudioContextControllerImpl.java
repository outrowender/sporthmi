/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.log.LogChannel;
import de.audi.audio.sdis.AudioContextController;
import de.audi.audio.sdis.AudioContextListener;
import de.audi.audio.sdis.ifc.NullASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class AudioContextControllerImpl
implements AudioContextController {
    private LogChannel logChannel;
    private AudioContextListener audioContextListner;
    private volatile int audioContext;
    private final HashMap audioContextStore;
    private volatile ASIHMISyncAudioReply replyCurrentRequest;
    private final InternalA2LSState a2lsState;
    private boolean isQCUnit;

    public AudioContextControllerImpl(LogChannel logChannel, boolean bl) {
        this.logChannel = logChannel;
        this.audioContextStore = new LinkedHashMap();
        this.a2lsState = new InternalA2LSState();
        this.audioContext = -1;
        this.isQCUnit = bl;
    }

    public int getAudioContext() {
        return this.audioContext;
    }

    public void addAudioContextListener(AudioContextListener audioContextListener) {
        this.audioContextListner = audioContextListener;
    }

    public void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LS] deviceId: %2 reply: %1", (Object)aSIHMISyncAudioReply, (Object)string);
        this.replyCurrentRequest = aSIHMISyncAudioReply;
        this.storeAudioContextA2LS(aSIHMISyncAudioReply);
        this.a2lsState.setRequestingDevice("");
        if (this.checkA2LSSteal(this.audioContext) && this.isQCUnit) {
            this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LS] a2ls stealing requested");
            this.audioContextListner.triggerA2LSStealing(aSIHMISyncAudioReply);
        } else if (this.checkA2LSSteal(this.audioContext)) {
            try {
                this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LS] a2ls already active");
                this.replyCurrentRequest.responseEnableA2LS(0);
            }
            catch (MethodException methodException) {
                String string2 = methodException.getMessage();
                this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LS] Exeption occurred: %1", (Object)string2);
            }
        } else {
            this.setAudioContext(1, aSIHMISyncAudioReply);
        }
        this.a2lsState.setCurrentDevice(string);
        this.audioContextListner.updateA2LSStateAccepted(new A2LSState(this.a2lsState.getCurrentDevice(), this.a2lsState.getRequestingDevice()));
    }

    public void enableA2LSPending(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LSPending] deviceId: %2 reply: %1", (Object)aSIHMISyncAudioReply, (Object)string);
        this.replyCurrentRequest = aSIHMISyncAudioReply;
        this.a2lsState.setRequestingDevice(string);
        this.audioContextListner.updateA2LSStatePending(new A2LSState(this.a2lsState.getCurrentDevice(), this.a2lsState.getRequestingDevice()));
    }

    public void enableA2LSAccept() {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LSAccept] deviceId: %2, repyl: %1", (Object)this.replyCurrentRequest, (Object)this.replyCurrentRequest);
        this.enableA2LS(this.a2lsState.getRequestingDevice(), this.replyCurrentRequest);
    }

    public void enableA2LSDecline() {
        try {
            this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LSDecline] a2lsstate: %1", (Object)this.a2lsState);
            this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LSDecline] reply: %1", (Object)this.replyCurrentRequest);
            this.a2lsState.setCurrentDevice("");
            this.a2lsState.setRequestingDevice("");
            this.replyCurrentRequest.responseEnableA2LS(2);
            this.audioContextListner.updateA2LSStateDeclined(new A2LSState(this.a2lsState.getCurrentDevice(), this.a2lsState.getRequestingDevice()));
        }
        catch (Exception exception) {
            String string = exception.getMessage();
            this.logChannel.log(10000000, "[AudioContextControllerImpl.enableA2LSDecline] Exeption occurred: %1", (Object)string);
        }
    }

    public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        if (this.isDisableA2LSAllowedForSDIS(aSIHMISyncAudioReply)) {
            this.logChannel.log(10000000, "[AudioContextControllerImpl(reply).disableA2LS] reply: %1", (Object)aSIHMISyncAudioReply);
            this.disableA2LS();
        } else {
            this.logChannel.log(10000000, "[AudioContextControllerImpl(reply).disableA2LS] disable not allowed for reply: %1", (Object)aSIHMISyncAudioReply);
        }
    }

    public void disableA2LS() {
        this.a2lsState.setCurrentDevice("");
        this.a2lsState.setRequestingDevice("");
        this.audioContextListner.updateA2LSStateDisabled(new A2LSState(this.a2lsState.getCurrentDevice(), this.a2lsState.getRequestingDevice()));
        Iterator iterator = this.audioContextStore.keySet().iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            Integer n = (Integer)this.audioContextStore.get(aSIHMISyncAudioReply);
            if (n != 1) continue;
            this.setAudioContext(0, aSIHMISyncAudioReply);
        }
    }

    public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        if (this.audioContext == 1) {
            this.logChannel.log(10000000, "[AudioContextControllerImpl.joinActiveAudioContext]audioContext: %2 is A2LS: ignore join, reply :%1", (Object)aSIHMISyncAudioReply, (long)this.audioContext);
        } else {
            this.storeAudioContext(this.audioContext, aSIHMISyncAudioReply);
        }
    }

    public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        if (this.audioContext == 1) {
            this.logChannel.log(10000000, "[AudioContextControllerImpl.unjoinActiveAudioContext]audioContext: %2 is A2LS: ignore unjoin, reply :%1", (Object)aSIHMISyncAudioReply, (long)this.audioContext);
        } else {
            this.setAudioContext(0, aSIHMISyncAudioReply);
        }
    }

    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.setAudioContext]audioContext: %2, reply :%1", (Object)aSIHMISyncAudioReply, (long)n);
        if (aSIHMISyncAudioReply != null) {
            if (this.isGlobalAudioContext(n)) {
                this.storeGlobalAudioContext(n, aSIHMISyncAudioReply);
            } else {
                this.storeAudioContext(n, aSIHMISyncAudioReply);
            }
        }
        if (this.hasAudioContextChanged(n)) {
            if (this.isA2LSRequestPending()) {
                this.logChannel.log(10000000, "[AudioContextControllerImpl.setAudioContext]a2ls request pending -> decline");
                this.enableA2LSDecline();
            }
            this.setAudioContext(n);
        } else {
            this.logChannel.log(10000000, "[AudioContextControllerImpl.setAudioContext] has not changed");
            this.logAudioContexts();
        }
    }

    public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.removeReplyProxy] remove reply: proxy", (Object)aSIHMISyncAudioReply);
        if (aSIHMISyncAudioReply == this.replyCurrentRequest) {
            this.a2lsState.setCurrentDevice("");
            this.a2lsState.setRequestingDevice("");
            this.audioContextListner.updateA2LSStateDisabled(new A2LSState(this.a2lsState.getCurrentDevice(), this.a2lsState.getRequestingDevice()));
            this.replyCurrentRequest = new NullASIHMISyncAudioReply(this.logChannel);
        }
        this.audioContextStore.remove(aSIHMISyncAudioReply);
    }

    private void logAudioContexts() {
        Iterator iterator = this.audioContextStore.keySet().iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            Integer n = (Integer)this.audioContextStore.get(aSIHMISyncAudioReply);
            this.logChannel.log(10000000, "[AudioContextControllerImpl.logAudioContexts] reply:%1, audioContext: %2", (Object)aSIHMISyncAudioReply, (Object)n);
        }
    }

    private void setAudioContext(int n) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.setAudioContext] old audioContext: %1 new audioContext: %2  ", (long)this.audioContext, (long)n);
        this.audioContext = n;
        this.audioContextListner.updateAudioContext(n);
    }

    private boolean hasAudioContextChanged(int n) {
        if (this.isGlobalAudioContext(n) || n == 1) {
            if (this.audioContext != n) {
                this.logChannel.log(10000000, "[SdisAudioHandler.hasAudioContextChanged] audio context has changed: requestedAudioContext: %1 audioContext: %2", (long)n, (long)this.audioContext);
                return true;
            }
            this.logChannel.log(10000000, "[SdisAudioHandler.hasAudioContextChanged] requested audio context already acitve: requestedAudioContext: %1 audioContext: %2", (long)n, (long)this.audioContext);
            return false;
        }
        Iterator iterator = this.audioContextStore.keySet().iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply = (ASIHMISyncAudioReply)iterator.next();
            Integer n2 = (Integer)this.audioContextStore.get(aSIHMISyncAudioReply);
            if (n2 == 0) continue;
            bl = false;
        }
        return bl && this.audioContext != 0;
    }

    private void storeGlobalAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        Iterator iterator = this.audioContextStore.keySet().iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply2 = (ASIHMISyncAudioReply)iterator.next();
            this.logChannel.log(10000000, "[AudioContextControllerImpl.storeGlobalAudioContext] reply: %1 audioContext: %2  ", (Object)aSIHMISyncAudioReply2, (long)n);
            if (aSIHMISyncAudioReply2 == aSIHMISyncAudioReply) {
                this.audioContextStore.put(aSIHMISyncAudioReply2, new Integer(n));
                continue;
            }
            Integer n2 = (Integer)this.audioContextStore.get(aSIHMISyncAudioReply2);
            if (!this.isGlobalAudioContext(n2)) continue;
            this.audioContextStore.put(aSIHMISyncAudioReply2, new Integer(n));
        }
    }

    private boolean isA2LSRequestPending() {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.isA2LSRequestPending] requesting device: %1", (Object)this.a2lsState.getRequestingDevice());
        String string = this.a2lsState.getRequestingDevice();
        return !"".equals(string);
    }

    private boolean checkA2LSSteal(int n) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.checkA2LSSteal] audioContext: %1 context: %2 ", (long)this.audioContext, (long)n);
        return n == 1 && this.audioContext == 1;
    }

    private boolean isDisableA2LSAllowedForSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        Integer n = (Integer)this.audioContextStore.get(aSIHMISyncAudioReply);
        this.logChannel.log(10000000, "[AudioContextControllerImpl.isDisableA2LSAllowedForSDIS] reply: %1", (Object)aSIHMISyncAudioReply, (Object)n);
        if (n != null) {
            return n == 1;
        }
        return false;
    }

    private boolean isGlobalAudioContext(int n) {
        boolean bl = n == 3 || n == 2 || n == 4;
        return bl;
    }

    private void storeAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        this.logChannel.log(10000000, "[AudioContextControllerImpl.storeAudioContext] audioContext: %2 reply: %1 ", (Object)aSIHMISyncAudioReply, (long)n);
        this.audioContextStore.put(aSIHMISyncAudioReply, new Integer(n));
    }

    private void storeAudioContextA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        Iterator iterator = this.audioContextStore.keySet().iterator();
        while (iterator.hasNext()) {
            ASIHMISyncAudioReply aSIHMISyncAudioReply2 = (ASIHMISyncAudioReply)iterator.next();
            if (aSIHMISyncAudioReply2 != aSIHMISyncAudioReply) {
                this.logChannel.log(10000000, "[AudioContextControllerImpl.storeAudioContextA2LS] store NONE for reply: %1 ", (Object)aSIHMISyncAudioReply);
                this.storeAudioContext(0, aSIHMISyncAudioReply2);
                continue;
            }
            this.logChannel.log(10000000, "[AudioContextControllerImpl.storeAudioContextA2LS] store A2LS for reply: %1 ", (Object)aSIHMISyncAudioReply);
            this.storeAudioContext(1, aSIHMISyncAudioReply2);
        }
    }

    private class InternalA2LSState {
        static final String NO_DEVICE = "";
        private volatile String requestingDevice = "";
        private volatile String currentDevice = "";

        public String getRequestingDevice() {
            return this.requestingDevice;
        }

        public void setRequestingDevice(String string) {
            this.requestingDevice = string;
        }

        public String getCurrentDevice() {
            return this.currentDevice;
        }

        public void setCurrentDevice(String string) {
            this.currentDevice = string;
        }
    }
}

