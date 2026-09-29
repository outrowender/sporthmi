/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.volume.VolumeRangeManager;

class VolumeRangeManager$ActionProxyListenerExt
extends ActionProxyListener {
    private final /* synthetic */ VolumeRangeManager this$0;

    VolumeRangeManager$ActionProxyListenerExt(VolumeRangeManager volumeRangeManager) {
        this.this$0 = volumeRangeManager;
        super(0);
    }

    @Override
    public void volumeLoweredEntertainmentAPSEntered() {
        this.this$0.entered(5, this.terminalID);
    }

    @Override
    public void volumeLoweredEntertainmentAPSLeft() {
        this.this$0.left(5, this.terminalID);
    }

    @Override
    public void volumeHeartbeatEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(7);
        this.this$0.entered(8, this.terminalID);
    }

    @Override
    public void volumeHeartbeatLeft() {
        this.this$0.left(8, this.terminalID);
    }

    @Override
    public void volumeNavEntered() {
        this.this$0.entered(0, this.terminalID);
    }

    @Override
    public void volumeNavExited() {
        this.this$0.left(0, this.terminalID);
    }

    @Override
    public void volumeSDSEntered() {
        this.this$0.entered(2, this.terminalID);
    }

    @Override
    public void volumeSDSExited() {
        this.this$0.left(2, this.terminalID);
    }

    @Override
    public void volumeTelEntered() {
        this.this$0.entered(3, this.terminalID);
    }

    @Override
    public void volumeTelExited() {
        this.this$0.left(3, this.terminalID);
    }

    @Override
    public void volumeTelMsgEntered() {
        this.this$0.entered(7, this.terminalID);
    }

    @Override
    public void volumeTelMsgLeft() {
        this.this$0.left(7, this.terminalID);
    }

    @Override
    public void volumeTPEntered() {
        this.this$0.entered(1, this.terminalID);
    }

    @Override
    public void volumeTPExited() {
        this.this$0.left(1, this.terminalID);
    }

    @Override
    public void volumeTouchpadEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(6);
        this.this$0.entered(6, this.terminalID);
    }

    @Override
    public void volumeTouchpadLeft() {
        this.this$0.left(6, this.terminalID);
    }

    @Override
    public void toneSettingsEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(0);
    }

    @Override
    public void tonePhoneEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(1);
    }

    @Override
    public void toneNaviEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(2);
    }

    @Override
    public void toneAnnouncementEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(3);
    }

    @Override
    public void toneSpeechEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(4);
    }

    @Override
    public void toneParkingEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(5);
    }

    @Override
    public void volumeTouchInitEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(6);
    }

    @Override
    public void volumeRingtoneSelectionEntered() {
        this.this$0.entered(9, this.terminalID);
    }

    @Override
    public void volumeRingtoneSelectionLeft() {
        this.this$0.left(9, this.terminalID);
    }

    @Override
    public void volumeTelMicEntered() {
        this.this$0.entered(10, this.terminalID);
    }

    @Override
    public void volumeTelMicLeft() {
        this.this$0.left(10, this.terminalID);
    }

    @Override
    public void volumeWCEntered() {
        this.this$0.entered(11, this.terminalID);
    }

    @Override
    public void volumeWCLeft() {
        this.this$0.left(11, this.terminalID);
    }

    @Override
    public void volumeInfoAnnouncementEntered() {
        this.this$0.entered(12, this.terminalID);
    }

    @Override
    public void volumeInfoAnnouncementLeft() {
        this.this$0.left(12, this.terminalID);
    }

    @Override
    public void WCMenuEntered() {
        this.this$0.env.getChoiceModel(2034372352).setValue(8);
    }
}

