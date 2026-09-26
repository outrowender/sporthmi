/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;
import de.audi.atip.interapp.media.IMediaOnlineSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IMediaSessionListener;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaBuffer;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaSession$1;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeStragegyFactory;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class OnlineMediaSession
implements IMediaOnlinePlayerSession,
IOnlineMediaSession {
    public static final int ENABLE_SKIP;
    public static final int ENABLE_SEEK;
    public static final int ENABLE_REPEAT;
    public static final int ENABLE_SHUFFLE;
    private static final String LOGCLASS;
    private OnlineMediaBuffer buffer;
    private String name;
    private String serviceID;
    private IMediaOnlineSessionPlayer player;
    private LogChannel log;
    private String cncURL;
    private String state = "MEDIA_NOT_READY";
    private IMediaSessionListener listener;
    private String errorMessage;
    private long lastChangedTrackId;
    private Map capabilities = new OnlineMediaSession$1(this);
    private boolean currentRepeat;
    private boolean currentShuffle;
    private boolean forward;
    private int skipCount;
    static /* synthetic */ Class class$de$audi$tghu$online$app$remotehmi$onlinemedia$OnlineMediaSession;

    public OnlineMediaSession(String string, String string2, String string3, LogChannel logChannel, IMediaSessionListener iMediaSessionListener) {
        this.log = logChannel;
        this.listener = iMediaSessionListener;
        this.name = string;
        if (string2 == null) {
            throw new IllegalArgumentException("need service id!");
        }
        this.serviceID = string2;
        this.cncURL = string3;
        this.buffer = new OnlineMediaBuffer();
    }

    @Override
    public int getAudioConnection() {
        return 45;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getServiceID() {
        return this.serviceID;
    }

    @Override
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.log.log(-2137614336, "OnlineMediaSession#onActive: [ID: %1] %2, cncURL: %3", (Object)this.serviceID, (Object)iMediaSessionPlayer, (Object)this.cncURL);
        this.player = (IMediaOnlineSessionPlayer)iMediaSessionPlayer;
        if (this.listener == null) {
            this.log.log(-1601830656, "OnlineMediaSession#onActive: no session listener registered");
            return;
        }
    }

    @Override
    public void onSuspend() {
        this.log.log(1078071040, "OnlineMediaSession#onSuspend; [serviceID: %1, name: %2]", (Object)this.serviceID, (Object)this.name);
        this.state = "MEDIA_PAUSED";
        if (this.listener == null) {
            this.log.log(-1601830656, "OnlineMediaSession#onSuspend: no session listener registered");
            return;
        }
        this.listener.processState(this);
    }

    @Override
    public void onClose() {
        this.log.log(1078071040, "OnlineMediaSession#onClose() [serviceID: %1, name: %2]", (Object)this.serviceID, (Object)this.name);
        this.state = "MEDIA_CLOSED";
        if (this.listener == null) {
            this.log.log(-1601830656, "OnlineMediaSession#onClose: no session listener registered");
            return;
        }
        this.listener.processState(this);
    }

    @Override
    public void updateState(int n) {
        String string = this.mapSessionState(n);
        this.log.log(-2137614336, "OnlineMediaSession#updateState() [ID: %1][State: %2: %3]", (Object)this.serviceID, (Object)Integer.toString(n), (Object)string);
        if (n == 1) {
            return;
        }
        this.state = string;
        if (this.listener == null) {
            this.log.log(-2137614336, "OnlineMediaSession#updateState: no session listener registered");
            return;
        }
        if (n == 6) {
            this.errorMessage = "a media service error occured";
        }
        this.listener.processState(this);
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        this.log.log(1078071040, "OnlineMediaSession#updatePlayPosition: [ID: %1][time: %2][totalTime: %3]", (Object)this.serviceID, (long)n, (long)n2);
        if (this.listener == null) {
            this.log.log(-2137614336, "OnlineMediaSession#updatePlayPosition: no session listener registered");
            return;
        }
        this.listener.updatePlayPosition(n, n2);
    }

    public void play(String string, int n) {
        this.log.log(-2137614336, "OnlineMediaSession#play: [ID: %1][url: %2][position: %3]", (Object)this.serviceID, (Object)string, (long)n);
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#play: player instance is null");
            return;
        }
    }

    public void seek2Time(int n) {
        this.log.log(-2137614336, "OnlineMediaSession#seek2Time: [ID: %1][position: %2]", (Object)this.serviceID, (long)n);
        if (this.player == null) {
            this.log.log(-1601830656, "OnlineMediaSession#seek2Time: player instance is null");
            return;
        }
        this.player.seekToTime(n);
    }

    public void pause() {
        this.log.log(-2137614336, "OnlineMediaSession#pause: [ID: %1]", (Object)this.serviceID);
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#pause: player instance is null");
            return;
        }
        this.player.pause();
    }

    public void resume() {
        this.log.log(-2137614336, "OnlineMediaSession#resume() [ID: %1]", (Object)this.serviceID);
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#resume() player instance is null");
            return;
        }
        this.player.resume();
    }

    public void seek(boolean bl) {
        this.log.log(-2137614336, "OnlineMediaSession#seek: [ID: %1][forward: %2]", (Object)this.serviceID, (Object)Boolean.toString(bl));
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#seek: player instance is null");
            return;
        }
        this.player.seek(bl);
    }

    public void close() {
        this.log.log(-2137614336, "OnlineMediaSession#close: [ID: %1]", (Object)this.serviceID);
        if (this.player == null) {
            this.log.log(-1601830656, "OnlineMediaSession#close: player instance is null");
            return;
        }
    }

    @Override
    public void updateBufferState(int n, int n2) {
        this.log.log(1078071040, "OnlineMediaSession#updateBufferState: state: %1, fillLevel: %2", (long)n, (long)n2);
        this.buffer.setFillLevel(n2);
        this.buffer.setState(this.mapBufferState(n));
        this.listener.processBufferChangedEvent(this);
    }

    public void setDefaultBuffer() {
        this.log.log(-2137614336, "OnlineMediaSession#setDefaultBuffer: called");
        this.buffer.setFillLevel(0);
        this.buffer.setState("MEDIA_BUFFER_UNDEFINED");
    }

    @Override
    public void trackChanged(long l) {
        this.lastChangedTrackId = l;
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("trackId", new Long(l));
        this.listener.processGenericEvent("MEDIA_METADATA_CHANGED", this, hMIProperties);
    }

    @Override
    public void responseDetailInfo(String string, String string2, String string3, String string4) {
        this.log.log(1078071040, "OnlineMediaSession#responseDetailInfo: received trackId '%1', title '%2', album '%3', artist '%4'", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        this.listener.updateMetadata(string, string2, string3, string4);
    }

    public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
        if (this.player == null) {
            this.log.log(-1601830656, "OnlineMediaSession#updatePlayingTrack: player instance is null");
            return;
        }
        this.player.updatePlayingTrack(l, string, string2, string3, resourceLocator);
    }

    @Override
    public void updateCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.log.log(1078071040, "OnlineMediaSession#UpdateCapabilities repeat: %1, shuffle: %2 playtime: %3", bl3, bl4, bl5);
        boolean bl7 = !bl5 || !bl6;
        this.capabilities.put(new Integer(2), bl2);
        this.capabilities.put(new Integer(1), bl);
        this.capabilities.put(new Integer(3), bl3);
        this.capabilities.put(new Integer(4), bl4);
        this.updatePlaytimeStrategy(bl7);
    }

    private void updatePlaytimeStrategy(boolean bl) {
        IPlaytimeStrategy iPlaytimeStrategy = bl ? PlaytimeStragegyFactory.createRadioPlaytimeStrategy(this.log) : PlaytimeStragegyFactory.createSingleTrackPlaytimeStrategy(this.log);
        iPlaytimeStrategy.updateBufferPosition(this);
        this.listener.setPlaytimeStrategy(iPlaytimeStrategy);
    }

    @Override
    public boolean isForward() {
        return this.forward;
    }

    @Override
    public int getSkipCount() {
        return this.skipCount;
    }

    @Override
    public boolean isSeekEnabled() {
        return (Boolean)this.capabilities.get(new Integer(2));
    }

    @Override
    public boolean isSkipEnabled() {
        return (Boolean)this.capabilities.get(new Integer(1));
    }

    @Override
    public boolean isRepeatEnabled() {
        return (Boolean)this.capabilities.get(new Integer(3));
    }

    @Override
    public boolean isShuffleEnabled() {
        return (Boolean)this.capabilities.get(new Integer(4));
    }

    @Override
    public String getLastError() {
        return this.errorMessage;
    }

    private String mapSessionState(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "MEDIA_NOT_READY";
                break;
            }
            case 1: {
                string = "MEDIA_READY";
                break;
            }
            case 2: {
                string = "MEDIA_PLAYING";
                break;
            }
            case 3: {
                string = "MEDIA_PAUSED";
                break;
            }
            case 6: {
                string = "MEDIA_ERROR";
                break;
            }
            case 5: {
                string = "MEDIA_EOF";
                break;
            }
            case 4: {
                string = "MEDIA_SEEKING";
                break;
            }
            default: {
                string = "MEDIA_ERROR";
                this.log.log(10000, "OnlineMediaSession#mapSessionState: Invalid OnlineMediaSessionState %1", (long)n);
            }
        }
        return string;
    }

    private String mapBufferState(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "MEDIA_BUFFER_FILLED";
                break;
            }
            case 0: {
                string = "MEDIA_BUFFER_UNDEFINED";
                break;
            }
            case 1: {
                string = "MEDIA_BUFFER_UNDERRUN";
                break;
            }
            default: {
                string = "MEDIA_BUFFER_UNDEFINED";
            }
        }
        return string;
    }

    @Override
    public int getTimeCurrent() {
        return 0;
    }

    @Override
    public int getTimeTotal() {
        return 0;
    }

    @Override
    public int getBufferLevel() {
        return this.buffer.getFillLevel();
    }

    @Override
    public String getBufferStatus() {
        return this.buffer.getState();
    }

    public int hashCode() {
        return this.getServiceID().hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof OnlineMediaSession)) {
            return false;
        }
        return this.getServiceID().equals(((OnlineMediaSession)object).getServiceID());
    }

    public String toString() {
        return new StringBuffer().append(this.getServiceID()).append(" ").append(this.getName()).toString();
    }

    public void skip(int n) {
        this.log.log(-2137614336, "OnlineMediaSession#skip: [ID: %1] skipSteps: %2", (Object)this.serviceID, (long)n);
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#skip: player instance is null");
            return;
        }
        this.player.skip(n);
    }

    @Override
    public String getUrl() {
        this.log.log(1078071040, "OnlineMediaSession#getUrl: returning url %1 to media", (Object)this.cncURL);
        return this.cncURL;
    }

    @Override
    public long getChangedTrackId() {
        return this.lastChangedTrackId;
    }

    public void setShuffle(boolean bl) {
        this.log.log(-2137614336, "OnlineMediaSession#setShuffle: [ID: %1] shuffle: %2", (Object)this.serviceID, (Object)new Boolean(bl));
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#setShuffle: player instance is null");
            return;
        }
        this.player.setShuffle(bl);
    }

    public void setRepeat(boolean bl) {
        this.log.log(-2137614336, "OnlineMediaSession#setRepeat: [ID: %1] repeat: %2", (Object)this.serviceID, (Object)new Boolean(bl));
        if (this.player == null) {
            this.log.log(-2137614336, "OnlineMediaSession#setRepeat: player instance is null");
            return;
        }
        this.player.setRepeatTitle(bl);
    }

    @Override
    public void updatePlaybackMode(boolean bl, boolean bl2) {
        this.log.log(1078071040, "OnlineMediaSession#updatePlaybackMode repeat: %1 shuffle %2", bl, bl2);
        if (this.currentRepeat != bl) {
            this.log.log(1078071040, "OnlineMediaSession#updatePlaybackMode repeat changed");
            this.listener.processRepeatChanged(this, bl);
        }
        if (this.currentShuffle != bl2) {
            this.log.log(1078071040, "OnlineMediaSession#updatePlaybackMode shuffle changed");
            this.listener.processShuffleChanged(this, bl2);
        }
        this.currentRepeat = bl;
        this.currentShuffle = bl2;
    }

    @Override
    public void updateSkipCount(boolean bl, int n) {
        this.log.log(1078071040, "OnlineMediaSession#updateSkipCount isForward: %1 skipCount %2", bl, (long)n);
        this.forward = bl;
        this.skipCount = n;
        this.listener.processSkipEvent(this);
    }

    public void updateCoverart(ResourceLocator resourceLocator) {
        if (this.player == null) {
            this.log.log(-1601830656, "OnlineMediaSession#updateCoverart: player instance is null");
            return;
        }
        this.player.updateOnlineCoverart(resourceLocator);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        LOGCLASS = (class$de$audi$tghu$online$app$remotehmi$onlinemedia$OnlineMediaSession == null ? (class$de$audi$tghu$online$app$remotehmi$onlinemedia$OnlineMediaSession = OnlineMediaSession.class$("de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaSession")) : class$de$audi$tghu$online$app$remotehmi$onlinemedia$OnlineMediaSession).getName();
    }
}

