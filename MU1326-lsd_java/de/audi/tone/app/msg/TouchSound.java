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
import de.audi.tone.app.msg.TouchSound$MsgListener;
import de.audi.tone.app.volume.samples.TouchSoundPlayer;

public class TouchSound
extends DefaultWavePlayerListener
implements ChoiceListener {
    private static final int TOUCHSOUND_ENABLED;
    private static final int TOUCHSOUND_DISABLED;
    public final DefaultMsgListener audioMsgListener = new TouchSound$MsgListener(this, null);
    private final TouchSoundPlayer player;
    private final LogChannel lc;
    private final ChoiceModelApp touchSoundOnOfModel;
    private volatile boolean touchSoundEnabled;
    private final ToneEnv env;

    public TouchSound(ToneEnv toneEnv) {
        this.lc = toneEnv.lcMain;
        this.env = toneEnv;
        this.player = new TouchSoundPlayer(this.lc, 0);
        this.touchSoundOnOfModel = toneEnv.getChoiceModel(-1841164544);
        this.touchSoundEnabled = toneEnv.getStorageAccess().getBoolean(1009, 29, true);
        this.touchSoundOnOfModel.setValue(this.touchSoundEnabled ? 1 : 0);
        this.touchSoundOnOfModel.setChoiceListener(this);
    }

    public void setService(SystemTonePlayer systemTonePlayer) {
        this.player.registerService(systemTonePlayer);
        systemTonePlayer.setListener(this);
    }

    @Override
    public void state(int n) {
        this.lc.log(-2137614336, "[TouchSound.state] called do nothing");
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == -1841164544) {
            this.lc.log(-2137614336, "[TouchSound.itemSelected] itemID: %1", (long)n2);
            this.touchSoundOnOfModel.setValue(n2);
            this.touchSoundEnabled = n2 == 1;
            this.env.getStorageAccess().setBoolean(1009, 29, this.touchSoundEnabled);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    static /* synthetic */ boolean access$100(TouchSound touchSound) {
        return touchSound.touchSoundEnabled;
    }

    static /* synthetic */ LogChannel access$200(TouchSound touchSound) {
        return touchSound.lc;
    }

    static /* synthetic */ TouchSoundPlayer access$300(TouchSound touchSound) {
        return touchSound.player;
    }
}

