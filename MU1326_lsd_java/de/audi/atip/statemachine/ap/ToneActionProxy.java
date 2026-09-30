/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface ToneActionProxy
extends ActionProxy {
    public void demute(int var1);

    public void volumeTouchpadEntered(int var1);

    public void volumeTouchpadLeft(int var1);

    public void volumeNavEntered(int var1);

    public void volumeNavExited(int var1);

    public void volumeLoweredEntertainmentNaviEntered(int var1);

    public void volumeLoweredEntertainmentNaviLeft(int var1);

    public void volumeTelEntered(int var1);

    public void volumeTelExited(int var1);

    public void volumeTelMsgEntered(int var1);

    public void volumeTelMsgLeft(int var1);

    public void volumeLoweredEntertainmentAPSEntered(int var1);

    public void volumeLoweredEntertainmentAPSLeft(int var1);

    public void volumeTPEntered(int var1);

    public void volumeTPExited(int var1);

    public void volumeSDSEntered(int var1);

    public void volumeSDSExited(int var1);

    public void balanceFaderLeft(int var1);

    public void volumeHeartbeatEntered(int var1);

    public void volumeHeartbeatLeft(int var1);

    public void toneSettingsEntered(int var1);

    public void tonePhoneEntered(int var1);

    public void toneNaviEntered(int var1);

    public void toneAnnouncementEntered(int var1);

    public void toneSpeechEntered(int var1);

    public void toneParkingEntered(int var1);

    public void toneEntered(int var1);

    public void toneSettingsLeft(int var1);

    public void volumeRingtoneSelectionEntered(int var1);

    public void volumeRingtoneSelectionLeft(int var1);

    public void volumeTelMicEntered(int var1);

    public void volumeTelMicLeft(int var1);

    public void volumeTouchInitEntered(int var1);

    public void WCMenuEntered(int var1);

    public void volumeWCLeft(int var1);

    public void volumeWCEntered(int var1);

    public void volumeInfoAnnouncementEntered(int var1);

    public void volumeInfoAnnouncementLeft(int var1);

    public void abortA2LS(int var1);

    public void a2lsPopupMediaTunerAreaEntered(int var1);

    public void a2lsPopupMediaTunerAreaLeft(int var1);
}

