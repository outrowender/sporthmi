/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.core.boardbook.BoardbookHandler;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.atip.log.LogChannel;

public class BoardbookFilePlayerSession
implements IMediaFilePlayerSession {
    private static final int RESOLUTION_X_SCREEN_G24;
    private static final int RESOLUTION_Y_SCREEN_G24;
    private static final int RESOLUTION_X_VIDEO_G24;
    private static final int RESOLUTION_Y_VIDEO_G24;
    private static final int RESOLUTION_X_SCREEN_G22;
    private static final int RESOLUTION_Y_SCREEN_G22;
    private static final int RESOLUTION_X_VIDEO_G22;
    private static final int RESOLUTION_Y_VIDEO_G22;
    private static final int RESOLUTION_X_SCREEN_G21;
    private static final int RESOLUTION_Y_SCREEN_G21;
    private static final int RESOLUTION_X_VIDEO_G21;
    private static final int RESOLUTION_Y_VIDEO_G21;
    final int currentScreenRes;
    final boolean isEvoHighMMIKombi;
    private int state;
    private int oldstate;
    private volatile IMediaFileSessionPlayer player;
    private String url;
    private LogChannel logChannel;
    private BoardbookHandler handler;

    public BoardbookFilePlayerSession(LogChannel logChannel, BoardbookHandler boardbookHandler, int n, boolean bl) {
        this.logChannel = logChannel;
        this.handler = boardbookHandler;
        this.state = 0;
        this.currentScreenRes = n;
        this.isEvoHighMMIKombi = bl;
    }

    public int getState() {
        return this.state;
    }

    public void setPlaybackUrl(String string) {
        this.url = string;
    }

    @Override
    public int getAudioConnection() {
        return 201;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "BoardbookVideoSession";
    }

    private void calcAndSetVideoScaling(int n, int n2, int n3, int n4) {
        int n5 = n3 > n ? 0 : (n - n3) / 2;
        int n6 = n4 > n2 ? 0 : (n2 - n4) / 2;
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#calcAndSetVideoScaling():  XRes = %1  and YRes = %2", (long)n3, (long)n4);
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#calcAndSetVideoScaling():  XPos = %1  and YPos = %2", (long)n5, (long)n6);
        this.player.setVideoScaling(n5, n6, n3, n4);
    }

    @Override
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        this.handler.setVideoLoading(false);
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#onActive()");
        this.player = (IMediaFileSessionPlayer)iMediaSessionPlayer;
        this.logChannel.log(1078071040, "ScreenRes: %1", (long)this.currentScreenRes);
        switch (this.currentScreenRes) {
            case 1: {
                this.calcAndSetVideoScaling(800, 480, 640, 360);
                break;
            }
            case 2: {
                this.calcAndSetVideoScaling(1024, 480, 853, 480);
                break;
            }
            case 4: {
                if (this.isEvoHighMMIKombi) {
                    this.calcAndSetVideoScaling(800, 480, 640, 360);
                    break;
                }
            }
            default: {
                return;
            }
        }
        this.player.play(this.url, false);
    }

    @Override
    public void onSuspend() {
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#onSuspended()");
    }

    @Override
    public void onClose() {
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#onClose()");
        this.player = null;
    }

    @Override
    public void updateState(int n) {
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#updateState: update session state %1", (long)n);
        this.state = n;
        if (n == 2 && this.oldstate != 2) {
            this.handler.triggerScreenChangeToVideo();
        }
        this.oldstate = n;
        if (n == 6 || n == 5 || n == 0) {
            this.handler.returnFromVideoToBoardbook();
        }
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
        this.logChannel.log(1078071040, "BoardbooFilePlayerSession#updatePlayPosition %1 %2", (long)n, (long)n2);
        this.handler.updatePlayPosition(n, n2);
    }

    @Override
    public void updateVideoContext(int n) {
        this.logChannel.log(1078071040, "BoardbookFilePlayerSession#updateVideoDisplayContext received display context %1", (long)n);
        this.handler.getDisplayContextModel().setValue(n);
    }

    public void pause() {
        if (this.player != null) {
            this.player.pause();
        }
    }

    public void resume() {
        if (this.player != null) {
            this.player.resume();
        }
    }
}

