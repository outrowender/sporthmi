/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Message;

public class EWSBeepHandler {
    private static final int TONEID_WARNING = 16;
    private static final int EVENT_RELEASE_CONNECTION_FALLBACK = 1;
    private static final int EVENT_RELEASE_CONNECTION_FALLBACK_DELAY = 10000;
    public final PlayerListener playerListener = new PlayerListener();
    private final Handler handler;
    private volatile SystemTonePlayer systemTonePlayer;
    private volatile HMIAudioService hmiAudioService;
    private final LogChannel lc;

    public EWSBeepHandler(LogChannel logChannel, Handler.Builder builder) {
        this.lc = logChannel;
        this.systemTonePlayer = new NullSystemTonePlayer(logChannel);
        this.hmiAudioService = new NullHMIAudioService(logChannel);
        this.handler = builder.setHandlingStrategy(new HandlingStrategy()).getHandler();
    }

    public void setSystemTonePlayer(SystemTonePlayer systemTonePlayer) {
        this.systemTonePlayer = systemTonePlayer;
    }

    public void setHMIAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    public void playWarnTone(int n) {
        this.hmiAudioService.requestConnection(121);
    }

    private class PlayerListener
    extends DefaultHMIAudioServiceListener
    implements WavePlayerListener {
        private PlayerListener() {
        }

        public void fadedIn(int n, int n2) {
            if (n == 121) {
                EWSBeepHandler.this.systemTonePlayer.playTone(0, 16);
                EWSBeepHandler.this.handler.sendEmptyMessageDelayed(1, 10000L);
            }
        }

        public void startConnection(int n, int n2) {
            if (n == 121) {
                EWSBeepHandler.this.hmiAudioService.fadeToConnection(121);
            }
        }

        public void errorConnection(int n, int n2, int n3) {
            if (n == 121) {
                EWSBeepHandler.this.lc.log(100000, "[EWSBeepHandler.errorConnection]");
            }
        }

        public void state(int n) {
            if (n != 0) {
                EWSBeepHandler.this.hmiAudioService.releaseConnection(121);
                EWSBeepHandler.this.handler.removeMessages(1);
            }
        }

        public void playToneInfo(int n) {
        }
    }

    private final class HandlingStrategy
    implements Handler.IHandlingStrategy {
        private HandlingStrategy() {
        }

        public void handleMessage(Message message) {
            EWSBeepHandler.this.hmiAudioService.releaseConnection(121);
        }
    }
}

