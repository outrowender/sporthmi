/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.greyout;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;

public class VolumeRangeManagerGreyOutHandler
extends DefaultGreyOutAndPopupHandler {
    public VolumeRangeManagerGreyOutHandler(ChoiceModelApp choiceModelApp, int[] nArray, LogChannel logChannel, String string) {
        super(choiceModelApp, nArray, logChannel, string);
    }

    protected void updateGreyOutState() {
        int n = this.getpopupTriggerModelValueForAnnouncement(this.activeConnection);
        this.log.log(10000000, "[VolumeRangeManagerGreyOutHandler.updateGreyOutState]popupModelValue: %1 ", (long)n);
        this.popupTriggerModel.setValue(n);
    }

    private int getpopupTriggerModelValueForAnnouncement(int n) {
        if (AudioConnection.contains(AudioConnection.CONNECTED_GATEWAY_CONNS, n)) {
            return 6;
        }
        if (AudioConnection.contains(AudioConnection.PHONE_CALL_HANDSFREE, n) || AudioConnection.contains(AudioConnection.PHONE_RINGING, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_PHONE, n)) {
            return 5;
        }
        if (AudioConnection.contains(AudioConnection.NAVI, n) || AudioConnection.contains(AudioConnection.TMC_ALL, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_NAVI_LOWERING, n)) {
            return 3;
        }
        if (AudioConnection.contains(AudioConnection.SDS, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_SPEECH, n)) {
            return 2;
        }
        if (AudioConnection.contains(AudioConnection.TA_PTY31, n) && n != 35) {
            return 4;
        }
        if (4 == n) {
            return 1;
        }
        return 0;
    }
}

