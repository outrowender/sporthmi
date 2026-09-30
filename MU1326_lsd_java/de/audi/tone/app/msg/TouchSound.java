/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.DefaultWavePlayerListener;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.volume.samples.TouchSoundPlayer;

public class TouchSound
extends DefaultWavePlayerListener
implements ChoiceListener {
    private static final int TOUCHSOUND_ENABLED = 1;
    private static final int TOUCHSOUND_DISABLED = 0;
    public final DefaultMsgListener audioMsgListener = new MsgListener();
    private final TouchSoundPlayer player;
    private final LogChannel lc;
    private final ChoiceModelApp touchSoundOnOfModel;
    private volatile boolean touchSoundEnabled;
    private final ToneEnv env;

    public TouchSound(ToneEnv toneEnv) {
        this.lc = toneEnv.lcMain;
        this.env = toneEnv;
        this.player = new TouchSoundPlayer(this.lc, 0);
        this.touchSoundOnOfModel = toneEnv.getChoiceModel(1000082);
        this.touchSoundEnabled = toneEnv.getStorageAccess().getBoolean(1009, 29, true);
        this.touchSoundOnOfModel.setValue(this.touchSoundEnabled ? 1 : 0);
        this.touchSoundOnOfModel.setChoiceListener(this);
    }

    public void setService(SystemTonePlayer systemTonePlayer) {
        this.player.registerService(systemTonePlayer);
        systemTonePlayer.setListener(this);
    }

    public void state(int n) {
        this.lc.log(10000000, "[TouchSound.state] called do nothing");
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 1000082) {
            this.lc.log(10000000, "[TouchSound.itemSelected] itemID: %1", (long)n2);
            this.touchSoundOnOfModel.setValue(n2);
            this.touchSoundEnabled = n2 == 1;
            this.env.getStorageAccess().setBoolean(1009, 29, this.touchSoundEnabled);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private class MsgListener
    extends DefaultMsgListener {
        private MsgListener() {
        }

        protected void playTouchSound() {
            if (TouchSound.this.touchSoundEnabled) {
                TouchSound.this.lc.log(10000000, "[TouchSound.MsgListener.playTouchSound] play");
                TouchSound.this.player.play();
            } else {
                TouchSound.this.lc.log(10000000, "[TouchSound.MsgListener.playTouchSound] touchSoundEnabled: %1", TouchSound.this.touchSoundEnabled);
            }
        }

        protected void resetMessagingSettings() {
            TouchSound.this.itemSelected(1000082, 1, 0, 0);
        }
    }
}

