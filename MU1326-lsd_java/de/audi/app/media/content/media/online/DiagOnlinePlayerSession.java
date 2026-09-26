/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;
import de.audi.atip.interapp.media.IMediaOnlineSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;

public class DiagOnlinePlayerSession
implements IMediaOnlinePlayerSession {
    private final int connection;
    private final int type;
    private final String name;
    private final String url;
    private IMediaOnlineSessionPlayer player;

    public DiagOnlinePlayerSession(int n, int n2, String string, String string2) {
        this.connection = n;
        this.type = n2;
        this.name = string;
        this.url = string2;
    }

    @Override
    public int getAudioConnection() {
        return this.connection;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getServiceID() {
        return this.getName();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.player = (IMediaOnlineSessionPlayer)iMediaSessionPlayer;
    }

    @Override
    public void onSuspend() {
        this.player = null;
    }

    @Override
    public void onClose() {
        this.player = null;
    }

    @Override
    public void updateState(int n) {
        System.out.println(new StringBuffer().append("[DiagSession.updateState][").append(this.getName()).append("] ").append(n).toString());
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        System.out.println(new StringBuffer().append("[DiagSession.updatePlayPosition][").append(this.getName()).append("] ").append(n).toString());
    }

    @Override
    public void updateBufferState(int n, int n2) {
        System.out.println(new StringBuffer().append("[DiagSession.updateBufferState][").append(this.getName()).append("] ").append(n).append(",").append(n2).toString());
    }

    @Override
    public void trackChanged(long l) {
        System.out.println(new StringBuffer().append("[DiagSession.trackChanged][").append(this.getName()).append("]").toString());
    }

    public void trackSkipped() {
        System.out.println(new StringBuffer().append("[DiagSession.trackSkipped][").append(this.getName()).append("]").toString());
    }

    @Override
    public void updateCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        System.out.println(new StringBuffer().append("[DiagSession.updateCapabilities][").append(this.getName()).append("]").append(bl).append(",").append(bl2).append(",").append(bl3).append(",").append(bl4).append(",").append(bl5).append(",").append(bl6).toString());
    }

    public void pause() {
        this.player.pause();
    }

    public void resume() {
        this.player.resume();
    }

    public void seek(boolean bl) {
        this.player.seek(bl);
    }

    public void stop() {
        this.player.stop();
    }

    public void skip(int n) {
        this.player.skip(n);
    }

    public void seekToTime(int n) {
        this.player.seekToTime(n);
    }

    public void updateTrackData(String string, String string2, String string3) {
        this.player.updatePlayingTrack(0L, string, string2, string3, null);
    }

    public void shuffle(boolean bl) {
        this.player.setShuffle(bl);
    }

    public void repeatTitle(boolean bl) {
        this.player.setRepeatTitle(bl);
    }

    @Override
    public void updatePlaybackMode(boolean bl, boolean bl2) {
        System.out.println(new StringBuffer().append("[DiagSession.updatePlaybackMode][").append(this.getName()).append("](repeatTitle=").append(bl).append(", shuffle=").append(bl2).append(")").toString());
    }

    @Override
    public void updateSkipCount(boolean bl, int n) {
        System.out.println(new StringBuffer().append("[DiagSession.updateSkipCount][").append(this.getName()).append("](isForward=").append(bl).append(", skipCount=").append(n).append(")").toString());
    }

    @Override
    public void responseDetailInfo(String string, String string2, String string3, String string4) {
        System.out.println(new StringBuffer().append("[DiagSession.responseDetailInfo][").append(this.getName()).append("](trackId=").append(string).append(", title=").append(string2).append(", album=").append(string3).append(", artist=").append(string4).append(")").toString());
    }
}

