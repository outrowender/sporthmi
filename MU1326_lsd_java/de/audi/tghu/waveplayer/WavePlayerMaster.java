/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.WavePlayerClient;
import de.audi.tghu.waveplayer.WavePlayerImpl;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tghu.waveplayer.WavePlayerUtil;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.waveplayer.DSIWavePlayer;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

public class WavePlayerMaster {
    static final int NO_SESSION = -1;
    static final int REQUEST_NONE = -1;
    static final int REQUEST_PLAY_ONCE = 0;
    static final int REQUEST_PLAY_REPEATEDLY = 1;
    static final int REQUEST_ABORT = 2;
    static final int REQUEST_INTERRUPT = 3;
    static final int PLAY_ACTIVE_TONE = 0;
    static final int PLAY_DEFAULT_TONE = 1;
    private final WavePlayerImpl wavePlayer;
    private final Object mutex = new Object();
    private final RequestQueue queue;
    private final DSIWavePlayerListener dsiListener = new DSIWavePlayerListenerImpl();
    final LogChannel lc;
    private DSIWavePlayer dsiWavePlayer;
    private Request lastClientRequest;
    private int playerState = 1;
    private static final int INT_STATE_DEFAULT = -1;
    private static final int INT_STATE_PLAY_REQUESTED = 0;
    private static final int INT_STATE_PLAY_REQUESTED_WAITING_FOR_IDLE = 1;
    private volatile int intState = -1;
    private int activeSession = -1;
    private final List listeners = new ArrayList(10);
    private int currentPlayToneInfo = -1;
    private int cachedTone = -1;

    public WavePlayerMaster(WavePlayerImpl wavePlayerImpl, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.wavePlayer = wavePlayerImpl;
        this.lc = logChannel;
        this.queue = new RequestQueue(logChannel);
    }

    void addListener(WavePlayerListener wavePlayerListener) {
        this.lc.log(10000000, "WavePlayerMaster.addListener(%1)", (Object)wavePlayerListener);
        this.listeners.add(wavePlayerListener);
        if (this.currentPlayToneInfo != -1) {
            this.lc.log(10000000, "WavePlayerMaster.addListener() -> %1.playToneInfo(%2)", (Object)wavePlayerListener, (long)this.currentPlayToneInfo);
            this.updateListenerPlayToneInfo(wavePlayerListener, this.currentPlayToneInfo);
        }
    }

    void removeListener(WavePlayerListener wavePlayerListener) {
        this.lc.log(10000000, "WavePlayerMaster.removeListener(%1)", (Object)wavePlayerListener);
        this.listeners.remove(wavePlayerListener);
    }

    void registerDSI(DSIWavePlayer dSIWavePlayer) {
        this.dsiWavePlayer = dSIWavePlayer;
    }

