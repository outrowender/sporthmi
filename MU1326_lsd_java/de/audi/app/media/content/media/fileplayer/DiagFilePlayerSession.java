/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;

public class DiagFilePlayerSession
implements IMediaFilePlayerSession {
    private final int connection;
    private final int type;
    private final String name;
    private IMediaFileSessionPlayer player;

    public DiagFilePlayerSession(int n, int n2, String string) {
        this.connection = n;
        this.type = n2;
        this.name = string;
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

    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.player = (IMediaFileSessionPlayer)iMediaSessionPlayer;
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

    public void updateVideoContext(int n) {
        System.out.println("[DiagSession.updateVideoContext][" + this.getName() + "] " + n);
    }

    public void updatePlayPosition(int n, int n2) {
        System.out.println("[DiagSession.updatePlayPosition][" + this.getName() + "] " + n);
    }

    public void playURL(String string) {
        this.player.play(string, false);
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

    public void setVideoScaling() {
        this.player.setVideoScaling(0, 0, 200, 200);
    }
}

