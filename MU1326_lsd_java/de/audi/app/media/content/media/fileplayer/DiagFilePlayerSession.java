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
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.player = (IMediaFileSessionPlayer)iMediaSessionPlayer;
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
    public void updateVideoContext(int n) {
        System.out.println(new StringBuffer().append("[DiagSession.updateVideoContext][").append(this.getName()).append("] ").append(n).toString());
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        System.out.println(new StringBuffer().append("[DiagSession.updatePlayPosition][").append(this.getName()).append("] ").append(n).toString());
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