    DSIWavePlayerListener getDSIListener() {
        return this.dsiListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void playTone(WavePlayerClient wavePlayerClient, int n, int n2) {
        int n3 = n == 0 ? 0 : 1;
        this.lc.log(10000000, "WavePlayerMaster.playTone(%1, %2, %3)", (Object)wavePlayerClient, (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            if (this.cachedTone != n2) {
                if (this.intState == 0 || this.intState == 1) {
                    this.lc.log(10000000, "WavePlayerMaster.playTone: wait for IDLE before setting the playtone.");
                } else {
                    this.cachedTone = n2;
                    this.callDSIsetPlayTone(n2);
                }
            }
            this.queue.clear();
            if (!this.canPlay(wavePlayerClient)) {
                return;
            }
            boolean bl = this.callDSIaudioTrigger(n3, wavePlayerClient.getRequestedTone());
            if (bl) {
                this.intState = 0;
                this.lastClientRequest = new Request(wavePlayerClient, n, n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void abort(WavePlayerClient wavePlayerClient) {
        this.lc.log(10000000, "WavePlayerMaster: Request ABORT from client %1", (long)wavePlayerClient.sessionID);
        Object object = this.mutex;
        synchronized (object) {
            if (!this.canAbort(wavePlayerClient)) {
                return;
            }
            boolean bl = this.callDSIaudioTrigger(2, wavePlayerClient.getRequestedTone());
            if (bl) {
                this.lastClientRequest = new Request(wavePlayerClient, 2, 0);
            }
        }
    }

    private boolean isDSIRegistered() {
        if (this.dsiWavePlayer != null) {
            return true;
        }
        this.lc.log(10000, "WavePlayerMaster: No DSIWavePlayer registered");
        return false;
    }

    private boolean canPlay(WavePlayerClient wavePlayerClient) {
        boolean bl;
        switch (this.playerState) {
            case 1: {
                if (this.intState == 0) {
                    this.lc.log(10000000, "WavePlayerMaster.canPlay( %1 ): State PLAY_REQUESTED => send ABORT and queue PLAY request!", (Object)wavePlayerClient);
                    this.interrupt(wavePlayerClient);
                    this.queue.add(new Request(wavePlayerClient, wavePlayerClient.getLastRequest(), wavePlayerClient.getLastToneId()));
                    this.intState = 1;
                    bl = false;
                    break;
                }
                if (this.intState == 1) {
                    this.lc.log(10000000, "WavePlayerMaster.canPlay( %1 ): State PLAY_REQUESTED (waiting for IDLE) => IDLE not received yet. Do nothing.", (Object)wavePlayerClient);
                    this.queue.add(new Request(wavePlayerClient, wavePlayerClient.getLastRequest(), wavePlayerClient.getLastToneId()));
                    bl = false;
                    break;
                }
                this.lc.log(10000000, "WavePlayerMaster.canPlay( %1 ): State IDLE => send PLAY request!", (Object)wavePlayerClient);
                bl = true;
                break;
            }
            case 0: {
                this.lc.log(10000000, "WavePlayerMaster.canPlay( %1 ): State ACTIVE => send ABORT and queue PLAY request!", (Object)wavePlayerClient);
                this.interrupt(wavePlayerClient);
                this.queue.add(new Request(wavePlayerClient, wavePlayerClient.getLastRequest(), wavePlayerClient.getLastToneId()));
                bl = false;
                this.intState = -1;
                break;
            }
            default: {
                this.lc.log(10000, "WavePlayerMaster.canPlay( %1 ): Unknown player state: %2", (Object)wavePlayerClient, (long)this.playerState);
                bl = false;
                this.intState = -1;
            }
        }
        this.activeSession = wavePlayerClient.sessionID;
        return bl;
    }

    private void interrupt(WavePlayerClient wavePlayerClient) {
        if (this.lastClientRequest != null) {
            this.updateListenerState(this.lastClientRequest.client, 3);
            this.callDSIaudioTrigger(2, wavePlayerClient.getRequestedTone());
            this.lastClientRequest = new Request(this.lastClientRequest.client, 3, 0);
        }
    }

    private boolean canAbort(WavePlayerClient wavePlayerClient) {
        if (this.activeSession == -1) {
            this.lc.log(100000, "WavePlayerMaster: No active client found - ignoring abort request!");
            return false;
        }
        if (wavePlayerClient.sessionID != this.activeSession) {
            this.lc.log(1000000, "WavePlayerMaster: Aborting a play request triggered by another application not allowed!");
            return false;
        }
        switch (this.playerState) {
            case 1: {
                this.lc.log(10000000, "WavePlayerMaster: State IDLE|PROCESSING_ABORT - ignoring abort request!");
                return false;
            }
            case 0: {
                this.lc.log(10000000, "WavePlayerMaster: State ACTIVE => send ABORT request!");
                return true;
            }
        }
        this.lc.log(10000, "WavePlayerMaster: Unknown player state: %1", (long)this.playerState);
        return false;
    }

    private void updateListenerState(WavePlayerClient wavePlayerClient, int n) {
        if (wavePlayerClient != null && wavePlayerClient.listener != null) {
            try {
                wavePlayerClient.listener.state(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[WavePlayerMaster.updateListenerState] Calling %1#state(%2) failed!", (Object)wavePlayerClient.listener, (long)n);
                this.lc.log(10000, "[WavePlayerMaster.updateListenerState]", (Throwable)exception);
            }
        }
    }

    private void updateListenerPlayToneInfo(WavePlayerListener wavePlayerListener, int n) {
        try {
            wavePlayerListener.playToneInfo(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[WavePlayerMaster.updateListenerPlayToneInfo] Calling %1#playToneInfo(%2) failed!", (Object)wavePlayerListener, (long)n);
            this.lc.log(10000, "[WavePlayerMaster.updateListenerPlayToneInfo]", (Throwable)exception);
        }
    }

    private void updateClientState(int n) {
        if (this.lastClientRequest == null) {
            return;
        }
        block0 : switch (n) {
            case 0: {
                if (this.lastClientRequest.id != 0 && this.lastClientRequest.id != 1) break;
                this.lc.log(10000000, "WavePlayerMaster: Updating state of client %1: STATE_PLAYING", (long)this.lastClientRequest.client.sessionID);
                this.updateListenerState(this.lastClientRequest.client, 0);
                break;
            }
            case 1: {
                switch (this.lastClientRequest.id) {
                    case 2: {
                        this.lc.log(10000000, "WavePlayerMaster: Updating state of client %1: STATE_ABORTED", (long)this.lastClientRequest.client.sessionID);
                        this.updateListenerState(this.lastClientRequest.client, 1);
                        break block0;
                    }
                    case 3: {
                        this.lc.log(10000000, "WavePlayerMaster: Updating state of client %1: STATE_INTERRUPTED", (long)this.lastClientRequest.client.sessionID);
                        this.updateListenerState(this.lastClientRequest.client, 3);
                        break block0;
                    }
                }
                this.lc.log(10000000, "WavePlayerMaster: Updating state of client %1: STATE_FINISHED", (long)this.lastClientRequest.client.sessionID);
                this.updateListenerState(this.lastClientRequest.client, 2);
                break;
            }
            default: {
                this.lc.log(10000, "WavePlayerMaster.updateClientState(): Unknown DSI PlayerState %1", (long)n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean callDSIaudioTrigger(int n, int n2) {
        if (!this.isDSIRegistered()) {
            return false;
        }
        Object object = this.mutex;
        synchronized (object) {
            try {
                if (n2 == 0) {
                    this.lc.log(10000000, "WavePlayerMaster: Calling DSIWavePlayer.audioTrigger(%1)", (long)n);
                    this.dsiWavePlayer.audioTrigger(n);
                } else {
                    this.lc.log(10000000, "WavePlayerMaster: Calling DSIWavePlayer.audioTriggerDefaultTone(%1)", (long)n);
                    this.dsiWavePlayer.audioTriggerDefaultTone(n);
                }
                return true;
            }
            catch (Exception exception) {
                String string = n2 == 0 ? "audioTrigger" : "audioTriggerDefaultTone";
                this.lc.log(10000, "WavePlayerMaster: Calling DSIWavePlayer.%1(%2) failed!", (Object)string, (long)n);
                this.lc.log(10000, "[WavePlayerMaster.callDSIaudioTrigger]", (Throwable)exception);
                return false;
            }
        }
    }

    private void callDSIsetPlayTone(int n) {
        if (!this.isDSIRegistered()) {
            return;
        }
        try {
            this.lc.log(10000000, "WavePlayerMaster: Calling DSIWavePlayer.setPlayTone(%1)", (long)n);
            this.dsiWavePlayer.setPlayTone(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "WavePlayerMaster: Setting play tone failed!", (Throwable)exception);
        }
    }

    private static class Request {
        final WavePlayerClient client;
        final int id;
        final int toneId;

        Request(WavePlayerClient wavePlayerClient, int n, int n2) {
            this.client = wavePlayerClient;
            this.id = n;
            this.toneId = n2;
        }
    }

    private static class RequestQueue {
        LogChannel lc;
        private final List list = new ArrayList(10);

        public RequestQueue(LogChannel logChannel) {
            this.lc = logChannel;
        }

        void add(Request request) {
            this.lc.log(10000000, "WavePlayerMaster.RequestQueue.add(%1) called", (Object)request);
            this.list.add(request);
        }

        Request get() {
            this.lc.log(10000000, "WavePlayerMaster.RequestQueue.get() called");
            if (!this.list.isEmpty()) {
                Request request = (Request)this.list.get(0);
                this.lc.log(10000000, "WavePlayerMaster.RequestQueue.get() request.id: %1", (long)request.id);
                return request;
            }
            return null;
        }

        Request remove() {
            this.lc.log(10000000, "WavePlayerMaster.RequestQueue.remove() called");
            if (!this.list.isEmpty()) {
                return (Request)this.list.remove(0);
            }
            return null;
        }

        void clear() {
            this.lc.log(10000000, "WavePlayerMaster.RequestQueue.clear() called");
            this.list.clear();
        }
    }

    private class DSIWavePlayerListenerImpl
    implements DSIWavePlayerListener {
        private DSIWavePlayerListenerImpl() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateAudioRequest(int n, int n2) {
            Object object;
            if (n2 != 1) {
                WavePlayerMaster.this.lc.log(1000000, "[DSIWavePlayerListener.updateAudioRequest] INVALID validFlag:%1", (long)n2);
                return;
            }
            if (WavePlayerMaster.this.lc.isDebug()) {
                object = WavePlayerUtil.getAudioStateLabel(n);
                WavePlayerMaster.this.lc.log(10000000, "[DSIWavePlayerListener.updateAudioRequest] audioState:%2 (%1)", object, (long)n);
            }
            if (n == 1) {
                WavePlayerMaster.this.wavePlayer.registerWaveplayerService();
            }
            object = WavePlayerMaster.this.mutex;
            synchronized (object) {
                WavePlayerMaster.this.updateClientState(n);
                WavePlayerMaster.this.playerState = n;
                Request request = WavePlayerMaster.this.queue.get();
                if (request == null) {
                    WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: Queue is empty", (long)n);
                    WavePlayerMaster.this.intState = -1;
                    WavePlayerMaster.this.cachedTone = -1;
                    return;
                }
                switch (n) {
                    case 0: {
                        WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: State Active");
                        WavePlayerMaster.this.intState = -1;
                        if (request.id != 2 && request.id != 3) break;
                        WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: State ACTIVE => Sending queued ABORT request");
                        WavePlayerMaster.this.queue.remove();
                        WavePlayerMaster.this.abort(request.client);
                        return;
                    }
                    case 1: {
                        WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: State IDLE");
                        WavePlayerMaster.this.intState = -1;
                        if (request.id != 0 && request.id != 1) break;
                        WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: State IDLE => Sending queued MODE: %1 request", (long)request.id);
                        WavePlayerMaster.this.queue.remove();
                        WavePlayerMaster.this.playTone(request.client, request.id, request.toneId);
                        return;
                    }
                    default: {
                        WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster: State %1 - Nothing todo", (long)n);
                    }
                }
            }
        }

        public void audioTriggerResponse(int n) {
            if (WavePlayerMaster.this.lc.isDebug()) {
                String string = WavePlayerUtil.getAudioModeLabel(n);
                WavePlayerMaster.this.lc.log(10000000, "[DSIWavePlayerListener.audioTriggerResponse] audioMode:%2 (%1)", (Object)string, (long)n);
            }
        }

        public void updatePlayTone(int n, int n2) {
            if (n2 != 1) {
                WavePlayerMaster.this.lc.log(1000000, "[DSIWavePlayerListener.updatePlayTone] INVALID validFlag:%1", (long)n2);
                return;
            }
            WavePlayerMaster.this.lc.log(10000000, "[DSIWavePlayerListener.updatePlayTone] playToneInfo:%1", (long)n);
            WavePlayerMaster.this.currentPlayToneInfo = n;
            int n3 = WavePlayerMaster.this.listeners.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                WavePlayerListener wavePlayerListener = (WavePlayerListener)WavePlayerMaster.this.listeners.get(i2);
                WavePlayerMaster.this.lc.log(10000000, "WavePlayerMaster.updatePlayTone(%1) -> %1.playToneInfo(%2)", (Object)wavePlayerListener, (long)n);
                WavePlayerMaster.this.updateListenerPlayToneInfo(wavePlayerListener, n);
            }
        }

        public void setPlayTone(int n) {
            if (WavePlayerMaster.this.lc.isDebug()) {
                String string = WavePlayerUtil.getResultLabel(n);
                WavePlayerMaster.this.lc.log(100000000, "[DSIWavePlayerListener.setPlayTone] result:%2 (%1)", (Object)string, (long)n);
            }
        }

        public void asyncException(int n, String string, int n2) {
            WavePlayerMaster.this.lc.log(10000, "[DSIWavePlayerListener.asyncException] code:%2 request:%3 msg:%1", (Object)string, (long)n, (long)n2);
        }
    }
}

