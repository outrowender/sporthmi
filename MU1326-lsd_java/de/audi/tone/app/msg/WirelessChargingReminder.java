/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.volume.samples.TTSSingleSpeakSamplePlayer;

public class WirelessChargingReminder
extends DefaultMsgListener {
    private static final String BEEP;
    private TTSSingleSpeakSamplePlayer samplePlayer;
    private final String DEFAULT_TEXT;
    private static final int REMINDER_SIGNAL_OFF;
    private static final int REMINDER_SIGNAL_BEEP;
    private static final int REMINDER_SIGNAL_SPOKEN_TEXT;
    private final ToneEnv env;

    public WirelessChargingReminder(ToneEnv toneEnv) {
        this.DEFAULT_TEXT = "Text not available";
        this.env = toneEnv;
        this.samplePlayer = new TTSSingleSpeakSamplePlayer(toneEnv, "Text not available");
    }

    public void init() {
        this.samplePlayer = new TTSSingleSpeakSamplePlayer(this.env, this.env.getTranslatedText(2, "Text not available"));
    }

    @Override
    protected void playWirelessChargingReminder() {
        int n = this.env.getStorageAccess().getInt(1009, 1, 2);
        String string = this.getText(n);
        this.env.lcHMI.log(-2137614336, "[WirelessChargingReminder.playWirelessChargingReminder] text:'%1'", (Object)string);
        if (!"Text not available".equalsIgnoreCase(string)) {
            this.samplePlayer.setText(string);
            this.samplePlayer.play();
        }
    }

    private String getText(int n) {
        this.env.lcHMI.log(1078071040, "[WirelessChargingReminder.getText] textId: %1", (long)n);
        switch (n) {
            case 0: {
                this.env.lcHMI.log(1078071040, "[WirelessChargingVolumeReminder.getText] Signal settings OFF", (long)n);
                return "Text not available";
            }
            case 1: {
                return "<audio src=\"WLC-reminder.wav\"/>";
            }
            case 2: {
                return this.env.getTranslatedText(2, "Text not available");
            }
        }
        this.env.lcHMI.log(10000, "[WirelessChargingVolumeReminder.getText] Invalid textId %1", (long)n);
        return "Text not available";
    }

    public void registerService(Object object) {
        this.samplePlayer.registerService(object);
    }

    public TTSListener getSamplePlayer() {
        return this.samplePlayer;
    }

    public void deregisterService(Object object) {
        this.samplePlayer.deregisterService(object);
    }

    @Override
    protected void resetSoundSettings() {
        this.resetWirelessChargingReminderSignalChoice();
    }

    @Override
    protected void resetPhoneSettings() {
        this.resetWirelessChargingReminderSignalChoice();
    }

    private void resetWirelessChargingReminderSignalChoice() {
        this.env.getStorageAccess().setInt(1009, 1, 2);
        this.env.getChoiceModel(-1505620224).setValue(2);
    }
}

