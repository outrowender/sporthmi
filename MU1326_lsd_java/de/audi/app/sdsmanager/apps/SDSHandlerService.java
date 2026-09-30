/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.AbstractSDSService;

public interface SDSHandlerService
extends AbstractSDSService {
    public void abortSDSSession(boolean var1);

    public void sendEvent(int var1);

    public void sendDDSEvent(int var1, int var2);

    public void sendResumeEvent(boolean var1);

    public void sendSpeechSMEvent(int var1, boolean var2, boolean var3);

    public void sendDDSSpeechSMEvent(int var1);

    public void sendResultEvent(int var1);

    public void sendResultEvent(int var1, boolean var2);

    public void sendResult(int var1);

    public boolean isSDSPaused();

    public boolean isSDSWaiting();

    public boolean isExternalSDSRequested();

    public void switchEntertainment(boolean var1);

    public boolean isPTTDisabled();

    public int resetSelectedRow();

    public int getSelectedRow();

    public void setSelectedRow(int var1);

    public int getSelectedModel();

    public void setSelectedModel(int var1);

    public boolean getDDSFlag();

    public void setDDSFlag(boolean var1);

    public void setSDSNumberDialingActive(boolean var1);

    public void triggerPauseStateAbortTimer(boolean var1);

    public void triggerWaitStateAbortTimer(boolean var1);

    public boolean isSDSVolumeSettingActive();

    public void setSDSVolumeSettingActive(boolean var1);

    public void cancelTimers();

    public void turnDDSWheel();

    public void movedDDSJoystick(JoystickEvent var1);

    public boolean isBeepOn();

    public boolean isExpertMode();

    public boolean isQuickMode();

    public boolean isCommandScreen();

    public boolean isVoiceBargeIn();

    public void setAbortWaitingStateOnCorrection(boolean var1);

    public boolean isAbortWaitingStateOnCorrection();

    public void handleLeavingWaitingState();

    public void handleLeavingPauseState();

    public void resetEventID();

    public IFrameworkAccess getFramework();

    public boolean isOnlineRecogResultsInvalid();

    public void setOnlineRecogResultsInvalid(boolean var1);
}

