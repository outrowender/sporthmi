/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.atip.interapp.media.IMediaPlayerSession;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.atip.log.LogChannel;

public abstract class AbstractPlayerSession
implements IMediaPlayerSession {
    private static final String LOGCLASS;
    public static final int ON_UNDEFINED;
    public static final int ON_CLOSE;
    public static final int ON_ACTIVE;
    public static final int ON_SUSPEND;
    protected final IMediaPlayerSession clientSession;
    private final LogChannel logger;
    private int currentState;
    private int onState;
    private IMediaSessionPlayer sessionPlayer;

    public AbstractPlayerSession(LogChannel logChannel, IMediaPlayerSession iMediaPlayerSession) {
        this.clientSession = iMediaPlayerSession;
        this.onState = -1;
        this.currentState = 0;
        this.logger = logChannel;
    }

    public String toString() {
        return this.clientSession.getName();
    }

    public int getPriority() {
        return this.clientSession.getType();
    }

    @Override
    public int getAudioConnection() {
        return this.clientSession.getAudioConnection();
    }

    @Override
    public int getType() {
        return this.clientSession.getType();
    }

    @Override
    public String getName() {
        return this.clientSession.getName();
    }

    public IMediaSessionPlayer getSessionPlayer() {
        return this.sessionPlayer;
    }

    @Override
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.onState = 1;
        this.sessionPlayer = iMediaSessionPlayer;
        this.updateState(1);
        this.clientSession.onActive(iMediaSessionPlayer);
    }

    @Override
    public void onSuspend() {
        this.onState = 2;
        this.sessionPlayer = null;
        this.updateState(0);
        this.clientSession.onSuspend();
    }

    @Override
    public void onClose() {
        this.onState = 0;
        this.sessionPlayer = null;
        this.updateState(0);
        this.clientSession.onClose();
    }

    @Override
    public void updateState(int n) {
        if (this.currentState == n) {
            return;
        }
        this.logger.log(1078071040, "[%1.updateState] '%2'", (Object)"AbstractPlayerSession", (Object)AbstractPlayerSession.state2Str(n));
        this.currentState = n;
        this.clientSession.updateState(n);
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        this.clientSession.updatePlayPosition(n, n2);
    }

    public int getState() {
        return this.currentState;
    }

    private static String state2Str(int n) {
        switch (n) {
            case 0: {
                return "NOT_READY";
            }
            case 3: {
                return "PAUSED";
            }
            case 2: {
                return "PLAYING";
            }
            case 1: {
                return "READY";
            }
            case 4: {
                return "SEEKING";
            }
            case 7: {
                return "STOPPED";
            }
            case 5: {
                return "STOPPED_EOF";
            }
            case 6: {
                return "STOPPED_ERROR";
            }
        }
        return new StringBuffer().append("UNKNOW (").append(n).append(")").toString();
    }

    public boolean isOnPlayback() {
        return this.getState() == 3 || this.getState() == 2 || this.getState() == 4;
    }

    public int getOnState() {
        return this.onState;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object object) {
        try {
            AbstractPlayerSession abstractPlayerSession = (AbstractPlayerSession)object;
            return this.clientSession == abstractPlayerSession.clientSession;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

