/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.msg.DefaultMsgListener;

public class AudioFactoryReset
extends DefaultMsgListener {
    private final LogChannel lc;
    private final IDSISoundHandler dsiSound;

    public AudioFactoryReset(LogChannel logChannel, IDSISoundHandler iDSISoundHandler) {
        this.lc = logChannel;
        this.dsiSound = iDSISoundHandler;
    }

    protected void resetPhoneSettings() {
        this.lc.log(10000000, "[AudioFactoryReset.resetPhoneSettings]");
        this.dsiSound.revertToFactorySettings(0, AudioConnection.PHONE_CALL, "Phone Call");
        this.dsiSound.revertToFactorySettings(0, AudioConnection.PHONE_RINGING, "Phone Ringtone");
        this.dsiSound.revertToFactorySettings(0, 126);
    }

    protected void resetNavSettings() {
        this.lc.log(10000000, "[AudioFactoryReset.resetNavSettings]");
        this.dsiSound.revertToFactorySettings(0, 116);
        this.dsiSound.revertToFactorySettings(0, 117);
    }

    protected void resetSpeechSettings() {
        this.lc.log(10000000, "[AudioFactoryReset.resetSpeechSettings]");
        this.dsiSound.revertToFactorySettings(0, 112);
        this.dsiSound.revertToFactorySettings(0, 113);
    }

    protected void resetMessagingSettings() {
        this.lc.log(10000000, "[AudioFactoryReset.resetMessagingSettings]");
        this.dsiSound.revertToFactorySettings(0, 126);
    }

    protected void resetSoundSettings() {
        this.lc.log(10000000, "[AudioFactoryReset.resetSoundSettings]");
        this.dsiSound.revertToFactorySettings(0, 1);
    }
}

