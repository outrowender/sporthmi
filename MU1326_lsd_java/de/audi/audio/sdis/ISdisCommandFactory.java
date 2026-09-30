/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.tghu.command.Command;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import org.dsi.ifc.media.AudioRoute;

public interface ISdisCommandFactory {
    public Command cmdAudioRouteA2LS();

    public Command cmdAudioRouteMedia(AudioRoute var1);

    public Command cmdStartStreaming();

    public Command cmdStopStreaming(boolean var1);

    public Command cmdRequestConf(int var1);

    public Command cmdRequestConf(int var1, int var2);

    public Command cmdAudioFocus(int var1);

    public Command cmdFrontAudioFocus(int var1);

    public Command cmdWaitUntilRadioAudible();

    public Command cmdWaitUntilTVAudible();

    public Command cmdWaitUntilA2LSAudible();

    public Command cmdRegister();

    public Command cmdUnregister();

    public Command cmdSleep();

    public Command cmdSleep(int var1);

    public Command cmdResponseEnableA2LS(ASIHMISyncAudioReply var1);

    public Command cmdRequestA2LS();

    public Command cmdReleaseA2LS();

    public Command cmdSendA2LSReady(int var1);

    public Command cmdSendReady(int var1);

    public Command cmdSendInChange(int var1);

    public Command cmdReleaseSdisAudioConnections();

    public Command cmdSendLockState(VolumeLockState var1);

    public Command cmdFrontLastMode(int var1);

    public Command cmdDemute();
}

