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

    public int getAudioConnection() {
        return this.connection;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getServiceID() {
        return this.getName();
    }

    public String getUrl() {
        return this.url;
    }

    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.player = (IMediaOnlineSessionPlayer)iMediaSessionPlayer;
    }

    public void onSuspend() {
        this.player = null;
    }

    public void onClose() {
        this.player = null;
    }

    public void updateState(int n) {
        System.out.println("[DiagSession.updateState][" + this.getName() + "] " + n);
    }

    public void updatePlayPosition(int n, int n2) {
        System.out.println("[DiagSession.updatePlayPosition][" + this.getName() + "] " + n);
    }

    public void updateBufferState(int n, int n2) {
        System.out.println("[DiagSession.updateBufferState][" + this.getName() + "] " + n + "," + n2);
    }

    public void trackChanged(long l) {
        System.out.println("[DiagSession.trackChanged][" + this.getName() + "]");
    }

    public void trackSkipped() {
        System.out.println("[DiagSession.trackSkipped][" + this.getName() + "]");
    }

    public void updateCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        System.out.println("[DiagSession.updateCapabilities][" + this.getName() + "]" + bl + "," + bl2 + "," + bl3 + "," + bl4 + "," + bl5 + "," + bl6);
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

    public void updatePlaybackMode(boolean bl, boolean bl2) {
        System.out.println("[DiagSession.updatePlaybackMode][" + this.getName() + "](repeatTitle=" + bl + ", shuffle=" + bl2 + ")");
    }

    public void updateSkipCount(boolean bl, int n) {
        System.out.println("[DiagSession.updateSkipCount][" + this.getName() + "](isForward=" + bl + ", skipCount=" + n + ")");
    }

    public void responseDetailInfo(String string, String string2, String string3, String string4) {
        System.out.println("[DiagSession.responseDetailInfo][" + this.getName() + "](trackId=" + string + ", title=" + string2 + ", album=" + string3 + ", artist=" + string4 + ")");
    }
}

